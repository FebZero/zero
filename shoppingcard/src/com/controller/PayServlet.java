package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Book;
import com.bean.CartObject;
import com.service.ShopCartService;

/**
 * Servlet implementation class PayServlet
 */
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String username=request.getParameter("uesrname");
		List<CartObject<Book>> cartList=(List)session.getAttribute("cart");
	
		
		try {
			java.sql.Date date=new java.sql.Date(new java.util.Date().getTime());
			String orderno=System.currentTimeMillis()+"";
		    int	result = new ShopCartService().pay(username,orderno,date, cartList);
			if(result == 0) {
				//删除   购物车
				session.removeAttribute("cart");
				request.setAttribute("cartList", cartList);
				System.out.println(cartList);
				request.getRequestDispatcher("orderinfo.jsp").forward(request, response);	
			}
			else if(result ==1) {
				request.setAttribute("info", "下单失败111");
				request.getRequestDispatcher("error.jsp").forward(request, response);	
			}
			else {
				request.setAttribute("info", "下单失败222");
				request.getRequestDispatcher("error.jsp").forward(request, response);	
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("info", "下单失败333");
			request.getRequestDispatcher("error.jsp").forward(request, response);	
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

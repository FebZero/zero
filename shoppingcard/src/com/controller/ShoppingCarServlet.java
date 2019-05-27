package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Book;
import com.bean.CartObject;

/**
 * Servlet implementation class ShoppingCarServlet
 */
public class ShoppingCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("utf-8");
		 String id=request.getParameter("id");
		 String picture=request.getParameter("picture");
		 String bookname=request.getParameter("bookname");
		 String isbn=request.getParameter("isbn");
		 String  author=request.getParameter("author");
		 String  press=request.getParameter("press");
		 String price=request.getParameter("price");
		 
		 Book book=new Book(Integer.valueOf(id), picture, bookname, isbn, author, press, price);
		 
		 HttpSession session=request.getSession();
		 List<CartObject> cart=(List<CartObject>)session.getAttribute("cart");
		 if(null ==cart) {
			 cart=new ArrayList<>();
			 CartObject<Book> cartobject=new CartObject<Book>();
			 cartobject.setProduct(book);
	         cartobject.setCount(1);
	         cart.add(cartobject);
			 session.setAttribute("cart", cart);
		 }
		 else {
			 boolean flag=false;
			 for(CartObject<Book> cartObject:cart) {
				if(cartObject.getProduct().getId() == book.getId()) {
					cartObject.setCount(cartObject.getCount()+1);
					flag=true;
					break;
				}
			 }
			 if(!flag) {
				 CartObject<Book> cartobject=new CartObject<Book>();
		         cartobject.setProduct(book);
		         cartobject.setCount(1);
		         cart.add(cartobject);
			 }		 
		 }
		 request.getRequestDispatcher("shopcart.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

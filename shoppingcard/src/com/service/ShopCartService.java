package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Book;
import com.bean.CartObject;
import com.bean.OrderInfo;
import com.bean.OrderItems;
import com.dao.BookDao;
import com.dao.OrderInfoDao;
import com.dao.OrderItemsDao;
import com.dao.UserDao;

public class ShopCartService {
 
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn = null;
	
	public int pay(String username,String orderno,java.sql.Date orderTime,List<CartObject<Book>> cartList) throws ClassNotFoundException, SQLException  {	
	
		UserDao userdao=new UserDao();
		Integer uid=userdao.selectIdByUsername(username);
//		java.sql.Date date=new java.sql.Date(new java.util.Date().getTime());
		OrderInfo orderInfo=new OrderInfo(null,orderno,uid,orderTime); 
		OrderInfoDao orderInfoDao=new OrderInfoDao();
	
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		
		conn = DriverManager.getConnection(url, "zero", "123456");
		//打开事务
		conn.setAutoCommit(false);
		//1插入订单
		int orderId=orderInfoDao.insertOne(conn,orderInfo);
		//2下订单
		OrderItemsDao orderItemsDao=new OrderItemsDao();
		BookDao bookdao=new BookDao();
//		List<OrderItems> orderItemsList=new ArrayList<>();
		for (CartObject<Book> cartObject : cartList) {
			//得到该书的库存
			int left=bookdao.selectLeftById(conn,cartObject.getProduct().getId());
		    if(left < cartObject.getCount()) {
		    	return 1;		    	
		    }		    
		  //更新库存
		    bookdao.updateLeftById(conn, left-cartObject.getCount(), cartObject.getProduct().getId());		   
		    //插入订单详细表
		    orderItemsDao.insertOne(
		    		new OrderItems(null, orderId, cartObject.getProduct().getId(), cartObject.getCount()));
		}
		 return  0;	
		 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return 2;
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}

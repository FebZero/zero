package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.bean.OrderInfo;
import com.bean.OrderItems;

public class OrderItemsDao {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn = null;
	public void insertmany(List<OrderItems> orderItemsList) throws SQLException, ClassNotFoundException  {
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection(url, "zero", "123456");
		
		String sql="insert into orderitems value(se_orderitems.nextval,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		for (OrderItems orderItems : orderItemsList) {
			pstmt.setInt(1,orderItems.getOrderId());
			pstmt.setInt(2, orderItems.getBookId());
			pstmt.setInt(3, orderItems.getCount());
			pstmt.addBatch();
		}
		pstmt.executeBatch();
		}finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	public void insertOne(OrderItems orderItems) throws SQLException, ClassNotFoundException  {
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection(url, "zero", "123456");
		
		String sql="insert into orderitems values(se_orderitems.nextval,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);		
			pstmt.setInt(1,orderItems.getOrderId());
			pstmt.setInt(2, orderItems.getBookId());
			pstmt.setInt(3, orderItems.getCount());
		pstmt.executeUpdate();
		}finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	
}

package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Book;

public class BookDao {

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn = null;
	
	public List<Book> queryByCondition() throws ClassNotFoundException, SQLException {
//		   try { 
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "zero", "123456");
			String sql = "select* from booksinfo";
			
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();			
	    	List<Book> list=new ArrayList<>();
			while(rs.next()) {			
				Integer id=rs.getInt("id");
				String picture=rs.getString("picture");
				String bookname=rs.getString("bookname");
				String  isbn=rs.getString("isbn");
				String  author=rs.getString("author");
				String  press=rs.getString("press");
				String  price=rs.getString("price");
				list.add(new Book(id,picture,bookname,isbn,author,press,price));
			}
			return list;
//		   }finally {
//			   if(conn!=null) {
//		        conn.close();
//		      }		
//		  } 
		}
	
	public int selectLeftById(Connection conn,Integer id) throws ClassNotFoundException, SQLException {
//		   try { 
//			Class.forName("oracle.jdbc.OracleDriver");
//			conn = DriverManager.getConnection(url, "zero", "123456");
			String sql = "select left from booksinfo  where id=?";			
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();	
			rs.next();
			return rs.getInt(1);
//		   }finally {
//			   if(conn!=null) {
//		        conn.close();
//		      }		
//		  } 
		}
	
	public void updateLeftById(Connection conn,int left,Integer id) throws SQLException {
		String sql = "update booksinfo set left=?  where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, left);
		pstmt.setInt(2, id);
		ResultSet rs=pstmt.executeQuery();	
	}
	
	
}

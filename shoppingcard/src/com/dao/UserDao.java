package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Book;


public class UserDao {

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn = null;
	public int selectCountByUsernameAndPassword(String username,String password) throws SQLException, ClassNotFoundException  {
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection(url, "zero", "123456");
		String sql = "select count(username) from userinfo where username =?and password=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
	    ResultSet rs = pstmt.executeQuery();
	    rs.next();   
	    return rs.getInt(1);
		}finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	public int selectIdByUsername(String username) throws SQLException, ClassNotFoundException  {
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection(url, "zero", "123456");
		String sql = "select id from userinfo where username =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, username);
	    ResultSet rs = pstmt.executeQuery();
	    if(rs.next()) {  
	    	return rs.getInt(1);
	    }
	    return -1;
		}finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	
	
}

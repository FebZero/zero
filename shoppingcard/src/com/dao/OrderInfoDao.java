package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bean.OrderInfo;

public class OrderInfoDao {

//	String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	Connection conn = null;
	public int insertOne(Connection conn,OrderInfo orderInfo) throws SQLException, ClassNotFoundException  {
//		try{
//		Class.forName("oracle.jdbc.OracleDriver");
//		conn = DriverManager.getConnection(url, "zero", "123456");
		String selectSequence = "select se_orderinfo.nextval from dual";
		Statement stmt = conn.createStatement();
		ResultSet seRs = stmt.executeQuery(selectSequence);
		seRs.next();
		int se=seRs.getInt(1);
		
		String sql="insert into orderinfo values(?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, se);
		pstmt.setString(2, orderInfo.getOrderno());
		pstmt.setInt(3, orderInfo.getUserid());
		pstmt.setDate(4, orderInfo.getOrderTime());
	    pstmt.executeUpdate();
	    return se;
//		}finally {
//			if(conn != null) {
//				conn.close();
//			}
//		}
	}
	
	
}

package com.service;

import java.sql.SQLException;

import com.dao.UserDao;

public class UserService {

	private UserDao userdao=new UserDao();
	public boolean checkLogin(String username,String password) throws ClassNotFoundException, SQLException {
		
		int count=userdao.selectCountByUsernameAndPassword(username, password);	
		return count==1?true:false;
	}
	
	
}

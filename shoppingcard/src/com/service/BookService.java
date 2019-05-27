package com.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bean.Book;
import com.dao.BookDao;



public class BookService {
	private BookDao userdao=new BookDao();
	public List<Book> queryBooksByCondition() throws ClassNotFoundException, SQLException{
		return userdao.queryByCondition();
	}
}

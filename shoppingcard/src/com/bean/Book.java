package com.bean;

public class Book {

	private Integer id;
	private String picture;
	private String bookname;
	private String isbn;
	private String  author;
	private String  press;
	private String price;
	private int left;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}	
	
	
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}
	
	public Book(Integer id, String picture, String bookname, String isbn, String author, String press, String price) {
		super();
		this.id = id;
		this.picture = picture;
		this.bookname = bookname;
		this.isbn = isbn;
		this.author = author;
		this.press = press;
		this.price = price;
	}
	
	
	public Book() {
		super();
	}
	
	
	
	
	
	
	
}

package com.bean;

public class OrderItems {

	private Integer id;
	private Integer orderId;
	private Integer bookId;
	private Integer count;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public OrderItems(Integer id, Integer orderId, Integer bookId, Integer count) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.bookId = bookId;
		this.count = count;
	}
	public OrderItems() {
		super();
	}
	@Override
	public String toString() {
		return "OrderItems [id=" + id + ", orderId=" + orderId + ", bookId=" + bookId + ", count=" + count + "]";
	}
	
	
	
}

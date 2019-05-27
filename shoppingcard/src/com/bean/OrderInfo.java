package com.bean;

import java.sql.Date;

public class OrderInfo {
 private Integer id;
 private String orderno;
 private Integer userid;
 private Date orderTime;
 
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getOrderno() {
	return orderno;
}
public void setOrderno(String orderno) {
	this.orderno = orderno;
}
public Integer getUserid() {
	return userid;
}
public void setUserid(Integer userid) {
	this.userid = userid;
}
public Date getOrderTime() {
	return orderTime;
}
public void setOrderTime(Date orderTime) {
	this.orderTime = orderTime;
}
public OrderInfo(Integer id, String orderno, Integer userid, Date orderTime) {
	super();
	this.id = id;
	this.orderno = orderno;
	this.userid = userid;
	this.orderTime = orderTime;
}
public OrderInfo() {
	super();
}

@Override
public String toString() {
	return "OrderInfo [id=" + id + ", orderno=" + orderno + ", userid=" + userid + ", orderTime=" + orderTime + "]";
}
 
 
 
}

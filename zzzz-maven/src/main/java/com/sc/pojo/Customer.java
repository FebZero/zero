package com.sc.pojo;

public class Customer {
private Long id;

private String name;

private String cardno;

private String phone;

private String email;

private String address;

private Integer ctid;

private String vip;

public String getVip() {
	return vip;
}

public void setVip(String vip) {
	this.vip = vip;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCardno() {
	return cardno;
}

public void setCardno(String cardno) {
	this.cardno = cardno;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public Integer getCtid() {
	return ctid;
}

public void setCtid(Integer ctid) {
	this.ctid = ctid;
}

@Override
public String toString() {
	return "Customer [id=" + id + ", name=" + name + ", cardno=" + cardno + ", phone=" + phone + ", email=" + email
			+ ", address=" + address + ", ctid=" + ctid + ", vip=" + vip + "]";
}

}

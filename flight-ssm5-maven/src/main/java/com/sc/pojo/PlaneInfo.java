package com.sc.pojo;


import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;
@Alias("Plane")
public class PlaneInfo {

	private Integer id;
	
	private String type;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private java.util.Date buyDate;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private java.util.Date serviceDate;
	
	private String planeno;
	
	public String getPlaneno() {
		return planeno;
	}

	public void setPlaneno(String planeno) {
		this.planeno = planeno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public void setServiceDate(java.sql.Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	public PlaneInfo(Integer id, String type, Date buyDate, Date serviceDate) {
		super();
		this.id = id;
		this.type = type;
		this.buyDate = buyDate;
		this.serviceDate = serviceDate;
	}

	
	public java.util.Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(java.util.Date buyDate) {
		this.buyDate = buyDate;
	}

	public java.util.Date getServiceDate() {
		return serviceDate;
	}

	public PlaneInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PlaneInfo [id=" + id + ", type=" + type + ", buyDate=" + buyDate + ", serviceDate=" + serviceDate
				+ ", planeno=" + planeno + "]";
	}
	
	
}

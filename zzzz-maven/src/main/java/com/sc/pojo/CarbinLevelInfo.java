package com.sc.pojo;

import org.apache.ibatis.type.Alias;

@Alias("CarbinLevel")
public class CarbinLevelInfo {

	private Integer id;
	
	private String name;
	
	private String service;
	
	private String remarks;

	public CarbinLevelInfo(Integer id, String name, String service, String remarks) {
		this.id = id;
		this.name = name;
		this.service = service;
		this.remarks = remarks;
	}

	public CarbinLevelInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "CarbinLevelInfo [id=" + id + ", name=" + name + ", service=" + service + ", remarks=" + remarks + "]";
	}
	
	
}

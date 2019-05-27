package com.sc.pojo;
import org.apache.ibatis.type.Alias;
@Alias("Route")
public class RouteInfo {

	private Integer id;
	
	private String fromCity;
	
	private String toCity;
	
	private String remarks;

	public RouteInfo(Integer id, String fromCity, String toCity, String remarks) {
		this.id = id;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.remarks = remarks;
	}
	
	public RouteInfo() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "RoutInfo [id=" + id + ", fromCity=" + fromCity + ", toCity=" + toCity + ", remarks=" + remarks + "]";
	}
	
}

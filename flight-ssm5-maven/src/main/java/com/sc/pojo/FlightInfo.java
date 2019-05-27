package com.sc.pojo;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
@Alias("Flight")//MyBatis的对象别名
public class FlightInfo {

	private Long id;
	
	private String fno;
	
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm",timezone="GMT+8")
	private java.util.Date fromDate;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm",timezone="GMT+8")
	private java.util.Date toDate;
	
	private String type;
	
	private PlaneInfo plane;
	
	private RouteInfo route;
	
	private Integer routeId;
	
	private Integer planeId;
	
	
	public Integer getPlaneId() {
		return planeId;
	}

	public void setPlaneId(Integer planeId) {
		this.planeId = planeId;
	}

	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	private List<FlightCarbinInfo> fcList;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFno() {
		return fno;
	}

	public void setFno(String fno) {
		this.fno = fno;
	}


	public java.util.Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(java.util.Date fromDate) {
		this.fromDate = fromDate;
	}

	public java.util.Date getToDate() {
		return toDate;
	}

	public void setToDate(java.util.Date toDate) {
		this.toDate = toDate;
	}

	public PlaneInfo getPlane() {
		return plane;
	}

	public void setPlane(PlaneInfo plane) {
		this.plane = plane;
	}

	public RouteInfo getRoute() {
		return route;
	}

	public void setRoute(RouteInfo route) {
		this.route = route;
	}

	public List<FlightCarbinInfo> getFcList() {
		return fcList;
	}

	public void setFcList(List<FlightCarbinInfo> fcList) {
		this.fcList = fcList;
	}

	public FlightInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FlightInfo [id=" + id + ", fno=" + fno + ", fromDate=" + fromDate + ", toDate=" + toDate + ", type="
				+ type + ", plane=" + plane + ", route=" + route + ", routeId=" + routeId + ", planeId=" + planeId
				+ ", fcList=" + fcList + "]";
	}

	
}

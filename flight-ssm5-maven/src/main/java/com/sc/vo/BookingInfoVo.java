package com.sc.vo;
/**
 * 只是为了方便值传递
 * @author 晨
 *
 */
public class BookingInfoVo {
	
	private String fno;

	private String route;
	
	private String flightType;
	
	private String fromDate;
	
	private String toDate;
	
	private String planeType;
	
	private String carbinLevel;
	
	private String price;

	
	public String getFno() {
		return fno;
	}

	public void setFno(String fno) {
		this.fno = fno;
	}

	public String getCarbinLevel() {
		return carbinLevel;
	}

	public void setCarbinLevel(String carbinLevel) {
		this.carbinLevel = carbinLevel;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getFlightType() {
		return flightType;
	}

	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getPlaneType() {
		return planeType;
	}

	public void setPlaneType(String planeType) {
		this.planeType = planeType;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookingInfoVo [fno=" + fno + ", route=" + route + ", flightType=" + flightType + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", planeType=" + planeType + ", carbinLevel=" + carbinLevel
				+ ", price=" + price + "]";
	}
	
}

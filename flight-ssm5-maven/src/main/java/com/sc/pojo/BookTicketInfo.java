package com.sc.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BookTicketInfo {

	private Long id;
	
	private String btno;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm",timezone="GMT+8")
	private Date bookDate;
	
	private Integer payState;
	
	private Long fcid;
	
	private Long cid;
	
	private Double price;

	private Customer customer;
	
	private FlightCarbinInfo flightCarbin;
	
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBtno() {
		return btno;
	}

	public void setBtno(String btno) {
		this.btno = btno;
	}

	public Date getBookDate() {
		return bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}

	public Integer getPayState() {
		return payState;
	}

	public void setPayState(Integer payState) {
		this.payState = payState;
	}

	public Long getFcid() {
		return fcid;
	}

	public void setFcid(Long fcid) {
		this.fcid = fcid;
	}

	public FlightCarbinInfo getFlightCarbin() {
		return flightCarbin;
	}

	public void setFlightCarbin(FlightCarbinInfo flightCarbin) {
		this.flightCarbin = flightCarbin;
	}

	@Override
	public String toString() {
		return "BookTicketInfo [id=" + id + ", btno=" + btno + ", bookDate=" + bookDate + ", payState=" + payState
				+ ", fcid=" + fcid + ", cid=" + cid + ", price=" + price + ", customer=" + customer + ", flightCarbin="
				+ flightCarbin + "]";
	}
	
	
	
}

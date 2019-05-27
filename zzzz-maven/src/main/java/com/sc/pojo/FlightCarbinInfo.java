package com.sc.pojo;

public class FlightCarbinInfo {

	private Long id;
	
	private FlightInfo flight;
	
	private CarbinLevelInfo carbinLevel;
	
	private Double price;
	
	private Integer seats;
	
	private Long fid;
	
	private Integer clid;
	
	private long version;
	
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public Integer getClid() {
		return clid;
	}

	public void setClid(Integer clid) {
		this.clid = clid;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FlightInfo getFlight() {
		return flight;
	}

	public void setFlight(FlightInfo flight) {
		this.flight = flight;
	}

	public CarbinLevelInfo getCarbinLevel() {
		return carbinLevel;
	}

	public void setCarbinLevel(CarbinLevelInfo carbinLevel) {
		this.carbinLevel = carbinLevel;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public FlightCarbinInfo(Long id, FlightInfo flight, CarbinLevelInfo carbinLevel, Double price, Integer seats) {
		super();
		this.id = id;
		this.flight = flight;
		this.carbinLevel = carbinLevel;
		this.price = price;
		this.seats = seats;
	}

	public FlightCarbinInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FlightCarbinInfo [id=" + id + ", flight=" + flight + ", carbinLevel=" + carbinLevel + ", price=" + price
				+ ", seats=" + seats + ", fid=" + fid + ", clid=" + clid + ", version=" + version + "]";
	}
	
	
}

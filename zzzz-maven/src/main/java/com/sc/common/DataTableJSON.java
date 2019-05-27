package com.sc.common;

import java.util.List;

public class DataTableJSON<E> {
	   private List<E> data;
	   
	   private long recordsTotal;
	   
	   private long recordsFiltered;
	   
	   private int draw;
	   
	   private String error;

	public List<E> getData() {
		return data;
	}

	public void setData(List<E> data) {
		this.data = data;
	}

	public long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "DataTableJSON [data=" + data + ", recordsTotal=" + recordsTotal + ", recordsFiltered=" + recordsFiltered
				+ ", draw=" + draw + ", error=" + error + "]";
	}
	   
	   
}

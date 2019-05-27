package com.sc.common;

import java.util.ArrayList;
import java.util.List;

public class DataTableEditorJSON<E> {

	private List<E> data;
	
	private String error;
	
	private List<FieldError> fieldErrors = new ArrayList<>();
	
	
	public void addfieldError(String name,String status) {
		FieldError fe = new  FieldError(name,status);
		fieldErrors.add(fe);
	}
	
	public List<E> getData() {
		return data;
	}

	public void setData(List<E> data) {
		this.data = data;
	}


	public String getError() {
		return error;
	}




	public void setError(String error) {
		this.error = error;
	}




	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}




	public void setFieldErrors(List<FieldError> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}




	private class FieldError{
		
		private String name;
		
		private String status;

		@Override
		public String toString() {
			return "FieldError [name=" + name + ", status=" + status + "]";
		}

		public FieldError(String name, String status) {
			super();
			this.name = name;
			this.status = status;
		}
		
		
	}
}

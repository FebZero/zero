package com.bean;

public class CartObject<T> {

	private T product;
	
	private int count;

	public T getProduct() {
		return product;
	}

	public void setProduct(T product) {
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public CartObject() {
		super();
	}

	public CartObject(T product, int count) {
		super();
		this.product = product;
		this.count = count;
	}
	
	
	
}

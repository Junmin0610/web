package com.danta.batch.model;

public class Bid {
	private double quantity;
	private int price;
	public Bid() {
		
	}
	public Bid(double quantity, int price) {
		this.quantity = quantity;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Ask [quantity=" + quantity + ", price=" + price + "]";
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}

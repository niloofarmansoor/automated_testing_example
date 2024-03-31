package com.shoppingcart.maven.classes;

public class Item {
	
	private String itemName;
	private double price;
	private int quantity;
	
	public Item(String itemName, double price, int quantity) {
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public int getQuantity() {
		return quantity;
	}

}

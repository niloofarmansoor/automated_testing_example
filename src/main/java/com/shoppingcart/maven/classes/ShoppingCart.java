package com.shoppingcart.maven.classes;

import java.util.ArrayList;

public class ShoppingCart {
	
private ArrayList<Item> items;
	
    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
	
    public double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    public void displayItems() {
        System.out.println("Items in the cart:");
        for (Item item : items) {
            System.out.println(item.getItemName() + " - $" + item.getPrice() + " x " + item.getQuantity());
        }
    }
    
	public ArrayList<Item> getItems() {
		return items;
	}


}

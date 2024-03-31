package com.shoppingcart.maven.classes;

import java.util.ArrayList;

public class ShoppingCart {
	
    private ArrayList<Item> items;
    private String appliedCoupon;
	
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
    	System.out.println("Cart Total: $" + total);

        // Apply coupon if one is applied
        if (appliedCoupon != null && !appliedCoupon.isEmpty()) {
            Coupon newCoupon = new Coupon(appliedCoupon);
            total = newCoupon.applyCoupon(total, appliedCoupon);
            System.out.println("Cart Total After Coupon: $" + total);
        }

        return total;
    }

    public void addCouponToCart(String couponCode) {
        this.appliedCoupon = couponCode;
    }
    
    public void removeCoupon() {
        this.appliedCoupon = null;
    }

    public void displayItems() {
        System.out.println("Items in the cart:");
        for (Item item : items) {
            System.out.println(item.getItemName() + " - $" + item.getPrice() + " x " + item.getQuantity());
        }
        if (appliedCoupon != null && !appliedCoupon.isEmpty()) {
            System.out.println("Coupon was applied: " + appliedCoupon);
        }
    }
    
	public ArrayList<Item> getItems() {
		return items;
	}


}

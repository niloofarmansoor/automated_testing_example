package com.shoppingcart.maven.classes;

public class App 
{
    public static void main( String[] args )
    {
    	//Create some items
    	Item item1 = new Item("Laptop", 989.99, 1);
    	Item item2 = new Item("Headphones", 359.99, 1);
    	Item item3 = new Item("Charger", 34.99, 1);
    			
    	//Create a shopping cart
    	ShoppingCart cart = new ShoppingCart();
    			
    	//Add items to cart
    	cart.addItem(item1);
    	cart.addItem(item2);
    	cart.addItem(item3);
    			
    	//Display items in cart
    	cart.displayItems();

    	//Calculate and show total price
    	double total = cart.calculateTotal();
    			
    			
    	//Process Payment
    	String message = Payment.processPayment(total, "Discover", 
    								"1445460152597412", 
    	        					"458", 
    	        					"01/25", 
									false);
    	        
    	System.out.println(message);

		System.out.println("Second run");

		ShoppingCart cart2 = new ShoppingCart();
    			
    	//Add items to cart
    	cart2.addItem(item1);
    	cart2.addItem(item2);
		cart2.addCouponToCart("Free");

		cart2.displayItems();
		
    	double total2 = cart2.calculateTotal();


    	String message2 = Payment.processPayment(total2, "Discover", 
    								"1445460152597412", 
    	        					"458", 
    	        					"01/25",
									true);
    	        
    	System.out.println(message2);
		
    }
}

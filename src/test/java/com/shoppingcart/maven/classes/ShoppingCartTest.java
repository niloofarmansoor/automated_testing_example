package com.shoppingcart.maven.classes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ShoppingCartTest {
	
	@Test
    public void testAddItem() {
        ShoppingCart cart = new ShoppingCart();
        Item item = new Item("TestItem", 10.0, 1);
        cart.addItem(item);
        assertTrue(cart.getItems().contains(item));
    }

    @Test
    public void testRemoveItem() {
        ShoppingCart cart = new ShoppingCart();
        Item item = new Item("TestItem", 10.0, 1);
        cart.addItem(item);
        cart.removeItem(item);
        assertFalse(cart.getItems().contains(item));
    }

    @Test
    public void testCalculateTotal() {
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("Item1", 10.0, 2);
        Item item2 = new Item("Item2", 20.0, 1);
        cart.addItem(item1);
        cart.addItem(item2);
        assertEquals(40.0, cart.calculateTotal(), 0.001);
    }

    @Test
    public void testCalculateTotal2() {
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("Item1", 10.0, 2);
        Item item2 = new Item("Item4", 999.99, 1);
        cart.addItem(item1);
        cart.addItem(item2);
        assertEquals(1019.99, cart.calculateTotal(), 0.001);
    }

}

package com.shoppingcart.maven.classes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PaymentTest {
	
	@Test
    public void testProcessPaymentSuccess() {
        String message = Payment.processPayment(100.0, "Visa", "1234567890123456", "123", "01/25");
        assertEquals("Payment of $100.0 processed successfully.", message);
    }

    @Test
    public void testProcessPaymentFailure() {
        String message = Payment.processPayment(100.0, "MasterCard", "12345", "123", "01/25");
        assertEquals("Payment rejected due to wrong card information.", message);
    }

    @Test
    public void testCheckCard() {
        assertTrue(Payment.checkCard("Visa", "1234567890123456", "123", "01/25"));
        assertFalse(Payment.checkCard("MasterCard", "12345", "123", "01/25"));
    }

}

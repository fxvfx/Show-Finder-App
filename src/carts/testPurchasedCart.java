package carts;
/**
 * @author Tariq Scott
 * Testing PurchasedCart.java
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tickets.Ticket;

class testPurchasedCart {
	
	Ticket ticket = new Ticket(null, null, 0);

	@Test
	void testRefundTicket() {
		PurchasedCart purchasedCart = new PurchasedCart();
		assertTrue(purchasedCart.refundTicket(ticket));
	}

}

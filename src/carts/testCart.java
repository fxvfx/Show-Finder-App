package carts;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
/**
 * @author Tariq Scott
 * Testing Cart.java
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tickets.Ticket;
import tickets.TicketList;

class testCart {

	Ticket ticket = new Ticket(null, null, 0);
	TicketList newTickets = new TicketList();
	
	@Test
	void testAddTickets_PurchasingTickets_ShouldReturnTrue() {
		Cart cart = new Cart();
		TicketList newTickets = new TicketList();
		assertTrue(cart.addTickets(newTickets));
	}
	
	@Test
	void testRemoveTickets() {
		Cart cart = new Cart();
		TicketList newTickets = new TicketList();
		assertTrue(cart.removeTickets(newTickets));
	}
	
	@Test
	void testShowTickets() {
		Cart cart = new Cart();
		String ticketString = "";
		assertNotNull(cart);
	}
	
	@Test
	void testToString_CartContents_ShouldReturnNothing() {
		Cart cart = new Cart();
		assertNotNull(cart, "");
	}
}

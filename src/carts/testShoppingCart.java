package carts;
/**
 * @author Tariq Scott
 * Testing ShoppingCart.java
 */
import static org.junit.jupiter.api.Assertions.*;

import tickets.*;

import org.junit.jupiter.api.Test;

import shows.Show;
import tickets.Ticket;
import tickets.Ticket;
class testShoppingCart {
	
	private Show show;
	Ticket ticket = new Ticket(show, null, 0);
	ShoppingCart buySeat = new ShoppingCart();

	@Test
	void testGetTotal() {
		ShoppingCart shoppingCart = new ShoppingCart();
		assertEquals(0,shoppingCart.getTotal());
	}
	
	@Test
	void testBuyTicket() {
		ShoppingCart shoppingCart = new ShoppingCart();
		assertTrue(shoppingCart.buyTicket(0, show));
	}
	
	@Test
	void testBuySeat() {
		ShoppingCart shoppingCart = new ShoppingCart();
		assertTrue(shoppingCart.buySeat(0, show, null));
	}
	
	@Test
	void testBuyTheater() {
		ShoppingCart shoppingCart = new ShoppingCart();
		assertTrue(shoppingCart.buyTheater(show));
	} 
	
	@Test
	void testRemoveTicket() {
		ShoppingCart shoppingCart = new ShoppingCart();
		assertNotEquals(shoppingCart, shoppingCart.removeTicket(ticket));
	}

	

}

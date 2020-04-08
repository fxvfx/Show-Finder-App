package carts;

import tickets.*;

/**
 * 
 * @author Tariq Scott
 * @editor Francis Vilanueva
 *
 */

public class PurchasedCart extends Cart{
	public PurchasedCart() {
		super();
	}
	
	/**
	 * TODO: check if this is redundant/i should just add it to the Cart abstract class
	 * Refunds a previously purchased ticket
	 * @param ticket that needs to be refunded
	 */
	public void refundTicket(Ticket ticket) {
		tickets.remove(ticket);
		ticket.getShow().getSeats().refundTicket(ticket);
	}
}

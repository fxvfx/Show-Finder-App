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
	 * Refunds a previously purchased ticket
	 * @param ticket that needs to be refunded
	 */
	public boolean refundTicket(Ticket ticket) {
		tickets.remove(ticket);
		//ticket.getShow().getSeats().refundTicket(ticket);
		return true;
	}
}

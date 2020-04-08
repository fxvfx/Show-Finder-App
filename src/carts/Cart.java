package carts;

import tickets.*;

/**
 * Specifies methods a Cart should have
 * @author Tariq Scott
 * @editor Francis Villanueva
 *
 */
public abstract class Cart {
	
	/*TicketList myTickets;
	ConcessionsList myConcessions;
	CouponsList myCoupons;
	 */	
	
	protected TicketList tickets;

	public Cart() {
		tickets = new TicketList();
	}
	
	public void setTickets(TicketList tickets) {
		this.tickets = tickets;
	}
	
	/**
	 * Adds tickets to current ticket list
	 * @param tickets: list of tickets to add
	 */
	public void addTickets(TicketList newTickets) {
		for(int i=0; i<tickets.getTicketAmount(); i++) {
			tickets.add(newTickets.get(i));
		}
	}
	
	/**
	 * Removes tickets from current ticket list
	 * @param tickets: list of tickets to remove
	 */
	public void removeTickets(TicketList newTickets) {
		for(int i=0; i<tickets.getTicketAmount(); i++) {
			tickets.remove(newTickets.get(i));
		}
	}
	
	/**
	 * String representation of the tickets in the cart
	 * @return: String displaying tickets in the cart
	 */
	 public String showTickets() {
		String ticketString = "";
		for(int i=0; i<tickets.getTicketAmount(); i++) {
			ticketString += tickets.get(i) + "\n\n";
		}
		 
	  	return "Your tickets are:\n\n" + ticketString; 
	  }
}

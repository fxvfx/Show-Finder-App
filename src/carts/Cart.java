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
	
	/**
	 * Adds tickets to current ticket list
	 * @param tickets: list of tickets to add
	 * @return true if tickets added, false otherwise
	 */
	public boolean addTickets(TicketList newTickets) {
		if(newTickets == null)
			return false;
		for(int i=0; i<newTickets.getTicketAmount(); i++) {
			tickets.add(newTickets.get(i));
		}
		return true;
	}
	
	/**
	 * Removes tickets from current ticket list
	 * @param tickets: list of tickets to remove
	 */
	public void removeTickets(TicketList newTickets) {
		for(int i=0; i<newTickets.getTicketAmount(); i++) {
			tickets.remove(newTickets.get(i));
		}
	}
	
	/**
	 * String representation of the purchased tickets
	 * @return String representation of the Cart's tickets
	 */
	public String showTickets() {
		String ticketString = "";
		for(int i=0; i<tickets.getTicketAmount(); i++) {
			ticketString += tickets.get(i) + "\n\n";
		}
		 
	  	return "Your tickets are:\n\n" + ticketString; 
	  }
	
	/**
	 * String representation of the contents of the cart
	 * @return: String displaying contents of the cart
	 */
	 public String toString() {
		String cartContents = "";
		cartContents += showTickets();
		
		return cartContents;
	 }
}

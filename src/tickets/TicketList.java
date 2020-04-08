package tickets;

import java.util.LinkedList;

/**
 * Keeps track of a show's Tickets
 * @author Francis Villanueva
 *
 */
public class TicketList {
	
	int availableSeats;
	private LinkedList<Ticket> tickets;
	
	public TicketList() {
		tickets = new LinkedList<Ticket>();
		availableSeats = 0;
	}
	
	/**
	 * Returns amount of tickets available
	 * @return: amount of tickets
	 */
	public int getTicketAmount() {
		return availableSeats;
	}
	
	/**
	 * Retrieves a ticket at an indicated index
	 * @param index: index of ticket
	 * @return: ticket
	 */
	public Ticket get(int index) {
		return tickets.get(index);
	}
	
	/**
	 * Adds a ticket to the List
	 * @param ticket:  ticket to be added
	 */
	public void add(Ticket ticket) {
		tickets.add(ticket);
		availableSeats++;
	}
	
	/**
	 * Purchases a ticket from the TicketList by setting its status to "taken"
	 * @param index: index of ticket to be removed
	 */
	public void purchase(Ticket ticket) {
		ticket.setIsTaken(true);
	}
	
	/**
	 * Marks ticket as available for purchase again
	 * @param ticket: ticket to be refunded
	 */
	public void refund(Ticket ticket) {
		ticket.setIsTaken(false);
	}
	
}

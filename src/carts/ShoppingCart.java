package carts;

import shows.Show;
import tickets.*;

/**
 * Cart where the user purchases items
 * @author Tariq Scott
 * @editor Francis Villanueva
 *
 */

public class ShoppingCart extends Cart{
	private double netCheckoutPrice;
	
	public ShoppingCart() {
		super();
		netCheckoutPrice = 0;
	}
	
	/**
	 * Calculates and returns price of all ShoppingCart items
	 * @return: total price of all items in the ShoppingCart
	 */
	public double getTotal() {
		double total = 0.0;
		for(int i=0; i<tickets.getNumSeats(); i++) {
			total += tickets.get(i).getPrice();
		}
		netCheckoutPrice = total;
		return netCheckoutPrice;
	}
	
	/**
	 * Buys tickets to a specific show
	 * @param amount: number of tickets to be bought
	 * @param show: the show the tickets will be bought from
	 * @return 
	 */
	public boolean buyTicket(int amount, Show show) {
		if(amount < 0 || show == null)
			return false;
		TicketList boughtTickets = show.getSeats().buyTicket(amount);
		return this.addTickets(boughtTickets);
	}
	
	/**
	 * Buys tickets to a specific show at a specific seat
	 * @param amount: number of tickets to be bought
	 * @param show: the show the tickets will be bought from
	 * @param seat: the first desired seat
	 * @return true if seat bought, false otherwise
	 */
	public boolean buySeat(int amount, Show show, String seat) {
		if(amount < 0)
			return false;
		TicketList boughtTickets = show.getSeats().buyTicket(amount, Integer.parseInt(seat.substring(0,1)), seat.substring(1));
		return addTickets(boughtTickets);
	}
	/**
	 * Buys all the remaining tickets to a specific show
	 * @param show: the show to be bought out
	 */
	public boolean buyTheater(Show show) {
		TicketList boughtTickets = show.getSeats().buyTheater();
		return this.addTickets(boughtTickets);
	}
	
	/**
	 * Removes ticket from cart, then refunds ticket to the show
	 * @param show: the show to be refunded to
	 * @param seatID: the ID of the seat to be refunded to
	 */
	public boolean removeTicket(Ticket ticket) {
		tickets.remove(ticket);
		return ticket.getShow().getSeats().refundTicket(ticket);
		//return removeTicket(ticket);
	}
 	 
}
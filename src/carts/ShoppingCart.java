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
	 */
	public void buyTicket(int amount, Show show) {
		if(amount < 0)
			return;
		TicketList boughtTickets = show.getSeats().buyTicket(amount);
		this.addTickets(boughtTickets);
	}
	
	/**
	 * Buys tickets to a specific show at a specific seat
	 * @param amount: number of tickets to be bought
	 * @param show: the show the tickets will be bought from
	 * @param seat: the first desired seat
	 */
	public void buySeat(int amount, Show show, String seat) {
		if(amount < 0)
			return;
		TicketList boughtTickets = show.getSeats().buyTicket(amount, Integer.parseInt(seat.substring(0,0)), seat.substring(1));
		addTickets(boughtTickets);
	}
	/**
	 * Buys all the remaining tickets to a specific show
	 * @param show: the show to be bought out
	 */
	public void buyTheater(Show show) {
		TicketList boughtTickets = show.getSeats().buyTheater();
		this.addTickets(boughtTickets);
	}
	
	/**
	 * Removes ticket from cart, then refunds ticket to the show
	 * @param show: the show to be refunded to
	 * @param seatID: the ID of the seat to be refunded to
	 */
	public void removeTicket(Ticket ticket) {
		tickets.remove(ticket);
		ticket.getShow().getSeats().refundTicket(ticket);
	}
 	 
}

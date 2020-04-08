package seats;

import shows.Show;
import tickets.*;

/**
 * Tracks the amount/availability of seats for a Show
 * @author Francis Villanueva
 *
 */
public class SeatTracker {

	public final int ROW_NUM = 5;
	public final String[] SEAT_LETTERS = {"A", "B", "C", "D", "E"};
	public final double DEFAULT_PRICE = 15.00;	
	
	private TicketList seats;
	
	public SeatTracker(Show show) {
		seats = new TicketList();
		//for now, whenever SeatTracker is constructed, it always has 25 seats max
		for(int i=0; i<ROW_NUM; i++) {
			for(int j=0; j<SEAT_LETTERS.length; j++) {
				String seatID = i + SEAT_LETTERS[j];
				Ticket newTicket = new Ticket(show, seatID, DEFAULT_PRICE, false);
				seats.add(newTicket);
			}
		}
	}
	
	public int getRowNum() {
		return ROW_NUM;
	}
	
	/*private void setRowNum(int rowNum) {
		this.ROW_NUM = rowNum;
	}*/
	
	public String[] getSeatLetters() {
		return SEAT_LETTERS;
	}
	
	/*private void setSeatLetters(String[] seatLetters) {
		this.SEAT_LETTERS = seatLetters;
	}*/
	
	public TicketList getSeats() {
		return seats;
	}
	//TODO: SeatTracker constructor that specifies price, SeatTracker constructor that specifies size
	
//	/**
//	 * Shows the available seats for a Show
//	 * @return: a String representation of the available seats
//	 */
//	public String showAvailableSeats() {
//		SeatDisplay display = new SeatDisplay(seats);
//		return display;
//	}

	/**
	 * Buys a ticket
	 * @return: the ticket that was bought
	 */
	public Ticket buyTicket() {
		for(int i=0; i<seats.getTicketAmount(); i++) {
			if(seats.get(i) != null && seats.get(i).getIsTaken() == false) {
				seats.purchase(seats.get(i));
				return seats.get(i);
			}
		}
		return null;
	}

	/**
	 * Buys the rest of the available tickets to a show
	 * @return: the TicketList of tickets that were bought
	 */
	public TicketList buyTheater() {
		TicketList purchasedTickets = new TicketList();
		
		for(int i=0; i<seats.getTicketAmount(); i++) {
			if(seats.get(i) != null && seats.get(i).getIsTaken() == false) {
				seats.purchase(seats.get(i));
				purchasedTickets.add(seats.get(i));
			}
		}
		return purchasedTickets;
	}

	/**
	 * Refunds a ticket
	 */
	public void refundTicket(Ticket ticket) {
		seats.refund(ticket);
	}
}

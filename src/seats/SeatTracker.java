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
	
	private TicketList seats;
	
	public SeatTracker(Show show, double ticketPrice) {
		seats = new TicketList();
		//for now, whenever SeatTracker is constructed, it always has 25 seats max
		for(int i=0; i<ROW_NUM; i++) {
			for(int j=0; j<SEAT_LETTERS.length; j++) {
				String seatID = i + SEAT_LETTERS[j];
				Ticket newTicket = new Ticket(show, seatID, ticketPrice, false);
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
	
	/**
	 * Shows the available seats for a Show
	 * @return: a String representation of the available seats
	 */
	public String showAvailableSeats() {
		SeatDisplay display = new SeatDisplay(this);
		return display.displaySeats();
	}

	/**
	 * TODO: possibly redundant b/c it's just buyTicket with (1)
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
	 * Buys multiple tickets
	 * @return: a TicketList of the tickets that were bought
	 */
	public TicketList buyTicket(int amount) {
		TicketList purchasedTickets = new TicketList();
		
		for(int i=0; i<amount; i++) {
			if(seats.get(i) != null && seats.get(i).getIsTaken() == false) {
				seats.purchase(seats.get(i));
				purchasedTickets.add(seats.get(i));
			}
		}
		return purchasedTickets;
	}
	
	/**
	 * Buys tickets starting with specific seat
	 * @param amount: of tickets to buy
	 * @param row: of seat
	 * @param seat: letter in row
	 * @return: TicketList of tickets bought
	 */
	public TicketList buyTicket(int amount, int row, String seat) {
		TicketList purchasedTickets = new TicketList();
		int seatNumber = row * ROW_NUM;
		for(int i = 0; i < SEAT_LETTERS.length; i++) {
			if(SEAT_LETTERS[i].equals(seat)) {
				break;
			}
			seatNumber ++;
		}
		
		for(int i = 0; i < amount; i++) {
			if(seats.get(seatNumber + i) != null && !seats.get(seatNumber + i).getIsTaken()) {
				seats.purchase(seats.get(seatNumber + i));
				purchasedTickets.add(seats.get(seatNumber + i));
			}
		}
		return purchasedTickets;
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
	
	/**
	 * String representation of a SeatTracker; simply returns # of available seats
	 * @return: integer number of available seats
	 */
	public String toString() {
		return Integer.toString(seats.getTicketAmount());
	}
}

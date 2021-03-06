package tickets;

import shows.Show;

/**
 * Specifies a Ticket object for a Show
 * @author Francis Villanueva
 */

public class Ticket {

	private Show show;
	private String seatID;
	private double price;
	private boolean isTaken;
//	private boolean handicapped;

	// parameterized constructor
	public Ticket(Show show, String seatID, double price) {
		this.show = show;
		this.seatID = seatID;
		this.price = price;
		
		this.isTaken = false;
	}

	// getters and setters
	public Show getShow() {
		return show;
	}
	public String getSeatID() {
		return seatID;
	}
	public boolean getIsTaken() {
		return isTaken;
	}
	public double getPrice() {
		return price;
	}
	public void setIsTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}

	/**
	 * Returns a String representing a Ticket
	 * @return: String representation of a Ticket
	 */
	public String toString() {
		return show.toString() +
				"\nSeatID: " + this.seatID +
				"\nPrice: " + this.price;
	}
}

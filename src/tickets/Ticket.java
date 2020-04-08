package tickets;
/**
 *
 * @author hannah killian
 * @edited Francis Villanueva
 */

public class Ticket {

	private Show show;
	private String seatID;
	private double price;
	private boolean isTaken;
//	private boolean handicapped;

	// parameterized constructor
	public Ticket(Show show, String seatID, double price, boolean isTaken) {
		this.show = show;
		this.seatID = seatID;
		this.price = price;
		
		this.isTaken = false;
	}

	// getters and setters
	public String getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	public String getSeatID() {
		return seatID;
	}
	public boolean getIsTaken() {
		return isTaken;
	}
	public void setSeatID(String seatID) {
		this.seatID = seatID;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setIsTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}

	/**
	 * Returns a String representing a Ticket
	 * @return: String representation of a Ticket
	 */
	public String toString() {
		return //use Show's toString?
	}
}

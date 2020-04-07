package tickets;
/**
 *
 * @author hannah killian
 *
 */

public class Ticket {

	private String showName;
	private String showTime;
	private String seatID;
	private double price;

	// default constructor
	public Ticket() {
		showName = null;
		showTime = null;
		seatID = null;
		price = 0.0;
	}
	// parameterized constructors
	public Ticket(String showName, String showTime, String seatID, double price) {
		this.showName = showName;
		this.showTime = showTime;
		this.seatID = seatID;
		this.price = price;
	}

	// getters and setters
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public String getSeatID() {
		return seatID;
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


	public String toString() {
		return showName + showTime + seatID + price;
	}
}

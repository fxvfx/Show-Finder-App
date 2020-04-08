package tickets;
/**
 *
 * @author hannah killian
 *
 */

public class Ticket {

	private Show show;
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
	public String getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
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

	//TODO: do me a favor and a) make a method comment for this and b) make to toString() a bit more descriptive;
	// if I call ticket.toString() i want to be able to tell what all the output is please
	// also, instead of the "showName" and "showTime" variables on the UML, we're going to be using 
	// the "Show" object so use like show.getName() and etc. in place of those
	public String toString() {
		return showName + showTime + seatID + price;
	}
}

package shows;

import reviews.ReviewList;
import seats.SeatTracker;
import java.util.LinkedList;

/**
 * 
 * @author Tariq Scott 
 *
 */
public abstract class Show {
	
	protected SeatTracker seats;
	protected ReviewList reviews;
	protected String name;
	protected String showTime;
	protected String showDate;
	protected String venueName;
	protected String location;
	protected double ticketPrice;
	protected LinkedList<String> actorList;
	protected int ageRestriction;
	
	//Getters
	public SeatTracker getSeats() {
		return seats;
	}
	public ReviewList getReviews() {
		return reviews;
	}
	public String getName() {
		return name;
	}
	public String getShowTime() {
		return showTime;
	}
	public String getShowDate() {
		return showDate;
	}
	public String getVenueName() {
		return venueName;
	}
	public String getLocation() {
		return location;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public LinkedList<String> getActorList() {
		return actorList;
	}
	public int getAgeRestriction() {
		return ageRestriction;
	}

	public Show(SeatTracker seats, ReviewList reviews, String name, String showTime, String showDate, String venueName,
			String location, double ticketPrice, LinkedList<String> actorList, int ageRestriction) {
		super();
		this.seats = seats;
		this.reviews = reviews;
		this.name = name;
		this.showTime = showTime;
		this.showDate = showDate;
		this.venueName = venueName;
		this.location = location;
		this.ticketPrice = ticketPrice;
		this.actorList = actorList;
		this.ageRestriction = ageRestriction;
	}
	
	
	@Override
	public String toString() {
		return "Show information:" +
				"\n\nShow name: " + name +
				"\nShow time: " + showTime +
				"\nShow date: " + showDate +
				"\nVenue name: " + venueName +
				"\nLocation: " + location +
				"\nTicket price: " + ticketPrice +
				"\nActor list: " + actorList +
				"\nAge restriction: " + ageRestriction +
				"\n\nNumber of seats still available: " + seats + 
				"\n\nReviews=" + reviews; //TODO: reviews' toString
	}

}

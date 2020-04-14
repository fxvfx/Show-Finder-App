package shows;

import reviews.*;
import seats.SeatTracker;
import java.util.LinkedList;

/**
 * 
 * @author Tariq Scott 
 * @editor Francis Villanueva
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
//	protected LinkedList<String> actorList;
	protected String actorList;
	protected int ageRestriction;
	protected String category;
	
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
//	public LinkedList<String> getActorList() {
//		return actorList;
//	}
	public String getActorList() {
		return actorList;
	}
	public int getAgeRestriction() {
		return ageRestriction;
	}
	public String getCategory() {
		return category;
	}

	public Show(String name, String showTime, String showDate, String venueName,
			String location, double ticketPrice, String actorList, int ageRestriction, 
			String category) {
		
		seats = new SeatTracker(this,ticketPrice);

		this.reviews = new ReviewList();
		this.name = name;
		this.showTime = showTime;
		this.showDate = showDate;
		this.venueName = venueName;
		this.location = location;
		this.ticketPrice = ticketPrice;
		this.actorList = actorList;
		this.ageRestriction = ageRestriction;
		this.category = category;
	}
	
	/**
	 * adds a Review to the show's list of Reviews
	 * @param review: review to be added
	 * @return 
	 */
	public boolean addReview(Review review) {
		return reviews.addReview(review);
	}
	
	@Override
	public String toString() {
		return "Show information:" +
				"\n\nShow name: " + name +
				"\nCategory: " + category +
				"\nShow time: " + showTime +
				"\nShow date: " + showDate +
				"\nVenue name: " + venueName +
				"\nLocation: " + location +
				"\nTicket price: " + ticketPrice +
				"\nActor list: " + actorList +
				"\nAge restriction: " + ageRestriction +
				"\n\nNumber of seats still available: " + seats + 
				"\n\nReviews:\n" + reviews;
	}

}

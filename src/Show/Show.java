package Show;

import reviews.ReviewList;
import seats.SeatTracker;
import java.util.LinkedList;

/**
 * 
 * @author Tariq Scott 
 *
 */
public abstract class Show {
	
	private String string;
	private SeatTracker seats;
	private ReviewList reviews;
	private String name;
	private String showTime;
	private String showDate;
	private String venueName;
	private String location;
	private double ticketPrice;
	private LinkedList<String> actorList;
	private int ageRestriction;
	
	public int getTicketCount() {
		return 0;
	}
	
	public int getReviewList() {
		return 0;
	}
	
	public String getString() {
		return string;
	}

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

	public String toString() {
		return "Information about the show is ";
	}

}

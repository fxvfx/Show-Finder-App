package shows;

import java.util.LinkedList;

import reviews.ReviewList;
import seats.SeatTracker;

/**
 * @author Tariq Scott
 * @editor Francis Villanueva
 */

public class Play extends Show {
	
	private String playSummary;
	
	public Play(ReviewList reviews, String name, String showTime, String showDate, String venueName,
			String location, double ticketPrice, LinkedList<String> actorList, int ageRestriction, String playSummary) {
		super(reviews, name, showTime, showDate, venueName, location, ticketPrice,
				actorList, ageRestriction);
		this.playSummary = playSummary;
	}

	public String toString() {
		return super.toString() + "\nPlay Summary: " + playSummary;
	}
	
}
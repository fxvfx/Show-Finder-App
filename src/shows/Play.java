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
	
	public Play(SeatTracker seats, ReviewList reviews, String name, String showTime, String showDate, String venueName,
			String location, double ticketPrice, LinkedList<String> actorList, int ageRestriction, String playSummary) {
		super(seats, reviews, name, //got lazy at this point);
		this.playSummary = playSummary;
	}

	public String toString() {
		return super.toString() + "\n Play Summary: " + playSummary;
	}
	
}
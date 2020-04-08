package shows;

import java.util.LinkedList;

import reviews.ReviewList;

/**
 * @author Tariq Scott
 * @editor Michael Norton
 */

public class Concert extends Show {
	
	private String genre;
	
	public Concert(ReviewList reviews, String name, String showTime, String showDate, String venueName,
			String location, double ticketPrice, LinkedList<String> actorList, int ageRestriction, 
			String genre) {
		super(reviews, name, showTime, showDate, venueName, location, ticketPrice,
				actorList, ageRestriction);
		this.genre = genre;
	}
	
	public String toString() {
		return super.toString() + "\nGenre: " + genre;
	}
	
}
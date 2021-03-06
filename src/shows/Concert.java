package shows;

import java.util.LinkedList;

import reviews.ReviewList;

/**
 * @author Tariq Scott
 * @editor Michael Norton
 */

public class Concert extends Show {
	
	private String genre;
	
	public Concert(String name, String showTime, String showDate, String venueName,
			String location, double ticketPrice, String actorList, int ageRestriction, 
			String genre) {
		super(name, showTime, showDate, venueName, location, ticketPrice,
				actorList, ageRestriction, genre);
		this.genre = genre;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public String toString() {
		return super.toString() + "\nGenre: " + genre;
	}
	
}
package shows;

import java.util.LinkedList;

import reviews.ReviewList;

/**
 * Represents a movie in the system
 * @author tariqscott
 * @editor Michael Norton
 */
public class Movie extends Show {

	private String movieSummary;
	private String releaseDate;
	private String directorName;
	private MovieRating mpaRating;
	
	public Movie(ReviewList reviews, String name, String showTime, String showDate, String venueName,
			String location, double ticketPrice, LinkedList<String> actorList, int ageRestriction, 
			String movieSummary, String releaseDate, String directorName, MovieRating mpaRating) {
		super(reviews, name, showTime, showDate, venueName, location, ticketPrice,
				actorList, ageRestriction);
		this.movieSummary = movieSummary;
		this.releaseDate = releaseDate;
		this.directorName = directorName;
		this.mpaRating = mpaRating;
	}
	
	public String toString() {
		return super.toString() + "\nMovie Summary: " + movieSummary 
				+ "\nRelease Date: " + releaseDate + "\nDirector: " + directorName + "Rating" + mpaRating;
	}
}
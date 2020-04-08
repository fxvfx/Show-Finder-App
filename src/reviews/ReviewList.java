package reviews;

import java.util.LinkedList;

/**
 * Keeps track of a show's reviews
 * @author Francis Villanueva
 *
 */

public class ReviewList {

	private LinkedList<Review> reviews;

	public void reviewList() {
		reviews = new LinkedList<Review>();
	}
	
	/**
	 * Adds a review to the list of reviews
	 * @param review: review to be added
	 */
	public void addReview(Review review) {
		reviews.add(review);
	}
	
	/**
	 * Removes a review from the list of reviews
	 * @param review: review to be removed
	 */
	public void removeReview(Review review) {
		if(reviews.contains(review))
			reviews.remove(review);
	}
	
	/**
	 * Returns a String output of all the Reviews in the ReviewList
	 * @return: String representing all the reviews in the list
	 */
	public String toString() {
		String reviewString = "";
		for(int i=0; i<reviews.size(); i++) {
			reviewString = reviewString + reviews.get(i) + "\n";
		}
		return reviewString;
	}
}

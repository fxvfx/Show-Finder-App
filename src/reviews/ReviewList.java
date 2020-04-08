package reviews;

import java.util.LinkedList;

/**
 * Keeps track of a show's reviews
 * @author Francis Villanueva
 *
 */
public class ReviewList {

	private LinkedList<Review> reviews;

	public ReviewList() {
		reviews = new LinkedList<Review>();
	}
	
	public LinkedList<Review> getReviews() {
		return reviews;
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
	 * Checks if a given review is within the list
	 * @param review: review to be checked
	 * @return: true if review is in  the list, false otherwise
	 */
	public boolean contains(Review review) {
		return reviews.contains(review);
	}
	
	/**
	 * Checks if a given string is located anywhere in a review in the ReviewList
	 * @param phrase phrase to be checked for
	 * @return true if phrase is found, false otherwise
	 */
	public boolean contains(String phrase) {
		for(int i=0; i<reviews.size(); i++) {
			if(reviews.get(i).getReviewContent().contains(phrase))
				return true;
		}
		return false;
	}
	
	/**
	 * Returns number of reviews in list
	 * @return: how many reviews are in the list
	 */
	public int size() {
		return reviews.size();
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

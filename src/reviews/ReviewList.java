package reviews;

import java.util.LinkedList;

/**
 *
 * @author hannah killian
 *
 */

public class ReviewList {

	private LinkedList<Review> reviews;

	public void reviewList() {
		
		// reviews: LinkedList<Reviews>
		reviews  = new LinkedList<Review>();

	}
	
	public void addReview(Review review) {
		// adding a review from "reviews"
	}
	
	public void removeReview(Review review) {
		// deleting a review from "reviews"
	}
	
	
	/**
	 * Returns a String output of all the Reviews in the ReviewList
	 * @return: String representing all the reviews in the list
	 * 
	 * TODO: ^ this is how your method comments should look! :D
	 */
	public String toString() {
		//your functionality @hannah; probably make it call the "Review" object's toString()
	}

}

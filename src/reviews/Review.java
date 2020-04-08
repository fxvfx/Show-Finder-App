/**
 * Specifies a Review object for a Show
 * @author Francis Villanueva
 */

package reviews;

import shows.Show;
import userAccounts.UserAccount;

public class Review {
	
	private String reviewContent;
	private int numStars;
	private UserAccount owner;
	private Show show;

	public Review(Show show, String reviewContent, int numStars, UserAccount owner) {
		this.show = show;
		this.reviewContent = reviewContent;
		this.owner = owner;
		this.numStars = numStars;
	}
	
	/**
	 * Returns a String representation of a Review
	 * @return: String representing the review
	 */
	public String toString() {
		return "Review for " + show.getName() + " by " + owner.getName() + 
				":\n" + numStars + "/5 stars." + "\n" + reviewContent;
	}
}

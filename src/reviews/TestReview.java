package reviews;
/**
 * @auothor Tariq Scott
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import userAccounts.UserAccount;

class TestReview {

	Review review = new Review(null, null, 0, null);
	
	@Test
	void testGetReviewContent() {
		Review review = new Review(null, null, 0, null);
		assertEquals(null, review.getReviewContent());
	}
	
	@Test
	void testGetNumStars_ValidNumber_ShouldReturnNull() {
		Review review = new Review(null, null, 0, null);
		assertEquals(0, review.getNumStars());
	}
	
	@Test
	void testGetOwner_UserCheck_ShouldReturnNull() {
		Review review = new Review(null, null, 0, null);
		assertNull(review.getOwner());
	}
	
	@Test
	void testToString() {
		Review review = new Review(null, null, 0, null);	
		assertEquals(review.toString(), "");
	}

}

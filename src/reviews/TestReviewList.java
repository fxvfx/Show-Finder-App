package reviews;

/**
 * @author Tariq Scott
 * Testing ReviewList.java methods
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import shows.Show;

class TestReviewList {
	
	Review review = new Review(null,"",5, null);
	
	@Test
	void testGetReviewList_ShouldReturnZero() {
		ReviewList review = new ReviewList();
		assertSame(review, review.getReviews());
	}
	
	@Test
	void testAddReview_AddedReview_ShouldReturnTrue() {
		ReviewList reviewList = new ReviewList();
		assertTrue(reviewList.addReview(review));
	}
	
	@Test
	void testRemoveReview_RemovedReview_ShouldReturnTrue() {
		ReviewList reviewList = new ReviewList();
		assertTrue(reviewList.removeReview(review));
	} 
	
	@Test
	void testContains_nullReview_ShouldReturnSomething() {
		ReviewList reviewList = new ReviewList();
		assertNotNull(reviewList.contains(review));
	}
	
	@Test
	void testContains_ChecksForPhrase_ShouldReturnSomething() {
		ReviewList reviewList = new ReviewList();
		assertNotNull(reviewList.contains(review));
	}
	
	@Test
	void testSize() {
		ReviewList review = new ReviewList();
		assertNotNull(review.size());
	}
	
	@Test 
	void testToString() {
		Review review = new Review(null,"",5, null);
		assertEquals(review.toString(), "Review");
	}
}

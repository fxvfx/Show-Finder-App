package shows;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import reviews.Review;
/**
 * Tests the ShowList class
 * @author Michael Norton (CSCE 247-001) //TODO team name
 *
 */
class ShowListTest {

	public static Concert concert = new Concert("Jonas Brothers", "6:30", "April 14 2020", "Colonial Life Arena", 
			"Columbia", 50.0, "Joe Jonas, Kevin Jonas, Nick Jonas", 12, "Pop");
	@Test
	public void testGetInstance() {
		ShowList showList = ShowList.getInstance();
		assertNotNull(showList);
	}

	@Test
	public void testGetShows() {
		ShowList showList = ShowList.getInstance();
		assertTrue(showList.getShows().isEmpty());
	}

	@Test
	public void testAddShow() {
		ShowList showList = ShowList.getInstance();
		showList.addShow(concert);
		assertFalse(showList.getShows().isEmpty());
	}

	@Test
	public void testCategorySearchFound() {
		ShowList showList = ShowList.getInstance();
		if(!showList.getShows().contains(concert)) {
			showList.addShow(concert);
		}
		assertEquals(concert, showList.categorySearch("Pop"));
	}

	@Test
	public void testCategorySearchNotFound() {
		ShowList showList = ShowList.getInstance();
		assertNull(showList.categorySearch("Rock"));
	}
	
	@Test
	public void testNameSearchFound() {
		ShowList showList = ShowList.getInstance();
		assertEquals(concert, showList.nameSearch("Jonas Brothers"));
	}
	
	@Test
	public void testNameSearchNotFound() {
		ShowList showList = ShowList.getInstance();
		assertNull(showList.nameSearch("One Direction"));
	}

	@Test
	public void testReviewSearchFound() {
		ShowList showList = ShowList.getInstance();
		concert.addReview(new Review(concert, "very cool", 5, null));
		showList.addShow(concert);
		assertEquals(concert, showList.reviewSearch("cool"));
	}
	
	@Test
	public void testReviewSearchNotFound() {
		ShowList showList = ShowList.getInstance();
		assertNull(showList.reviewSearch("bad"));
	}

	@Test
	public void testShowTimeSearchFound() {
		ShowList showList = ShowList.getInstance();
		assertEquals(concert, showList.showTimeSearch("6:30"));
	}
	
	@Test
	public void testShowTimeSearchNotFound() {
		ShowList showList = ShowList.getInstance();
		assertNull(showList.showTimeSearch("8:00"));
	}
	
	@Test
	public void testRemoveShow() {
		ShowList showList = ShowList.getInstance();
		showList.removeShow(concert);
		assertTrue(showList.getShows().isEmpty());
	}

}

package shows;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import reviews.Review;
import userAccounts.StandardUser;

/**
 * Tests Concert and Show Classes
 * @author Michael Norton CSCE 247-001 //TODO team name
 *
 */
class ConcertTest {
	
	@Test
	public void testGetName() {
		Concert concert = new Concert("Jonas Brothers", "6:30", "April 14 2020", "Colonial Life Arena", 
				"Columbia", 50.0, "Joe Jonas, Kevin Jonas, Nick Jonas", 12, "Pop");
		assertEquals(concert.getName(),"Jonas Brothers");
	}
	
	@Test
	public void testGetShowtime() {
		Concert concert = new Concert("Jonas Brothers", "6:30", "April 14 2020", "Colonial Life Arena", 
				"Columbia", 50.0, "Joe Jonas, Kevin Jonas, Nick Jonas", 12, "Pop");
		assertEquals(concert.getShowTime(),"6:30");
	}
	@Test
	public void testGetShowDate() {
		Concert concert = new Concert("Jonas Brothers", "6:30", "April 14 2020", "Colonial Life Arena", 
				"Columbia", 50.0, "Joe Jonas, Kevin Jonas, Nick Jonas", 12, "Pop");
		assertEquals(concert.getShowDate(), "April 14 2020");
	}
	
	@Test
	public void testGetVenueName() {
		Concert concert = new Concert("Jonas Brothers", "6:30", "April 14 2020", "Colonial Life Arena", 
				"Columbia", 50.0, "Joe Jonas, Kevin Jonas, Nick Jonas", 12, "Pop");
		assertEquals(concert.getVenueName(), "Colonial Life Arena");
	}
	
	@Test
	public void testGetLocation() {
		Concert concert = new Concert("Jonas Brothers", "6:30", "April 14 2020", "Colonial Life Arena", 
				"Columbia", 50.0, "Joe Jonas, Kevin Jonas, Nick Jonas", 12, "Pop");
		assertEquals(concert.getLocation(), "Columbia");
	}
	
	@Test
	public void testGetTicketPrice() {
		Concert concert = new Concert("Jonas Brothers", "6:30", "April 14 2020", "Colonial Life Arena", 
				"Columbia", 50.0, "Joe Jonas, Kevin Jonas, Nick Jonas", 12, "Pop");
		assertEquals(concert.getTicketPrice(), 50.0);
	}
	
	@Test
	public void testGetActorList() {
		Concert concert = new Concert("Jonas Brothers", "6:30", "April 14 2020", "Colonial Life Arena", 
				"Columbia", 50.0, "Joe Jonas, Kevin Jonas, Nick Jonas", 12, "Pop");
		assertEquals(concert.getActorList(), "Joe Jonas, Kevin Jonas, Nick Jonas");
	}
	
	@Test
	public void testGetAgeRestriction() {
		Concert concert = new Concert("Jonas Brothers", "6:30", "April 14 2020", "Colonial Life Arena", 
				"Columbia", 50.0, "Joe Jonas, Kevin Jonas, Nick Jonas", 12, "Pop");
		assertSame(concert.getAgeRestriction(), 12);
	}
	
	@Test
	public void testGetGenre() {
		Concert concert = new Concert("Jonas Brothers", "6:30", "April 14 2020", "Colonial Life Arena", 
				"Columbia", 50.0, "Joe Jonas, Kevin Jonas, Nick Jonas", 12, "Pop");
		assertEquals(concert.getGenre(), "Pop");
	}

	@Test
	public void testGetReviews() {
		Concert concert = new Concert("Jonas Brothers", "6:30", "April 14 2020", "Colonial Life Arena", 
				"Columbia", 50.0, "Joe Jonas, Kevin Jonas, Nick Jonas", 12, "Pop");
		
		Review review = new Review(concert, "Good Show", 5, 
				new StandardUser("Bob", null, null, 0, null, 20, false));
		concert.addReview(review);
		
		String reviewString = review.toString() + "\n";
		
		assertEquals(concert.getReviews().toString(), reviewString);
	}
	
	@Test
	public void testToString() {
		Concert concert = new Concert("Jonas Brothers", "6:30", "April 14 2020", "Colonial Life Arena", 
				"Columbia", 50.0, "Joe Jonas, Kevin Jonas, Nick Jonas", 12, "Pop");
		String concertString = "Show information:\n\nShow name: Jonas Brothers\nCategory: Pop\nShow time: 6:30\n"
				+ "Show date: April 14 2020\nVenue name: Colonial Life Arena\nLocation: Columbia\n"
				+ "Ticket price: 50.0\nActor list: Joe Jonas, Kevin Jonas, Nick Jonas\n"
				+ "Age restriction: 12\n\nNumber of seats still available: 25\n\n"
				+ "Reviews:\n\nGenre: Pop";
		assertEquals(concert.toString(), concertString);
	}
	
	@Test
	public void testGetCategory() {
		Concert concert = new Concert("Jonas Brothers", "6:30", "April 14 2020", "Colonial Life Arena", 
				"Columbia", 50.0, "Joe Jonas, Kevin Jonas, Nick Jonas", 12, "Pop");
		assertEquals(concert.getCategory(),"Pop");
	}
	
	@Test
	public void testGetSeats() {
		Concert concert = new Concert("Jonas Brothers", "6:30", "April 14 2020", "Colonial Life Arena", 
				"Columbia", 50.0, "Joe Jonas, Kevin Jonas, Nick Jonas", 12, "Pop");
		assertEquals(concert.getSeats().toString(), "25");
	}
}

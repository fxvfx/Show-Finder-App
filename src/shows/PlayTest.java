package shows;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * Tests Play class
 * @author Michael Norton (CSCE 247-001) //TODO team name
 *
 */
class PlayTest {

	@Test
	void testToString() {
		Play play = new Play("An American in Paris", "3:00", "June 13 2020", "Koger Center", 
				"Columbia", 50.0, "John Doe", 6, "Musical from Broadway", "Musical");
		String playString = "Show information:\n\nShow name: An American in Paris\nCategory: Musical\nShow time: 3:00\n"
				+ "Show date: June 13 2020\nVenue name: Koger Center\nLocation: Columbia\n"
				+ "Ticket price: 50.0\nActor list: John Doe\n"
				+ "Age restriction: 6\n\nNumber of seats still available: 25\n\n"
				+ "Reviews:\n\nPlay Summary: Musical from Broadway";
		assertEquals(play.toString(), playString);
	}

	@Test
	void testGetPlaySummary() {
		Play play = new Play("An American in Paris", "3:00", "June 13 2020", "Koger Center", 
				"Columbia", 50.0, "John Doe", 6, "Musical from Broadway", "Musical");
		assertEquals(play.getPlaySummary(),"Musical from Broadway");
	}

}

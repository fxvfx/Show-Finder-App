package tickets;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import shows.Concert;
/**
 * Tests Ticket class
 * @author Michael Norton (CSCE 247-001) //TODO team name
 *
 */
class TicketTest {

	@Test
	public void testGetShow() {
		Concert concert = new Concert("Jonas Brothers", "6:30", "April 14 2020", "Colonial Life Arena", 
				"Columbia", 50.0, "Joe Jonas, Kevin Jonas, Nick Jonas", 12, "Pop");
		Ticket ticket = new Ticket(concert, "1A", 50.0);
		assertEquals(concert, ticket.getShow());
	}

	@Test
	public void testGetSeatID() {
		Ticket ticket = new Ticket(null, "1A", 50.0);
		assertEquals("1A", ticket.getSeatID());
	}

	@Test
	public void testGetIsTaken() {
		Ticket ticket = new Ticket(null, "1A", 50.0);
		assertFalse(ticket.getIsTaken());
	}

	@Test
	public void testGetPrice() {
		Ticket ticket = new Ticket(null, "1A", 50.0);
		assertEquals(50.0, ticket.getPrice());
	}

	@Test
	public void testSetIsTaken() {
		Ticket ticket = new Ticket(null, "1A", 50.0);
		ticket.setIsTaken(true);
		assertTrue(ticket.getIsTaken());
	}

	@Test
	public void testToString() {
		Concert concert = new Concert("Jonas Brothers", "6:30", "April 14 2020", "Colonial Life Arena", 
				"Columbia", 50.0, "Joe Jonas, Kevin Jonas, Nick Jonas", 12, "Pop");
		Ticket ticket = new Ticket(concert, "1A", 50.0);
		String ticketString = concert.toString() + "\nSeatID: 1A\nPrice: 50.0";
		assertEquals(ticketString, ticket.toString());
	}

}

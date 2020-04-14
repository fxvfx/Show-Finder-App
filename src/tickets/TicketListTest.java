package tickets;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import shows.Concert;
/**
 * Tests TicketList class
 * @author Michael Norton (CSCE 247-001) //TODO team name
 *
 */
class TicketListTest {

	@Test
	public void testGetTicketAmountZero() {
		TicketList ticketList = new TicketList();
		assertEquals(0, ticketList.getTicketAmount());
	}
	
	@Test
	public void testGetTicketAmountOne() {
		TicketList ticketList = new TicketList();
		ticketList.add(new Ticket(null, "1A", 50.0));
		assertEquals(1, ticketList.getTicketAmount());
	}

	@Test
	public void testGetNumSeatsZero() {
		TicketList ticketList = new TicketList();
		assertEquals(ticketList.getNumSeats(), 0);
	}
	
	@Test
	public void testGetNumSeatsOne() {
		TicketList ticketList = new TicketList();
		ticketList.add(new Ticket(null, "1A", 50.0));
		assertEquals(1, ticketList.getNumSeats());
	}

	@Test
	public void testGetZero() {
		TicketList ticketList = new TicketList();
		Ticket ticket = new Ticket(null, "1A", 50.0);
		ticketList.add(ticket);
		assertEquals(ticketList.get(0), ticket);
	}
	
	@Test
	public void testGetOne() {
		TicketList ticketList = new TicketList();
		Ticket ticket = new Ticket(null, "1B", 50.0);
		ticketList.add(new Ticket(null, "1A", 50.0));
		ticketList.add(ticket);
		assertEquals(ticketList.get(1), ticket);
	}

	@Test
	public void testAdd() {
		TicketList ticketList = new TicketList();
		assertEquals(ticketList.add(new Ticket(null, "1A", 50.0)), 0);
	}

	@Test
	public void testPurchase() {
		TicketList ticketList = new TicketList();
		Ticket ticket = new Ticket(null, "1A", 50.0);
		ticketList.add(ticket);
		ticketList.purchase(ticket);
		assertEquals(ticketList.getTicketAmount(),0);
	}

	@Test
	public void testRefund() {
		TicketList ticketList = new TicketList();
		Ticket ticket = new Ticket(null, "1A", 50.0);
		ticketList.add(ticket);
		ticketList.purchase(ticket);
		ticketList.refund(ticket);
		assertEquals(ticketList.getTicketAmount(),1);
	}

	@Test
	public void testRemove() {
		TicketList ticketList = new TicketList();
		Ticket ticket = new Ticket(null, "1A", 50.0);
		ticketList.add(ticket);
		ticketList.remove(ticket);
		assertEquals(ticketList.getNumSeats(), 0);
	}

	@Test
	public void testToString() {
		TicketList ticketList = new TicketList();
		Concert concert = new Concert("Jonas Brothers", "6:30", "April 14 2020", "Colonial Life Arena", 
				"Columbia", 50.0, "Joe Jonas, Kevin Jonas, Nick Jonas", 12, "Pop");
		Ticket ticket = new Ticket(concert, "1A", 50.0);
		ticketList.add(ticket);
		String listString = "[" + ticket.toString() + "]";
		assertEquals(listString, ticketList.toString());
	}

}

package seats;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tickets.TicketList;
import tickets.Ticket;

class SeatTrackerTest {

	@Test
	public void testGetRowNum() {
		SeatTracker seatTracker = new SeatTracker(null, 0);
		assertEquals(seatTracker.getRowNum(),5);
	}

	@Test
	public void testGetSeatLetters() {
		SeatTracker seatTracker = new SeatTracker(null, 0);
		String[] seatLetters = {"A","B","C","D","E"};
		boolean isSame = true;
		for(int i = 0; i < seatLetters.length; i++) {
			if(!seatLetters[i].equals(seatTracker.getSeatLetters()[i])) {
				isSame = false;
			}
		}
		assertTrue(isSame);
	}

	@Test
	public void testGetSeats() {
		SeatTracker seatTracker = new SeatTracker(null, 0);
		TicketList tickets = seatTracker.getSeats();
		assertEquals(tickets.getTicketAmount(),25);
	}

	@Test
	public void testShowAvailableSeats() {
		SeatTracker seatTracker = new SeatTracker(null, 0);
		assertEquals(seatTracker.showAvailableSeats(), "OOOOO\nOOOOO\nOOOOO\nOOOOO\nOOOOO\n");
	}

	@Test
	public void testBuyTicket() {
		SeatTracker seatTracker = new SeatTracker(null,0);
		Ticket ticket = seatTracker.buyTicket();
		assertTrue(ticket.getIsTaken());
	}

	@Test
	public void testBuyTicketInt() {
		SeatTracker seatTracker = new SeatTracker(null,0);
		TicketList ticketList = seatTracker.buyTicket(2);
		assertEquals(ticketList.getNumSeats(),2);
	}

	@Test
	public void testBuyTicketIntIntString() {
		SeatTracker seatTracker = new SeatTracker(null,0);
		TicketList ticketList = seatTracker.buyTicket(1,2,"B");
		Ticket ticket = ticketList.get(0);
		assertEquals(ticket.getSeatID(), "2B");
	}

	@Test
	public void testBuyTheater() {
		SeatTracker seatTracker = new SeatTracker(null,0);
		seatTracker.buyTheater();
		TicketList seats = seatTracker.getSeats();
		boolean isBought = true;
		for(int i = 0; i < seats.getNumSeats(); i++) {
			if(!seats.get(i).getIsTaken()) {
				isBought = false;
			}
		}
		assertTrue(isBought);
	}

	@Test
	public void testRefundTicket() {
		SeatTracker seatTracker = new SeatTracker(null,0);
		Ticket ticket = seatTracker.buyTicket();
		seatTracker.refundTicket(ticket);
		assertEquals(seatTracker.getSeats().getTicketAmount(), 25);
	}

	@Test
	public void testToString() {
		SeatTracker seatTracker = new SeatTracker(null,0);
		assertEquals(seatTracker.toString(),"25");
	}

}

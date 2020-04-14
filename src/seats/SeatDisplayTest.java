package seats;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * Tests the SeatDisplay class
 * @author Michael Norton (CSCE 247-001) //TODO team name
 *
 */
class SeatDisplayTest {

	@Test
	public void testDisplaySeatsEmptyTheater() {
		SeatDisplay seatDisp = new SeatDisplay(new SeatTracker(null, 0));
		assertEquals(seatDisp.displaySeats(), "OOOOO\nOOOOO\nOOOOO\nOOOOO\nOOOOO\n");
	}
	
	@Test
	public void testDisplaySeatsFullTheater() {
		SeatTracker seatTracker = new SeatTracker(null, 0);
		SeatDisplay seatDisp = new SeatDisplay(seatTracker);
		
		seatTracker.buyTheater();
		assertEquals(seatDisp.displaySeats(), "XXXXX\nXXXXX\nXXXXX\nXXXXX\nXXXXX");
	}
	
	@Test
	public void testDisplaySeatsHalfFull() {
		SeatTracker seatTracker = new SeatTracker(null,0);
		SeatDisplay seatDisp = new SeatDisplay(seatTracker);
		int numSeats = seatTracker.getRowNum() * seatTracker.getSeatLetters().length;
		
		for(int i = 0; i < numSeats / 2; i++) {
			seatTracker.buyTicket();
		}
		
		assertEquals(seatDisp.displaySeats(), "XXXXX\nXXXXX\nXXOOO\nOOOOO\nOOOOO\n");
	}

}

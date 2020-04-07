package lists;
/**
 * author hannah killian
 */

import java.util.LinkedList;


public class TicketList implements List {

	LinkedList<Ticket> tickets;

	public TicketList() {
		tickets = new LinkedList<Ticket>();
	}


	// getNext(): Ticket
	public void getNext(int index) {
		tickets.get(index);
	}

}

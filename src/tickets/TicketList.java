package tickets;

import java.util.LinkedList;

public class TicketList extends CartList {
	
	//make getters for these please
	int ticketAmount;
	LinkedList<Ticket> tickets;
	
	//TODO: when you code the addItem() for this, make sure you can't add a Ticket to the TicketList with the same
	// name
	//TODO: this needs a default constructor	
	public TicketList() {
		ticketAmount = 0;
		tickets = new LinkedList<Ticket>();
	}
	
	public int getTicketAmount() {
		
	}
	
	public Ticket get(int index) {//turns out we do need a getNext() here, just call "get()" on the linked list for the ticket object though
		
	}
	
	public Ticket getFirst() { //call the LinkedList's default "getNext()" method
		
	}
	
	public void removeFirst() {// by "remove item" i just mean set the ticket's isTaken value to "false"
		
	}
	
	public void remove(int index) { //similar to removeFirst except at index
		
	}

	@Override
	public double calculateTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object addItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object removeItem() {
		// TODO Auto-generated method stub
		return null;
	}

	
}

package tickets;

/**
*
* author: hannah killian
*
**/

public interface CartList {
	//TODO: give all these methods their corresponding Javadoc comments por favor!
	// the nice thing is that, when you do the comments in the interface, you don't
	// have to do it for their corresponding methods in TicketList :)
	
	
	public double calculateTotal();

	public String toString();

	public void addItem();

	public void removeItem();
}

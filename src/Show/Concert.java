package Show;
/**
 * @author Tariq Scott
 */

public class Concert extends Show {
	
	private Concert concert;
	
	public Concert(Concert concert) {
		this.concert = concert;
	}

	@Override
	public int getTicketCount() {
		return concert.getTicketCount();
	}

	@Override
	public int getReviewList() {
		return 0;
	}
	
	public String toString() {
		return toString() + "Details about this concert are ";
	}
	
}
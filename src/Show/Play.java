package Show;
/**
 * @author Tariq Scott
 */

public class Play extends Show {
	
	private Play play;
	
	public Play(Play play) {
		this.play = play;
	}

	@Override
	public int getTicketCount() {
		return play.getTicketCount();
	}

	@Override
	public int getReviewList() {
		return play.getReviewList();
	}
	
	public String toString() {
		return toString() + "Details about this play include";
	}
	
}
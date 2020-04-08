package shows;
/**
 * @author Tariq Scott
 */

public class Play extends Show {
	
	private Play play;
	
	public Play(Play play) {
		this.play = play;
	}
	
	public String toString() {
		return toString() + "Details about this play include";
	}
	
}
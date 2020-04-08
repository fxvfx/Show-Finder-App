package seats;

/**
 * Creates a visual representation of a seating diagram
 * @author Michael Norton CSCE 247-001 //TODO team name
 *
 */
public class SeatDisplay {
	private SeatTracker seatTracker;
	
	public SeatDisplay(SeatTracker seatTracker) {
		this.seatTracker = seatTracker;
	}
	
	/**
	 * Creates a diagram of seats based on a show's tickets
	 * @return String representing seating diagram
	 */
	public String displaySeats() {
		String diagram = "";
		for(int i = 0; i < seatTracker.getSeatLetters().length; i++) {
			for(int j = 0; j < seatTracker.getRowNum(); j++) {
				
				if(seatTracker.getSeats().get((seatTracker.getRowNum() * i) + j).getIsTaken()) {
					diagram = diagram + "X";
				}
				else {
					diagram = diagram + "O";
				}
			}
			
			diagram = diagram + "\n";
		}
		return diagram;
	}
}

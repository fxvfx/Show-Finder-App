import java.util.LinkedList;

import reviews.*;
import shows.*;
import userAccounts.Guest;
import userAccounts.UserAccount;

public class testDriver {

	public static void main(String[] args) {
		LinkedList<String> actorList  = new LinkedList<String>();
		actorList.add("John Cena");
		actorList.add("Dwayne the Rock");
		
		
		ReviewList reviews = new ReviewList();
		
		UserAccount guest1 = new Guest();
		UserAccount guest2 = new Guest();
		UserAccount guest3 = new Guest();
		
//		//(ReviewList reviews, String name, String showTime, String showDate, String venueName,
//		// String location, double ticketPrice, LinkedList<String> actorList, int ageRestriction, 
//		// String playSummary
//		Play aPlay = new Play(reviews, "Teen Titans", "11:00", "01/01/1010", 
//				"MoviesRUs", "ARealAddress", 15.00, actorList, 21, "teen titans is AWESOME.");
//		
//		//(Show show, String reviewContent, int numStars, UserAccount owner) {
//		Review a = new Review(aPlay, "that show kinda sucked", 3, john);
//		
//		aPlay.addReview(a);
//		
//		System.out.println(aPlay);
		
		System.out.println(guest1.toString());
		System.out.println(guest2.toString());
		System.out.println(guest3.toString());
	}

}

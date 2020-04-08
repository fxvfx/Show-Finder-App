package userAccounts;

/**
 * Specifies a Guest's methods
 * @author Francis Villanueva
 *
 */
public class Guest extends UserAccount {
	public static int guestNum = 0; //Guests are generated with unique names
	
	//guests have a null string as their password
	public Guest() {
		super("Guest" + (guestNum+1), null, false);
		guestNum++;
	}
}

package ui;

import userAccounts.Guest;
import userAccounts.StandardUser;
import userAccounts.UserAccount;

/**
 * Handles the UI's command logic for interfacing w/ the system
 * @author Francis Villanueva (CSCE 247-001) //TODO team name
 *
 */
public class CommandLogic {
	
	//private static ShowList shows;
	//private static UserAccounts users;
	
	private UserAccount currentUser;
	
	private static final String[] commands = {"search", };

	public CommandLogic() {
		currentUser = null;
	}
	
	/**
	 * 
	 * @param command: the user's input command
	 * @return loggedIn: whether the 
	 */
	public boolean login(String command, String name) {
		
		if(command.contentEquals("login")) {
			currentUser = new StandardUser("input");
		}
		else if(command.contentEquals("guest")) {
			currentUser = new Guest();
		}
		else if(command.contentEquals("create")) {
			currentUser = new StandardUser("created");
		}
		
		return attemptedUser != null;
	}
}

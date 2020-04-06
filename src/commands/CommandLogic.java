package commands;

import java.util.Arrays;
import java.util.LinkedList;

import userAccounts.Guest;
import userAccounts.StandardUser;
import userAccounts.UserAccount;

/**
 * Handles the UI's command logic for interfacing w/ the system
 * @author Francis Villanueva (CSCE 247-001) //TODO zteam name
 *
 */
public class CommandLogic {
	
	private static ShowList shows;
	private static UserAccounts users;
	
	public static final LinkedList<String> loginCommands = new LinkedList<String>(Arrays.asList(
			"login", "guest", "create"
			));	
	
	public static final LinkedList<String> sysCommands = new LinkedList<String>(Arrays.asList(
			"search", "leaveReview", "buyTicket", "printTickets",
			"addShow" //administrator-restricted commands
			));
	
	private UserAccount currentUser;

	public CommandLogic() {
		currentUser = null;
		this.shows = new ShowList();
		this.UserAccounts  = new UserAccounts();
	}
	
	/**
	 * @return: currently logged in user
	 */
	public UserAccount getUser() {
		return this.currentUser;
	}
	/**
	 * @return: the list of shows
	 */
	public UserAccount getShows() {
		return this.shows;
	}
	/**
	 * @return: the list of users
	 */
	public UserAccount getUsers() {
		return this.users;
	}
	
	/**
	 * @return: LinkedList of possible login commands
	 */
	public LinkedList<String> getLoginCommands() {
		return loginCommands;
	}
	
	/**
	 * @return: LinkedList of possible system commands
	 */
	public LinkedList<String> getSysCommands() {
		return sysCommands;
	}
	
	
	/**
	 * Verifies if a command is a possible login command
	 * @param command: possible command
	 * @return: true if command is possible, false otherwise
	 */
	public boolean validLoginCommand(String command) {
		return loginCommands.contains(command);
	}
	
	/**
	 * Logs user in as a guest
	 */
	public void guestLogin() {
		currentUser = new Guest(); //should go through "making a new guest account" in UserAccount
		//TODO: guest counter variable?
	}
	
	/**
	 * Logs user in as an already-registered user in the system
	 * @param user: user's username
	 * @param pwd: user's password
	 * @return: true if login is successful, false otherwise
	 */
	public boolean login(String user, String pwd) {
		currentUser = users.login(user, pwd);
		return currentUser != null;
	}
}

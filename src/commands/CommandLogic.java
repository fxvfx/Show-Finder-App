package commands;

import java.util.Arrays;
import java.util.LinkedList;

import shows.Show;
import shows.ShowList;
import userAccounts.Guest;
import userAccounts.StandardUser;
import userAccounts.UserAccount;
import userAccounts.UserAccounts;

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
			"search", "writeReview", "buyTicket", "showTickets", "printTickets",
			"addShow" //administrator-restricted commands
			));
	
	public static final LinkedList<String> searchTypes = new LinkedList<String>(Arrays.asList(
			"category", "name", "review", "time"
			));
	
	private UserAccount currentUser;

	public CommandLogic() {
		currentUser = null;
		CommandLogic.shows = new ShowList(); //however these get implemented through the JSON
		this.UserAccounts  = new UserAccounts(); //however these get implemented through the JSON
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
	public ShowList getShows() {
		return shows;
	}
	/**
	 * @return: the list of users
	 */
	public UserAccounts getUsers() {
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
	 * @return: LinkedList of possible system commands
	 */
	public LinkedList<String> getSearchTypes() {
		return searchTypes;
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
	
	/**
	 * Searches for a show within the list of shows
	 * @return wantedShow: the wanted show
	 */
	public Show search(String searchType, String parameter) {
		Show wantedShow = null;
		
		if(searchType.contentEquals("category"))
			wantedShow = shows.categorySearch(parameter);
		else if(searchType.contentEquals("name"))
			wantedShow = shows.nameSearch(parameter);
		else if(searchType.contentEquals("review"))
			wantedShow = shows.reviewSearch(parameter);
		else if(searchType.contentEquals("time"))
			wantedShow = shows.showTimeSearch(parameter);
		
		return wantedShow;
	}
	
	public void writeReview(Show show, int starCount, String description) {
		currentUser.writeReview(show, description, starCount);
	}
	
	public String showTickets() {
		return currentUser.showTickets();
	}
	
	public void printTickets() { //TODO: figure out how this works w/ respect to fileIO
		currentUser.printTickets();
	}
	
	public void buyTicket(Show show) {
		currentUser.getShoppingCart().buyTicket(show);
	}
	
	public void addShow() {//TODO: this is about to take a looot of String variables; i'm not doing this
								//until I have a concrete "show" class
		if(!currentUser.isAdmin())
			return;
		
		Show newShow = new Show();
		shows.addShow(newShow);
	}
}

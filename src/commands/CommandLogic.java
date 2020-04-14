package commands;

import java.util.Arrays;
import java.util.LinkedList;

import shows.*;
import userAccounts.*;

/**
 * Handles the UI's command logic for interfacing w/ the system
 * @author Francis Villanueva (CSCE 247-001) //TODO team name
 *
 */
public class CommandLogic {
	private static CommandLogic commandLogic = null;
	
	//originally private, but changed to package for JUnit testing
	static ShowList shows;
	static UserAccounts users;
	
	public static final LinkedList<String> loginCommands = new LinkedList<String>(Arrays.asList(
			"login", "guest", "create"
			));	
	
	public static final LinkedList<String> sysCommands = new LinkedList<String>(Arrays.asList(
			"search", "writeReview", "buyTicket", "showTickets", "printTickets"
			));
	
	public static final LinkedList<String> adminCommands = new LinkedList<String>(Arrays.asList(
			"addShow" //administrator-restricted commands
			));
	
	public static final LinkedList<String> searchTypes = new LinkedList<String>(Arrays.asList(
			"category", "name", "review", "time"
			));
	
	public static final LinkedList<String> idTypes = new LinkedList<String>(Arrays.asList(
			"Senior", "Child", "Student", "Military", "Teacher", "Employee"
			));
	
	UserAccount currentUser; //originally private, but changed to package for JUnit testing

	private CommandLogic() {
		currentUser = null;
		shows = ShowList.getInstance();
		users = UserAccounts.getInstance();
	}
	
	/**
	 * Constructs a new instance of CommandLogic if one does not exist
	 * @return a static CommandLogic class
	 */
	public static CommandLogic getInstance() {
		if(commandLogic == null) {
			commandLogic = new CommandLogic();
		}
		return commandLogic;
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
		return users;
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
	 * @return LinkedList of possible admin commands
	 */
	public LinkedList<String> getAdminCommands() {
		return adminCommands;
	}
	/**
	 * @return: LinkedList of possible system commands
	 */
	public LinkedList<String> getSearchTypes() {
		return searchTypes;
	}
	/**
	 * @return LinkedList of possible id types
	 */
	public LinkedList<String> getIdTypes() {
		return idTypes;
	}
	
	/**
	 * Verifies if a command is a possible login command
	 * @param command: possible command
	 * @return: true if command is possible, false otherwise
	 */
	public boolean validLoginCommand(String command) {
		if(command == null)
			return false;
		return loginCommands.contains(command);
	}
	
	/**
	 * Logs user in as a guest
	 */
	public void guestLogin() {
		currentUser = new Guest();
	}
	
	/**
	 * Checks if current user is an administrator
	 * @return true if admin, false if otherwise
	 */
	public boolean isAdmin() {
		return currentUser.isAdmin();
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
	 * Registers a new user to the system, and adds it to the list of users
	 * @param name
	 * @param password
	 * @param paymentInfo
	 * @param ID
	 * @param idType
	 * @param age
	 * @param isHandicapped
	 * @return true if successful, false otherwise
	 */
	public boolean register(String name, String password, String paymentInfo, int ID, String idType,
			int age, boolean isHandicapped) {
		return users.register(name, password, paymentInfo, ID, idType, age, isHandicapped);
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
	
	/**
	 * Writes a review for the user
	 * @param show show to be reviewed
	 * @param starCount number of stars in review
	 * @param description review's description
	 * @return true if review written, false otherwise
	 */
	public boolean writeReview(Show show, int starCount, String description) {
		return currentUser.writeReview(show, description, starCount);
	}
	
	/**
	 * Returns a String of the current user's showTickets
	 * @return a String representation of showTickets
	 */
	public String showTickets() {
		return currentUser.showTickets();
	}
	
	/**
	 * Prints out tickets to a file
	 * @return true if successful, false otherwise
	 */
	public boolean printTickets() { //TODO: figure out how this works w/ respect to fileIO
		return currentUser.printTickets();
	}
	
	/**
	 * Buys a number of tickets
	 * @param amount amount of tickets bought
	 * @param show the show that the tickets are being bought from
	 * @return true if successful, false otherwise
	 */
	public boolean buyTicket(int amount, Show show) {
		return currentUser.getShoppingCart().buyTicket(amount, show);
	}
	
	/**
	 * Buys a number of tickets starting at a specific seat
	 * @param amount amount of tickets bought
	 * @param show the show that the tickets are being bought from
	 * @param seat the first seat to be purchased
	 * @return true if successful, false otherwise
	 */
	public boolean buyTicket(int amount, Show show, String seat) {
		return currentUser.getShoppingCart().buySeat(amount, show, seat);
	}
	
	//TODO: figure out better functionality for adding all shows
	
	/**
	 * Adds a movie to the current list of shows
	 * @param name
	 * @param showTime
	 * @param showDate
	 * @param venueName
	 * @param location
	 * @param ticketPrice
	 * @param actorList
	 * @param ageRestriction
	 * @param category
	 * @param movieSummary
	 * @param releaseDate
	 * @param directorName
	 * @param mpaRating
	 * @return true if show was added, false otherwise
	 */
	public boolean addMovie(String name, String showTime, String showDate, String venueName,
			String location, double ticketPrice, String actorList, int ageRestriction,
			String category, String movieSummary, String releaseDate, String directorName, 
			String mpaRating) {
		if(!currentUser.isAdmin())
			return false;
		
		MovieRating MPA = null;
		if(mpaRating.equals("G"))
			MPA = MovieRating.G;
		else if(mpaRating.equals("PG"))
			MPA = MovieRating.PG;
		else if(mpaRating.equals("PG13"))
			MPA = MovieRating.PG13;
		else if(mpaRating.equals("R"))
			MPA = MovieRating.R;
		else if(mpaRating.equals("NC17"))
			MPA = MovieRating.NC17;
		
		Movie newMovie = new Movie(name, showTime, showDate, venueName, location, ticketPrice,
				actorList, ageRestriction, category, movieSummary, releaseDate, directorName, MPA);
		return shows.addShow(newMovie);
		
	}
	/**
	 * Adds a play to the list of shows
	 * @param name
	 * @param showTime
	 * @param showDate
	 * @param venueName
	 * @param location
	 * @param ticketPrice
	 * @param actorList
	 * @param ageRestriction
	 * @param playSummary
	 * @param genre
	 * @return true if play was added, false otherwise
	 */
	public boolean addPlay(String name, String showTime, String showDate, String venueName,
			String location, double ticketPrice, String actorList, int ageRestriction, 
			String playSummary, String genre) {
		if(!currentUser.isAdmin())
			return false;
		
		Play newPlay = new Play(name, showTime, showDate, venueName, location, ticketPrice,
				actorList, ageRestriction, playSummary, genre);
		shows.addShow(newPlay);
		return true;
		
	}
	/**
	 * Adds a concert to the list of shows
	 * @param name
	 * @param showTime
	 * @param showDate
	 * @param venueName
	 * @param location
	 * @param ticketPrice
	 * @param actorList
	 * @param ageRestriction
	 * @param genre
	 * @return true if show was added, false otherwise
	 */
	public boolean addConcert(String name, String showTime, String showDate, String venueName,
			String location, double ticketPrice, String actorList, int ageRestriction, 
			String genre) {
		
		if(!currentUser.isAdmin())
			return false;
		
		Concert newConcert = new Concert(name, showTime, showDate, venueName, location, ticketPrice,
				actorList, ageRestriction, genre);
		return shows.addShow(newConcert);
	}
}

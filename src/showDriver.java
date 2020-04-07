import java.util.Scanner;

import commands.*;

/**
 * Controls the User Input Interface for the Show Finder Application
 * @author Francis Villanueva (CSCE 247-001) //TODO team name
 *
 * TODO: possibly implement an InputHandler class and its associated Commands
 */
public class showDriver {
	
	private static CommandLogic system;
	private static Scanner in;
	
	/**
	 * Handles all system input checks, and system output
	 */
	public void runShowDriver() {
		system = new CommandLogic();
		in = new Scanner(System.in);
		
		String command;
		System.out.println("Welcome to the Show Finder Application! \n");
		
		// Login block
		while(true) {
			System.out.println( "Type \"login\" if you have an existing account, "
								+ "\"create\" if you would like to create an account,"
								+ " and \"guest\" if you would like to continue with a guest account. \n"
								+ "Type \"exit\" at any time to quit the program.\n\n");
			
			command = getInputLine(in);
			
			if(command.contentEquals("exit"))
				exit();
			else if (command.contentEquals("guest")) {
				system.guestLogin();
				break; //TODO: I don't like this "break" repetition, find a better way to code this
			}
			else if(command.contentEquals("login")) {
				this.login();
				break;
			}
			else if(command.contentEquals("create")) {
				this.createUser();
				break;
			}
			else
				System.out.println("Command not recognized.  Please try again.\n\n");	 
		}
		
		System.out.println("Login successful! Welcome, " + system.getUser().getName() + ".");
		
		
		//Interface block
		while(true) {
			System.out.println("Type \"commands\" for a list of commands.");
			
			command = getInputLine(in);
			
			if(command.contentEquals("exit"))
				exit();
			else if(command.contentEquals("commands")) {
				System.out.print("Possible commands are: ");
				for(String commandName : system.getSysCommands())
					System.out.print(commandName + ", ");
				System.out.println(".");
			}
			else {
				if(command.contentEquals("search"))
					this.search();
				else if(command.contentEquals("writeReview"))
					this.writeReview();
				else if(command.contentEquals("buyTicket"))
					this.buyTicket();
				else if(command.contentEquals("showTickets")) //could probably call system directly
					this.showTickets();
				else if(command.contentEquals("printTickets")) //could probably call system directly
					this.printTickets();
				
				//admin restricted
				else if(command.contentEquals("addShow"))
					this.addShow(); 
				else
					System.out.println("Command not recognized.  Please try again.\n\n");	 
			}
		}
	}
	
	/**
	 * Handles output for logging into a user account
	 */
	public void login() {
		while(true) {
			System.out.println("Please input your username and password, in that order.\n");
			
			//TODO: think of a better way to "exit" within here
			String user = getInputLine(in);
			if(user.contentEquals("exit")) //short circuit exit command
				exit();
			
			String pwd = getInputLine(in);
			if(pwd.contentEquals("exit")) //short circuit exit command
				exit();
			
			if(!system.login(user,pwd)) {
				System.out.println("Login failed.  Please try again.\n\n");
			}
			else
				break;
		}
	}
	/**
	 * Handles output for creating a new user account
	 */
	public void createUser() {
		//low priority atm
	}
	
	/**
	 * Handles output for searching
	 */
	public void search() {
		while(true) {
			System.out.println("Please input the search type and parameter you would like to search for, "
					+ "in that order.");
			System.out.print("Search types are: ");
			for(String searchType : system.getSearchTypes())
				System.out.print(searchType + ", ");
			
			//TODO: think of a better way to "exit" within here
			String searchType = getInputLine(in); //TODO: error check "searchType"
			if(searchType.contentEquals("exit")) //short circuit exit command
				exit();
			
			String parameter = getInputLine(in);
			if(parameter.contentEquals("exit")) //short circuit exit command
				exit();
			
			Show displayShow = system.search(searchType, parameter);
			
			if(displayShow == null)
				System.out.println("Show not found.  Please try again.\n\n");
			else
				System.out.println(displayShow.toString());
		}
	}
	
	/**
	 * Handles output for leaving a review
	 */
	public void writeReview() {
		Show reviewedShow = null;
		
		System.out.println("For what show would you like to leave a review for?");
		String showName = getInputLine(in);
		reviewedShow = system.search("name",showName);
		
		while(reviewedShow == null) {
			System.out.println("Error: show name not found.  Please try again.");
			showName = getInputLine(in);
			reviewedShow = system.search("name",showName);
		}
		
		System.out.println("Please input your star rating out of 5.");
		int starCount = Integer.parseInt(getInputLine(in)); //TODO: error check; try/catch loop?
		
		System.out.println("Please write your review now.");
		String description = getInputLine(in);
		
		system.writeReview(reviewedShow, starCount,description);
		System.out.println("Review added to " + reviewedShow.getDescription.getName());
	}
	
	/**
	 * Handles output for buying a ticket
	 */
	public void buyTicket() {
		Show wantedShow = null;
		
		System.out.println("For what show would you like to buy a ticket for?");
		String showName = getInputLine(in);
		wantedShow = system.search("name",showName);
		
		while(wantedShow == null) {
			System.out.println("Error: show name not found.  Please try again.");
			showName = getInputLine(in);
			wantedShow = system.search("name",showName);
		}
		
		system.buyTicket(wantedShow);
		System.out.println("Ticket successfully purchased.");
		
		//TODO: seat tracker functionality as well
	}
	
	/**
	 * Handles output for showing a user's tickets
	 */
	public void showTickets() {
		system.showTickets();
	}
	
	/**
	 * Handles output for printing a user's tickets
	 */
	public void printTickets() {
		system.printTickets();
	}
	
	/**
	 * Handles output for adding a show to the show list
	 */
	public void addShow() {
		if(!system.getUser().isAdmin())
			System.out.println("Command not available for non-admin users.");
		else {
			//TODO: a bunch of scanner statements to get information about a show
		}
	}
	
	/**
	 * Shorthand method for finding scanner input
	 * @param in: name of scanner
	 * @return: returns scanner's input
	 */
	private String getInputLine(Scanner in) {
		return in.nextLine().toLowerCase().trim();
	}
	
	/**
	 * Exits program
	 */
	private void exit() {
		System.out.println("Goodbye!");
		System.exit(0); 
	}
	
	public static void main(String[] args) {
		showDriver showDriver = new showDriver();
		showDriver.runShowDriver();
	}
}

import java.util.LinkedList;
import java.util.Scanner;

import commands.*;
import shows.Show;

/**
 * Controls the User Input Interface for the Show Finder Application
 * @author Francis Villanueva (CSCE 247-001) //TODO team name
 *
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
				this.login();
				break;
			}
			else
				System.out.println("Command not recognized.  Please try again.\n\n");	 
		}
		
		System.out.println("\nLogin successful! Welcome, " + system.getUser().getName() + ".");
		
		
		//Interface block
		while(true) {
			System.out.println("Type \"commands\" for a list of commands.");
			
			command = getInputLine(in);
			
			if(command.contentEquals("exit"))
				exit();
			else if(command.contentEquals("commands")) {
				System.out.print("Possible commands are: ");
				if(!system.isAdmin())
					printList(system.getSysCommands());
				else
					printList(system.getAdminCommands());	 
				}
			
				else if(command.contentEquals("search"))
					this.search();
				else if(command.contentEquals("writeReview"))
					this.writeReview();
				else if(command.contentEquals("buyTicket"))
					this.buyTicket();
				else if(command.contentEquals("showTickets")) //could probably call system directly
					this.showTickets();
				else if(command.contentEquals("printTickets")) //could probably call system directly
					this.printTickets();
				else if(command.contentEquals("addShow") && system.isAdmin())
					this.addShow();
				else
					System.out.println("Command not recognized.  Please try again.\n\n");	
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
		String username, password, checkPassword, paymentInfo, idType, isDisabled;
		int ID, age;
		boolean isHandicapped;
		
		System.out.println("Enter a username.");
		username = getInputLine(in);
		
		System.out.println("Enter a password.");
		password = getInputLine(in);
		
		System.out.println("Confirm your password.");
		checkPassword = getInputLine(in);
		
		while(!password.equals(checkPassword)) { //String case-sensitive
			System.out.println("Passwords do not match. \nPlease re-enter your password.");
			
			System.out.println("Enter a password.");
			password = getInputLine(in);
			
			System.out.println("Confirm your password.");
		}
		
		System.out.println("Username and password successfully set.  Please input the following information:\n");
		
		//TODO: error check inputs for this whole block
		System.out.print("What is your payment info? ");
		paymentInfo = getInputLine(in);
		
		System.out.print("What is your ID number? ");
		ID = Integer.parseInt(getInputLine(in));
		
		System.out.println("What is your ID type? Choices are:");
		printList(system.getIdTypes());
		idType = getInputLine(in);
		
		System.out.print("What is your age? ");
		
		while((age = Integer.parseInt(getInputLine(in))) < 0) {
			System.out.print("Invalid age entered.  Please input a valid age: ");
		}
		
		System.out.print("Are you registered with the government as disabled? (Y\\N)");
		do {
			isDisabled = getInputLine(in);
		} while(isDisabled.contentEquals("Y") || isDisabled.contentEquals("N"));
		
		if(isDisabled.contentEquals("Y"))
			isHandicapped = true;
		else //used blanked "else" statement here b/c preceding do/while loop only allows max 2 cases
			isHandicapped = false;

		if(system.register(username, password, paymentInfo, ID, idType, age, isHandicapped))
			System.out.println("User creation successful.  Please log in with your new credentials.\n");
		else
			System.out.println("There was an error creating your account.  Please try again later.\n");
		
		return;
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
		System.out.println("Review added to " + reviewedShow.getName());
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
		
		System.out.println("How many tickets would you like to buy?");
		int ticketCount = Integer.parseInt(getInputLine(in)); //TODO: error check; try/catch loop?
		
		System.out.println("Would you like to pick your seats?");
		String choice = getInputLine(in);
		
		if(choice.equals("yes")) {
			wantedShow.getSeats().showAvailableSeats();
			
			System.out.println("Enter the row number and the seat letter");
			String seat = getInputLine(in);
			system.buyTicket(ticketCount, wantedShow, seat);
		} else {
			system.buyTicket(ticketCount, wantedShow);
		}
		
		System.out.println("Ticket successfully purchased.");
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
			System.out.println("What type of show would you like to add?  Your choices are: movie, concert, and play.");
			String showType = getInputLine(in);
			
			while(true) {
				if(showType.contentEquals("movie")) {
					System.out.println("Please input show name, show times, show date,"
							+ "venue name, location, ticket price, actor list,"
							+ "age restriction, and genre.");
					
					String name = getInputLine(in);
					String showtime = getInputLine(in);
					String showdate = getInputLine(in);
					String venue = getInputLine(in);
					String location = getInputLine(in);
					double price = Double.parseDouble(getInputLine(in));
					String actorList = getInputLine(in);
					int ageRestriction = Integer.parseInt(getInputLine(in));
					
					System.out.println("Now please input the movie category, movie summary, release date,"
							+ "director name, and MPA rating of the movie {G, PG, PG13, R, NC17}.");
					
					String category = getInputLine(in);
					String movieSummary = getInputLine(in);
					String releaseDate = getInputLine(in);
					String directorName = getInputLine(in);
					String mpaRating = getInputLine(in);
					
					system.addMovie(name, showtime, showdate, venue, 
							location, price, actorList, ageRestriction, 
							category, movieSummary, releaseDate, directorName, mpaRating);
					break;
				}
				else if(showType.contentEquals("concert")) {
					System.out.println("Please input show name, show times, show date,"
							+ "venue name, location, ticket price, actor list,"
							+ "age restriction, and genre.");
					
					String name = getInputLine(in);
					String showtime = getInputLine(in);
					String showdate = getInputLine(in);
					String venue = getInputLine(in);
					String location = getInputLine(in);
					double price = Double.parseDouble(getInputLine(in));
					String actorList = getInputLine(in);
					int ageRestriction = Integer.parseInt(getInputLine(in));
					
					System.out.println("Now please input the concert genre.");
					
					String genre = getInputLine(in);
					
					system.addConcert(name, showtime, showdate, venue, 
							location, price, actorList, ageRestriction, 
							genre);
					break;
				}
				else if(showType.contentEquals("play")) {
					System.out.println("Please input show name, show times, show date,"
							+ "venue name, location, ticket price, actor list,"
							+ "age restriction, and genre.");
					
					String name = getInputLine(in);
					String showtime = getInputLine(in);
					String showdate = getInputLine(in);
					String venue = getInputLine(in);
					String location = getInputLine(in);
					double price = Double.parseDouble(getInputLine(in));
					String actorList = getInputLine(in);
					int ageRestriction = Integer.parseInt(getInputLine(in));
					
					System.out.println("Now please input the play summary and the play category.");
					
					String summary = getInputLine(in);
					String category = getInputLine(in);
					
					system.addPlay(name, showtime, showdate, venue, 
							location, price, actorList, ageRestriction, 
							summary, category);
					break;
					
				}
				else
					System.out.println("Type not recognized. Please try again.");
			}
			System.out.println("Show successfully added.");
		}
	}
	
	/**
	 * Prints out a String interpretation of a list
	 * @param list the list to be printed out
	 * @return String interpretation of the list
	 */
	private String printList(LinkedList<String> list) {
		String printOut = "";
		
		for(int i=0; i<list.size()-1; i++)
			printOut += list.get(i) + ", ";
		printOut += list.get(list.size()-1);
		return printOut;
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
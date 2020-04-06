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
				system.
			}
		}
	}
	
	/**
	 * Handles output for logging into a user account
	 */
	public void login() {
		while(true) {
			System.out.println("Please input your username and password.\n");
			
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
		
	}
	
	/**
	 */
	
	/**
	 * Shorthand method for returning scanner input
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

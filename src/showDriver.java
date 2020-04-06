import java.util.Scanner;
import userAccounts.*;
import ui.*;

/**
 * Controls the User Input Interface for the Show Finder Application
 * @author Francis Villanueva (CSCE 247-001) //TODO team name
 *
 */
public class showDriver {
	
	/**
	 * Handles all system output
	 */
	public void runShowDriver() {
		CommandLogic system = new CommandLogic();
		
		Scanner in = new Scanner(System.in);
		String command;
		System.out.println("Welcome to the Show Finder Application! \n");
		
		while(true) {
			System.out.println( "Type \"login\" if you have an existing account, "
								+ "\"create\" if you would like to create an account,"
								+ " and \"guest\" if you would like to continue with a guest account. \n"
								+ "Type \"exit\" at any time to quit the program.");
			
			command = getInputLine(in);

			if(command.contentEquals("exit"))
				exit();
			
			
			if(!system.login(command)) {
				System.out.println("Login failed. Please try again.\n\n");
			}
			else if() {
				
			}
			else
				break;
				 
		}
		System.out.println("Login successful! Welcome, " + currentUser.getName() + ".");
		
		
		//Interface block
		while(true) {
			System.out.println("Type \"commands\" for a list of commands.");
			
			command = getInputLine(in);
			
			if(command.contentEquals("exit"))
				exit();
			else if(command.contentEquals("commands")) {
				System.out.print("Possible commands are: ");
				for(String commandName : commands)
					System.out.print(commandName + ", ");
				System.out.println(".");
			}
		}
	}
	
	private String getInputLine(Scanner in) {
		return in.nextLine().toLowerCase().trim();
	}
	
	private void exit() {
		System.out.println("Goodbye!");
		System.exit(0); 
	}
	
	public static void main(String[] args) {
		showDriver showDriver = new showDriver();
		showDriver.runShowDriver();
	}
}

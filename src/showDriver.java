import java.util.Scanner;
import userAccounts.*;

/**
 * Controls the User Input Interface for the Show Finder Application
 * @author Francis Villanueva
 *
 */
public class showDriver {
	//private static ShowList shows;
	//private static UserAccounts users;
	
	private UserAccount currentUser;
	
	private static final String[] commands = {"search", };
	
	/**
	 * Handles the system output
	 */
	public void runShowDriver() {
		Scanner in = new Scanner(System.in);
		String command;
		System.out.println("Welcome to the Show Finder Application! \n");
		
		//Login block -> maybe I should move this to the 'login' method body
		while(true) {
			System.out.println( "Type \"login\" if you have an existing account, "
								+ "\"create\" if you would like to create an account,"
								+ " and \"guest\" if you would like to continue with a guest account. \n"
								+ "Type \"exit\" at any time to quit the program.");
			//TODO: add UserLogic class
			command = getInputLine(in);

			if(command.contentEquals("exit"))
				exit();
			else
				this.currentUser = login(command);
			
			if(currentUser != null)
				break;
			else
				System.out.println("Login failed. Please try again.\n\n");
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
	
	private UserAccount login(String userType) {
		UserAccount attemptedUser = null;
		
		if(userType.contentEquals("login")) {
			attemptedUser = new StandardUser("input"); //TODO do input
		}
		else if(userType.contentEquals("guest")) {
			attemptedUser = new Guest();
		}
		else if(userType.contentEquals("create")) {
			attemptedUser = new StandardUser("created"); //TODO code 'createaccount' class handler?
		}
		else
			System.out.println("Command not recognized.");
		
		return attemptedUser;
	}
	
	private void exit() {
		System.out.println("Goodbye!");
		System.exit(0); 
	}
	
	public static void main(String[] args) {
		showDriver sDriver = new showDriver();
		sDriver.runShowDriver();
	}
}

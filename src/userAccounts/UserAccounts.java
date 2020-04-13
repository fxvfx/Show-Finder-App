package userAccounts;

/**
 * Keeps track of UserAccounts in system
 * @author Tariq Scott
 * @editor Francis Villanueva
 *
 */

import java.util.LinkedList;

import carts.ShoppingCart;
import shows.ShowList;
import tickets.TicketList;

public class UserAccounts {

	private static UserAccounts userAccounts = null;
//	UserAccount userAccount;
	private static LinkedList<UserAccount> users;
	
	private UserAccounts() {
		users = new LinkedList<UserAccount>();
	}
	
	public static UserAccounts getInstance() {
		
		if(userAccounts == null) {
			userAccounts = new UserAccounts();
		}
		
		return userAccounts;
	}
	
	private void addUser(UserAccount userAccount) {
		if(userAccount.isAdmin())
			users.add(userAccount);
	}
	
	public void removeUser(UserAccount userAccount) {
		if(userAccount.isAdmin())
			users.remove(userAccount);
	}
	
	public LinkedList<UserAccount> getUsers() {
		return users;
	}
	//(String name, String password, String paymentInfo, int iD, String idType,
	//int age, boolean isHandicapped) {
	
	/**
	 * Registers a new Standard user
	 * @param name user's username
	 * @param password user's password
	 * @param paymentInfo user's payment info
	 * @param ID user's ID
	 * @param idType user's ID type
	 * @param age user's age
	 * @param isHandicapped user's handicapped status
	 * @return true if successful, false otherwise
	 */
	public boolean register(String name, String password, String paymentInfo, int ID, String idType,
			int age, boolean isHandicapped) {
		UserAccount newUser = new StandardUser(name, password, paymentInfo, ID, idType, age, isHandicapped);
		return users.add(newUser);
	}
	
	/**
	 * Registers a new Administrator
	 * @param name administrator's username
	 * @param password administrator's password
	 * @param shows system's list of shows
	 * @param accounts system's list of accounts
	 * @return true if successful, false otherwise
	 */
	public boolean registerAdmin(String name, String password, ShowList shows, UserAccounts accounts) {
		UserAccount newAdmin = new Administrator(name, password, shows, accounts);
		return users.add(newAdmin);
	}
	
	/**
	 * Attempts to log in
	 * @param username
	 * @param password
	 * @return corresponding UserAccount w/ username and password; returns null if none found
	 */
	public UserAccount login(String username, String password) {
		for(int i=0; i<users.size(); i++) {
			if(users.get(i).getName().equals(username) && users.get(i).getPassword().equals(password)) {
				return users.get(i);
			}
		}
		return null;
	}
}

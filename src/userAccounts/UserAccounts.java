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
	
	UserAccount userAccount;
	TicketList myTicketList;
	ShoppingCart shoppingCart;	
	
	private LinkedList<UserAccount> users;
	
	public UserAccounts() {
		
	}
	
	private void addUser(UserAccount userAccount) {
		 users.add(userAccount);
	}
	
	public void removeUser(UserAccount user, UserAccount userAccount) {
		if(user.isAdmin())
			users.remove(userAccount);
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
	 */
	public void register(String name, String password, String paymentInfo, int ID, String idType,
			int age, boolean isHandicapped) {
		UserAccount newUser = new StandardUser(name, password, paymentInfo, ID, idType, age, isHandicapped);
		addUser(newUser);
	}
	
	/**
	 * Registers a new Administrator
	 * @param name administrator's username
	 * @param password administrator's password
	 * @param shows system's list of shows
	 * @param accounts system's list of accounts
	 */
	public void registerAdmin(String name, String password, ShowList shows, UserAccounts accounts) {
		UserAccount newAdmin = new Administrator(name, password, shows, accounts);
		addUser(newAdmin);
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
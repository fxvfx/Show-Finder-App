package userAccounts;

import shows.*;

/**
 * Specifies the Administrator methods
 * @author Francis Villanueva
 *
 */
public class Administrator extends UserAccount {
	private static ShowList shows;
	private static UserAccounts accounts;
	
	public Administrator(String name, String password, ShowList shows, UserAccounts accounts) {
		super(name,password,true);
		this.password = password;
		this.shows = shows;
		this.accounts  = accounts;
	}
	
	/**
	 * Adds a show to the system's list of shows
	 * @param show show to be added
	 */
	public void addShow(Show show) {
		shows.addShow(show);
	}
}

package userAccounts;

import java.io.File;
import java.io.PrintWriter;

import carts.*;

import shows.Show;
import tickets.TicketList;
import reviews.*;

/**
 * Specifies methods a UserAccount should have
 * @author Francis Villanueva
 *
 */
public abstract class UserAccount {
	
	protected String name;
	protected String password;
	private boolean isAdmin;
	
	//originally private, but changed visibility to package b/c JUnit test cases don't play nice w/ objects
	TicketList myTickets;
	ShoppingCart shoppingCart;
	PurchasedCart purchasedCart;
	
	
	public UserAccount(String name, String password, boolean isAdmin) {
		this.name = name;
		this.password = password;
		this.isAdmin = isAdmin;
		
		this.myTickets = new TicketList();
		this.shoppingCart = new ShoppingCart();
		this.purchasedCart = new PurchasedCart();
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the password
	 * TODO: maybe make this have to authenticate user before showing the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @return the isAdmin
	 */
	public boolean isAdmin() {
		return isAdmin;
	}
	/**
	 * @return the myTickets
	 */
	public TicketList getMyTickets() {
		return myTickets;
	}
	/**
	 * @return the shoppingCart
	 */
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	/**
	 * @return the purchasedCart
	 */
	public PurchasedCart getPurchasedCart() {
		return purchasedCart;
	}
	
	/**
	 * Shows contents of shopping cart
	 * @return String representation of the shopping cart
	 */
	public String showCart() {
		return this.shoppingCart.toString();
	}
	
	/**
	 * Shows contents of purchased cart
	 * @return String representation of the purchased cart
	 */
	public String showPurchased() {
		return this.purchasedCart.toString();
	}
	
	/**
	 * Shows the user's purchased tickets
	 * @return String representation of the user's purchased tickets
	 */
	public String showTickets() {
		return this.purchasedCart.showTickets();
	}
	
	/**
	 * Writes a review with the user as the owner
	 * @param show show the review belongs to
	 * @param reviewContent String content of the review
	 * @param numStars number of stars given to show
	 * @return true if added, false otherwise
	 */
	public boolean writeReview(Show show, String reviewContent, int numStars) {
		if(show != null && reviewContent != null && numStars > 0) {
			Review newReview = new Review(show,reviewContent,numStars,this);
			return show.addReview(newReview);
		}
		return false;
	}
	
	/**
	 * Prints tickets to file
	 *	@return true if successful, false otherwise
	 */
	public boolean printTickets() {
		try {
		File file = new File("file.txt");
		if(!file.exists()) {
			file.createNewFile();
		} 
		PrintWriter writer = new PrintWriter(file);
		writer.println("**********");
		writer.println("Ticket details: ");
		showTickets();
		writer.print("\t**********");
		writer.close();
		return true;
	} catch(Exception e) {
		System.out.println(e);
		return false;
	}
	}	
}

package userAccounts;

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
	
	private TicketList myTickets;
	private ShoppingCart shoppingCart;
	private PurchasedCart purchasedCart;
	
	
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
	public String purchasedCart() {
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
	 */
	public void writeReview(Show show, String reviewContent, int numStars) {
		Review newReview = new Review(show,reviewContent,numStars,this);
		show.addReview(newReview);
	}
	
	/**
	 * Prints tickets to file
	 *	TODO: figure out how the heck this works
	 */
	public void printTickets() {
		
	}
	
}

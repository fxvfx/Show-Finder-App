package userAccounts;

/**
 * Specifies methods a UserAccount should have
 * @author Francis Villanueva
 *
 */
public class UserAccount {
	protected String name;
	//protected TicketList myTickets;
	//protected ShoppingCart shoppingCart;
	
	public UserAccount(String name) {
		this.name = name;	
	}
	
	public String getName() {
		return name;
	}
}

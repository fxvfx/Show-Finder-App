package userAccounts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import reviews.Review;
import shows.Play;
import shows.Show;
import shows.ShowList;

/**
 * Tests the UserAccount class
 * @author Francis Villanueva
 *
 */
class UserAccountTest {
	static UserAccount user;
	static UserAccount buyer;
	static UserAccount admin;
	static Show aPlay;
	
	@BeforeAll
	public static void oneTimeSetup() {
		ShowList aShows = ShowList.getInstance();
		UserAccounts aUsers = UserAccounts.getInstance();
		
		user = new StandardUser("Maverick", "cutiepie", "aCreditCard", 1, "Military", 5, false);
		admin  = new Administrator("admin", "1234", aShows, aUsers);
		
		buyer = new StandardUser("Maverick", "cutiepie", "aCreditCard", 1, "Military", 5, false);
		aPlay = new Play("APlay", "11:11", "01/01/1010", 
		"MoviesRUs", "ARealAddress", 15.00, "John Cena", 21, "teen titans is AWESOME.", "RomCom");
		
		buyer.getShoppingCart().buyTicket(1, aPlay);
	}
	
	@Test
	void testGetName() {
		assertEquals(user.getName(), "Maverick");
	}
	
	@Test
	void testGetPassword() {
		assertEquals(user.getPassword(), "cutiepie");
	}
	
	@Test
	void testIsAdminFalse() {
		assertEquals(user.isAdmin(), false);
	}
	
	@Test
	void testIsAdminTrue() {
		assertEquals(admin.isAdmin(), true);
	}
	
	@Test
	void testGetMyTickets() {
		assertEquals(user.getMyTickets(), user.myTickets);
	}
	
	@Test
	void testGetShoppingCart() {
		assertEquals(user.getShoppingCart(), user.shoppingCart);
	}
	
	@Test
	void testGetPurchasedCart() {
		assertEquals(user.getPurchasedCart(), user.purchasedCart);
	}
	
	@Test
	void testShowCartEmpty() {
		String correctString = ("Your tickets are:\n\n");
		assertEquals(user.showCart(), correctString);
	}
	
	 //for these, I'm just assuming the toString actually prints; formatting's handled in the class toString itself
	@Test
	void testShowCartContent() {
		assertNotNull(buyer.showCart());
	}
	
	@Test
	void testShowPurchased() {
		assertNotNull(buyer.showPurchased());
	}
	
	@Test
	void testShowTickets() {
		assertNotNull(buyer.showTickets());
	}
	
	@Test
	void testPrintReview() {
		assertTrue(buyer.writeReview(aPlay, "This show was pretty good", 5));
	}
	
	@Test
	void testNullShowPrintReview() {
		assertFalse(buyer.writeReview(null, "This show was pretty good", 5));
	}
	
	@Test
	void testNullStringPrintReview() {
		assertFalse(buyer.writeReview(aPlay, null, 5));
	}
	
	@Test
	void testIncorrectNumStarPrintReview() {
		assertFalse(buyer.writeReview(aPlay, "This show was pretty good", -1));
	}
	
	@Test
	void testPrintFile() {
		assertTrue(buyer.printTickets());
		//fileIO errors (?)
	}
}

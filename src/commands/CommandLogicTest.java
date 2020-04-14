package commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import shows.Play;
import shows.Show;
import shows.ShowList;
import userAccounts.UserAccounts;

/**
 * Tests the CommandLogic class
 * @author Francis Villanueva
 *
 */
class CommandLogicTest {
	static CommandLogic system;
	static Show aPlay;
	
	@BeforeAll
	public static void oneTimeSetup() {
		system = CommandLogic.getInstance();
		system.getUsers().register("Maverick", "cutiepie", "aCreditCard", 1, "Military", 5, false);
		system.getUsers().registerAdmin("admin","1234",ShowList.getInstance(),UserAccounts.getInstance());
		
		aPlay = new Play("APlay", "11:11", "01/01/1010", 
		"MoviesRUs", "ARealAddress", 15.00, "John Cena", 21, "teen titans is AWESOME.", "RomCom");
		system.shows.addShow(aPlay);
		
	}
	
	@Test
	void testGetUser() {
		assertEquals(system.getUser(),system.currentUser);
	}
	
	@Test
	void testGetShows() {
		assertEquals(system.getShows(),CommandLogic.shows);
	}
	
	@Test
	void testGetUsers() {
		assertEquals(system.getUsers(),CommandLogic.users);
	}
	
	//for the "get a list" based methods the formatting is controlled in the CommandLogic class, I just want to make sure it's actually returning some string
	@Test
	void testGetLoginCommands() {
		assertNotNull(system.getLoginCommands());
	}
	
	@Test
	void testGetSysCommands() {
		assertNotNull(system.getSysCommands());
	}
	
	@Test
	void testGetAdminCommands() {
		assertNotNull(system.getAdminCommands());
	}
	
	@Test
	void testGetSearchTypes() {
		assertNotNull(system.getSearchTypes());
	}
	
	@Test
	void testGetIdTypes() {
		assertNotNull(system.getIdTypes());
	}
	
	@Test
	void testValidLoginCommand() {
		assertTrue(system.validLoginCommand("login"));
	}
	
	@Test
	void testInvalidLoginCommand() {
		assertFalse(system.validLoginCommand("neverACommand"));
	}
	
	@Test
	void testNullLoginCommand() {
		assertFalse(system.validLoginCommand(null));
	}
	
	@Test
	void testGuestLogin() {
		system.guestLogin();
		assertNotNull(system.getUser());
	}
	
	@Test
	void testValidLogin() {
		assertTrue(system.login("admin","1234"));
	}
	
	@Test
	void testInvalidLogin() {
		assertFalse(system.login("notaUserName","notAPassword"));
	}
	
	@Test
	void testGuestIsNotAdmin() {
		system.guestLogin();
		assertFalse(system.isAdmin());
	}
	
	@Test
	void testStandardUserIsNotAdmin() {
		system.login("Maverick","cutiepie");
		assertFalse(system.isAdmin());
	}
	
	@Test
	void testAdministratorIsAdmin() {
		system.login("admin","1234");
		assertTrue(system.isAdmin());
	}
	
	@Test
	void testValidRegister() {
		assertTrue(system.register("John", "aPassword", "aPaymentInfo", 7, "anIDType", 10, true));
	}
	
	@Test
	void testInvalidNameRegister() {
		assertFalse(system.register(null, "aPassword", "aPaymentInfo", 7, "anIDType", 10, true));
	}
	
	@Test
	void testInvalidPasswordRegister() {
		assertFalse(system.register("John", null, "aPaymentInfo", 7, "anIDType", 10, true));
	}
	
	@Test
	void testInvalidPaymentInfoRegister() {
		assertFalse(system.register("John", "aPassword", null, 7, "anIDType", 10, true));
	}
	
	@Test
	void testInvalidIDRegister() {
		assertFalse(system.register("John", "aPassword", "aPaymentInfo", -10, "anIDType", 10, true));
	}
	
	@Test
	void testInvalidIdTypeRegister() {
		assertFalse(system.register("John", "aPassword", "aPaymentInfo", 7, null, 10, true));
	}
	
	@Test
	void testInvalidAgeRegister() {
		assertFalse(system.register("John", "aPassword", "aPaymentInfo", 7, "anIDType", -10, true));
	}
	
	@Test
	void testFoundNameSearch() {
		assertNotNull(system.search("name","APlay"));
	}
	
	@Test
	void testNotFoundNameSearch() {
		assertNull(system.search("name","notInSystem"));
	}
	
	@Test
	void testFoundCategorySearch() {
		assertNotNull(system.search("category","RomCom"));
	}
	
	@Test
	void testNotFoundCategorySearch() {
		assertNull(system.search("category","notInSystem"));
	}
	
	@Test
	void testFoundReviewSearch() {
		system.login("Maverick","cutiepie");
		system.writeReview(aPlay, 5, "aReview");
		assertNotNull(system.search("review","aReview"));
	}
	
	@Test
	void testNotFoundReviewSearch() {
		assertNull(system.search("review","notInSystem"));
	}
	
	@Test
	void testFoundTimeSearch() {
		assertNotNull(system.search("time","11:11"));
	}
	
	@Test
	void testNotFoundTimeSearch() {
		assertNull(system.search("time","notInSystem"));
	}
	
	@Test
	void testPrintReview() {
		assertTrue(system.writeReview(aPlay, 5, "This show was pretty good"));
	}
	
	@Test
	void testNullShowPrintReview() {
		assertFalse(system.writeReview(null, 5, "This show was pretty good"));
	}
	
	@Test
	void testNullStringPrintReview() {
		assertFalse(system.writeReview(aPlay, 5, null));
	}
	
	@Test
	void testIncorrectNumStarPrintReview() {
		assertFalse(system.writeReview(aPlay, -1, "This show was pretty good"));
	}
	
	@Test
	void testShowTickets() {
		assertNotNull(system.showTickets());
	}
	
	@Test
	void testPrintTickets() {
		assertTrue(system.printTickets());
	}
	
	@Test
	void testBuyTicket() {
		assertTrue(system.buyTicket(1,aPlay));
	}
	
	@Test
	void testBuyTickets() {
		assertTrue(system.buyTicket(2,aPlay));
	}
	
	@Test
	void testBuyTicketSeat() {
		system.login("Maverick","cutiepie");
		assertTrue(system.buyTicket(2,aPlay,"1A"));
	}
	
	@Test
	void testAdminAddMovie() {
		system.login("admin","1234");
		assertTrue(system.addMovie("name", "showtime", "showdate", "venuename", "location", 1.05, "actorlist", 10, "category", "moviesummary", "releasedate", "directorname", "G"));
	}
	
	@Test
	void testAdminAddMovieG() {
		system.login("admin","1234");
		assertTrue(system.addMovie("name", "showtime", "showdate", "venuename", "location", 1.05, "actorlist", 10, "category", "moviesummary", "releasedate", "directorname", "G"));
	}
	
	@Test
	void testAdminAddMoviePG() {
		system.login("admin","1234");
		assertTrue(system.addMovie("name", "showtime", "showdate", "venuename", "location", 1.05, "actorlist", 10, "category", "moviesummary", "releasedate", "directorname", "PG"));
	}
	
	@Test
	void testAdminAddMoviePG13() {
		system.login("admin","1234");
		assertTrue(system.addMovie("name", "showtime", "showdate", "venuename", "location", 1.05, "actorlist", 10, "category", "moviesummary", "releasedate", "directorname", "PG13"));
	}
	
	@Test
	void testAdminAddMovieR() {
		system.login("admin","1234");
		assertTrue(system.addMovie("name", "showtime", "showdate", "venuename", "location", 1.05, "actorlist", 10, "category", "moviesummary", "releasedate", "directorname", "R"));
	}
	
	@Test
	void testAdminAddMovieNC17() {
		system.login("admin","1234");
		assertTrue(system.addMovie("name", "showtime", "showdate", "venuename", "location", 1.05, "actorlist", 10, "category", "moviesummary", "releasedate", "directorname", "NC17"));
	}
	
	@Test
	void testStandardUserAddMovie() {
		system.login("Maverick","cutiepie");
		assertFalse(system.addMovie("name", "showtime", "showdate", "venuename", "location", 1.05, "actorlist", 10, "category", "moviesummary", "releasedate", "directorname", "NC17"));
	}
	
	@Test
	void testAdminAddPlay() {
		system.login("admin","1234");
		assertTrue(system.addPlay("name", "showtime", "showdate", "venuename", "location", 1.05, "actorlist", 10, "playsummary", "genre"));
	}
	
	@Test
	void testStandardUserAddPlay() {
		system.login("Maverick","cutiepie");
		assertFalse(system.addPlay("name", "showtime", "showdate", "venuename", "location", 1.05, "actorlist", 10, "playsummary", "genre"));
	}
	
	@Test
	void testAdminAddConcert() {
		system.login("admin","1234");
		assertTrue(system.addConcert("name", "showtime", "showdate", "venuename", "location", 1.05, "actorlist", 10, "genre"));
	}
	
	@Test
	void testStandardUserAddConcert() {
		system.login("Maverick","cutiepie");
		assertFalse(system.addConcert("name", "showtime", "showdate", "venuename", "location", 1.05, "actorlist", 10, "genre"));
	}
}

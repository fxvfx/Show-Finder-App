package userAccounts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import shows.Play;
import shows.ShowList;

/**
 * Tests the Administrator class
 * @author Francis Villanueva
 *
 */
class AdministratorTest {
	
	static Administrator anAdmin;
	static Play aPlay;
	
	@BeforeAll
	public static void oneTimeSetup() {
		aPlay = new Play("APlay", "11:11", "01/01/1010", 
		"MoviesRUs", "ARealAddress", 15.00, "John Cena", 21, "teen titans is AWESOME.", "RomCom");
		
		ShowList aShows = ShowList.getInstance();
		UserAccounts aUsers = UserAccounts.getInstance();
		
		anAdmin = new Administrator("aName", "aPassword", aShows, aUsers);
	}

	@Test
	void testAddShow() {
		assertTrue(anAdmin.addShow(aPlay));
	}
	
	@Test
	void testAddShowNull() {
		assertFalse(anAdmin.addShow(null));
	}

}

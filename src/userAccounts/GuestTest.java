package userAccounts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import shows.Play;
import shows.ShowList;

/**
 * Tests the Guest class
 * @author Francis Villanueva
 *
 */
class GuestTest {
	static Guest Guest1;
	static Guest Guest2;
	
	@BeforeAll
	public static void oneTimeSetup() {
		Guest1 = new Guest();
		Guest2 = new Guest();
	}

	@Test
	void testToString() {
		String correctName = "Guest1";
		assertEquals(correctName, Guest1.toString());
	}
	
	@Test
	void testConstructorIncrementsCorrectly() {
		String correctName = "Guest2";
		assertEquals(correctName, Guest2.toString());
	}

}

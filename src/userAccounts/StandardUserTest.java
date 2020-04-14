package userAccounts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Tests the StandardUser class
 * @author Francis Villanueva
 *
 */
class StandardUserTest {

	static StandardUser aUser;
	
	@BeforeAll
	public static void oneTimeSetup() {
		aUser = new StandardUser("Maverick", "cutiepie", "aCreditCard", 1, "Military", 5, false);
	}

	@Test
	void testGetPaymentInfo() {
		assertEquals(aUser.getPaymentInfo(), "aCreditCard");
	}
	
	@Test
	void testGetID() {
		assertEquals(aUser.getID(), 1);
	}
	
	@Test
	void testGetIdType() {
		assertEquals(aUser.getIdType(), "Military");
	}
	
	@Test
	void testGetAge() {
		assertEquals(aUser.getAge(), 5);
	}
	
	@Test
	void testGetIsHandicapped() {
		assertEquals(aUser.isHandicapped(), false); //formatted like this b/c assertFalse wouldn't make sense in this context
	}
	
	@Test
	void testToString() {
		String correctString =  "User information:" +
				"\nUsername: Maverick" +
				"\npassword: cutiepie"+
				"\npaymentInfo: aCreditCard" + 
				"\nID: Military, 1" + 
				"\nAge: 5" +
				"\nHandicapped: false";
		assertEquals(aUser.toString(),correctString);
	}

}

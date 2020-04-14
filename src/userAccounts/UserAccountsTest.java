package userAccounts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import shows.ShowList;

class UserAccountsTest {

	static UserAccounts users;
	static UserAccount newUser;
	
	@BeforeAll
	public static void oneTimeSetup() {
		users = UserAccounts.getInstance();
		newUser = new StandardUser("Maverick", "cutiepie", "aCreditCard", 1, "Military", 5, false);
		users.getUsers().add(newUser);
	}
	
	@Test
	void testRemoveUser() {
		assertTrue(users.removeUser(newUser));
	}
	
	@Test
	void testRemoveNullUser() {
		assertFalse(users.removeUser(null));
	}
	
	@Test
	void testGetUsers() {
		assertEquals(users.getUsers(), users.users);
	}
	
	@Test
	void testRegister() {
		assertTrue(users.register("Maverick", "cutiepie", "aCreditCard", 1, "Military", 5, false));
	}
	
	@Test
	void testRegisterAdmin() {
		assertTrue(users.registerAdmin("admin", "1234", ShowList.getInstance(), UserAccounts.getInstance()));
	}
	
	@Test
	void testValidLogin() {
		assertNotNull(users.login("Maverick","cutiepie"));
	}
	
	@Test
	void testInvalidLogin() {
		assertNull(users.login("Maverick","thispasswordiswrong"));
	}
}

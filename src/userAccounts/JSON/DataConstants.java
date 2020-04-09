package userAccounts.JSON;

/**
 * Data constants for use in JSON user account files
 * @author Michael Norton (CSCE 247-001) //TODO team name
 *
 */
public abstract class DataConstants {

	//for UserAccount
	public static final String USER_FILE = "src/users.json";
	public static final String NAME = "name";
	public static final String PASSWORD = "pwd";
	public static final String IS_ADMIN = "isAdmin";
	
	//for StandardUser
	public static final String PAYMENT = "paymentInfo";
	public static final String ID = "ID";
	public static final String ID_TYPE = "idType";
	public static final String AGE = "age";
	public static final String HANDICAPPED = "isHandicapped";
	
}

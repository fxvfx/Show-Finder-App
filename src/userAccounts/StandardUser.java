package userAccounts;

/**
 * Specifies a StandardUser's methods
 * @author Francis Villanueva
 *
 */
public class StandardUser extends UserAccount {
	private String paymentInfo;
	private int ID;
	private String idType;
	private int age;
	private boolean isHandicapped;
	
	public StandardUser(String name, String password, String paymentInfo, int iD, String idType,
			int age, boolean isHandicapped) {
		
		super(name, password, false);
		this.paymentInfo = paymentInfo;
		this.ID = iD;
		this.idType = idType;
		this.age = age;
		this.isHandicapped = isHandicapped;
	}

	@Override
	public String toString() {
		return "User information:" +
				"\nUsername: " + name + 
				"\npassword: " + password + 
				"\npaymentInfo: " + paymentInfo + 
				"\nID: " + idType + ", " + ID + 
				"\nAge: " + age + 
				"\nHandicapped: " + isHandicapped;
	}
	
	
	
}

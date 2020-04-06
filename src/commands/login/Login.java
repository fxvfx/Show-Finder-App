package commands.login;

import commands.Command;

/**
 * Logs the user in.
 * @author Francis Villanueva
 *
 */
public class Login implements LoginCommand {
	private UserAccounts users;
	
	public Login(UserAccounts users) {
		this.users = users;
	}
	
	@Override
	public User execute() {
		return users.login()
	}
}

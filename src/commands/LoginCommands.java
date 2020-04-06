package commands;

import commands.login.*;

/**
 * Specifies the login commands
 * @author Francis Villanueva
 *
 */
public class LoginCommands extends CommandList{
	private UserAccounts users;
	
	public LoginCommands(CommandLogic system) {
		super(system);
		users = system.getUsers();
		
		commands.put("login", new LoginCommand(users));
		commands.put("create", new CreateCommand(users)));
		commands.put("guest", new LoadCommand(users));
	}
}

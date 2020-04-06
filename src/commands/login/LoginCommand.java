package commands.login;

/**
 * Specifies the methods of a login command
 * @author Francis Villanueva
 *
 */
public interface LoginCommand {
	/**
	 * Performs the command's action
	 */
	public User execute();
}

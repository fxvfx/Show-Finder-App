package commands;

import java.util.HashMap;

/**
 * Specifies methods of a CommandList
 * @author Francis Villanueva
 *
 */
abstract class CommandList {
	private HashMap<String, Command> commands;
	
	public CommandList(CommandLogic system) {
		commands = new HashMap<>();
	}
	
	/**
	 * Validates/runs the user's command key input
	 * @param data: string key to the commands HashMap
	 * @return: true if valid input entered, false otherwise
	 */
	public boolean inputEntered(String data) {
		if(commands.containsKey(data)) { //does not deal with case sensitivity
			commands.get(data).execute();
			return true;
		}
		return false;
	}
}

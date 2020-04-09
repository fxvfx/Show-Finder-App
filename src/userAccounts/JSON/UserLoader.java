package userAccounts.JSON;

import java.io.*;
import java.util.LinkedList;
import org.json.simple.*;
import org.json.simple.parser.*;

import shows.ShowList;
import userAccounts.*;
/**
 * Loads users from JSON file
 * @author Michael Norton (CSCE 247) //TODO team name
 *
 */
public class UserLoader extends DataConstants {

	/**
	 * Loads list of UserAccounts from JSON files
	 * @return linked list of UserAccount for UserAccounts
	 */
	public static LinkedList<UserAccount> LoadUsers() {
		LinkedList<UserAccount> users = new LinkedList<UserAccount>();
		
		try {
			FileReader reader = new FileReader(USER_FILE);
			JSONParser parser = new JSONParser();
			JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i = 0; i < usersJSON.size(); i++) {
				JSONObject userJSON = (JSONObject)usersJSON.get(i);
				
				String name = (String) userJSON.get(NAME);
				String password = (String) userJSON.get(PASSWORD);
				boolean isAdmin = (Boolean) userJSON.get(IS_ADMIN);
				
				if(isAdmin) {
					users.add(new Administrator(name, password, ShowList.getInstance(), 
							UserAccounts.getInstance()));
				} else if(!isAdmin) {
					String paymentInfo = (String) userJSON.get(PAYMENT);
					int id = (Integer) userJSON.get(ID);
					String idType = (String) userJSON.get(ID_TYPE);
					int age = (Integer) userJSON.get(AGE);
					boolean isHandicapped = (Boolean) userJSON.get(HANDICAPPED);
					
					users.add(new StandardUser(name, password, paymentInfo, id, idType, age, isHandicapped));
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

		return users;
	}
}

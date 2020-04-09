package userAccounts.JSON;

import java.io.*;
import java.util.LinkedList;
import org.json.simple.*;
import org.json.simple.parser.*;


import userAccounts.*;
/**
 * Writes user accounts to JSON file
 * @author Michael Norton (CSCE 247-001) //TODO team name
 *
 */
public class UserWriter extends DataConstants {

	public static void saveShows() {
		
		UserAccounts userAccounts = UserAccounts.getInstance();
		LinkedList<UserAccount> users = userAccounts.getUsers();
		
		JSONArray jsonUsers = new JSONArray();
		
		for(UserAccount u : users) {
			jsonUsers.add(getUserJSON(u));
		}
	}
	
	public static void saveUsers(JSONArray jsonUsers) {
		
		try(FileWriter file = new FileWriter(USER_FILE)){
			file.write(jsonUsers.toJSONString());
			file.flush();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static JSONObject getUserJSON(UserAccount user) {
		
		JSONObject userDetails = new JSONObject();
		userDetails.put(NAME, user.getName());
		userDetails.put(PASSWORD, user.getPassword());
		userDetails.put(IS_ADMIN, user.isAdmin());
		
		if(!user.isAdmin()) {
			StandardUser sUser = (StandardUser) user;
			userDetails.put(AGE, sUser.getAge());
			userDetails.put(HANDICAPPED, sUser.isHandicapped());
			userDetails.put(ID, sUser.getID());
			userDetails.put(ID_TYPE, sUser.getIdType());
			userDetails.put(PAYMENT, sUser.getPaymentInfo());
			
		}
		
		return userDetails;
	}
}

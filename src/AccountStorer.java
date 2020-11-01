import org.json.simple.JSONArray;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;



public class AccountStorer {
	

	// This ideally is where we'd put the JSON reader/writer?
	public static AccountStorer accountstorer;

	
	public AccountStorer() {
		
	}
	

	public void writeAccounts(ArrayList<Account> accounts) {
	
		JSONArray jsonaccounts = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< accounts.size(); i++) {
			jsonaccounts.add(getaccountJSON(accounts.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter("src/account.json")) {
 
            file.write(jsonaccounts.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	private static JSONObject getaccountJSON(Account account) {
		
		JSONObject accountDetails = new JSONObject();
		accountDetails.put("accountName", account.getAccountName());
		accountDetails.put("fullName", account.getUserFullName());
		accountDetails.put("username", account.getUserName());
		accountDetails.put("password", account.getPassword());
		accountDetails.put("dob", account.getDob());
		accountDetails.put("phoneNumber", account.getPhoneNumber());
		
		
        return accountDetails;
	}


	public ArrayList<Account> readAccounts() {
		
		ArrayList<Account> returnAccounts = new ArrayList<Account>();
			
			try {
				FileReader reader = new FileReader("src/account.json");
				JSONParser parser = new JSONParser();
				JSONArray jsonaccounts = (JSONArray) parser.parse(reader);
				
				for(int i = 0; i < jsonaccounts.size(); i++) {
					JSONObject JSONaccount = (JSONObject)jsonaccounts.get(i);
					Account account = new Account();
					account.setAccountName((String) JSONaccount.get("accountName"));
					account.setUserFullName((String) JSONaccount.get("fullName"));
					account.setUserName((String) JSONaccount.get("username"));
					account.setPassword((String) JSONaccount.get("password"));
					account.setDob((String) JSONaccount.get("dob"));
					account.setPhoneNumber((String) JSONaccount.get("phoneNumber"));

					
					returnAccounts.add(account);
					}
				
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return returnAccounts;
	}



	
	
	
	
}

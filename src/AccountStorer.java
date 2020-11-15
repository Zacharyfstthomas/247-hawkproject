import org.json.simple.JSONArray;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;


/**
 * Stores all Accounts from the JSON reader/writer
 * @author hkael
 *
 */
public class AccountStorer {
	

	// This ideally is where we'd put the JSON reader/writer?
	public static AccountStorer accountstorer;
	private static final String FILELOCATION = "src/account.json";
	private static final String ACCOUNTNAME = "accountName";
	private static final String ADDRESS= "address";
	private static final String FULLNAME = "fullName";
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	private static final String DOB= "dob";
	private static final String PHONENUMBER = "phoneNumber";

	/**
	 * Default constructor for AccountStorer
	 */
	public AccountStorer() {
		
	}
	
	/**
	 * creates a new JSON array and then gets the size of the array followed by a try catch block for the JSON file
	 * @param accounts
	 */
	public void writeAccounts(ArrayList<Account> accounts) {
	
		JSONArray jsonaccounts = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< accounts.size(); i++) {
			jsonaccounts.add(getaccountJSON(accounts.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(FILELOCATION)) {
 
            file.write(jsonaccounts.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * creates a new JSONobject and put all the variables that define an account into the file
	 * @param account
	 * @return all the details of a given account
	 */
	private static JSONObject getaccountJSON(Account account) {
		
		JSONObject accountDetails = new JSONObject();
		accountDetails.put(ACCOUNTNAME, account.getAccountName());
		accountDetails.put(ADDRESS, account.getaddress());
		accountDetails.put(FULLNAME, account.getUserFullName());
		accountDetails.put(USERNAME, account.getUserName());
		accountDetails.put(PASSWORD, account.getPassword());
		accountDetails.put(DOB, account.getDob());
		accountDetails.put(PHONENUMBER, account.getPhoneNumber());
		
		
        return accountDetails;
	}

	/**
	 * Allows the JSON files to be read
	 * @return accounts
	 */
	public ArrayList<Account> readAccounts() {
		
		ArrayList<Account> returnAccounts = new ArrayList<Account>();
			
			try {
				FileReader reader = new FileReader(FILELOCATION);
				JSONParser parser = new JSONParser();
				JSONArray jsonaccounts = (JSONArray) parser.parse(reader);
				
				for(int i = 0; i < jsonaccounts.size(); i++) {
					JSONObject JSONaccount = (JSONObject)jsonaccounts.get(i);
					Account account = new Account();
					account.setAccountName((String) JSONaccount.get(ACCOUNTNAME));
					account.setUserFullName((String) JSONaccount.get(FULLNAME));
					account.setaddress((String) JSONaccount.get(ADDRESS));
					account.setUserName((String) JSONaccount.get(USERNAME));
					account.setPassword((String) JSONaccount.get(PASSWORD));
					account.setDob((String) JSONaccount.get(DOB));
					account.setPhoneNumber((String) JSONaccount.get(PHONENUMBER));

					
					returnAccounts.add(account);
					}
				
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return returnAccounts;
	}



	
	
	
	
}

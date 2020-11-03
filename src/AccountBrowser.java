import java.util.ArrayList;

/**
 * Allows a user to browse through account 
 * @author hkael
 *
 */
public class AccountBrowser {
	
	/**
	 * Variables for AccountBowser
	 */
	public ArrayList<Account> accounts;
	public static AccountBrowser accountbrowser;
	private AccountStorer accountstorer;
	
	/**
	 * Checks to see of the account browser is empty and if it is it creates a new account browser
	 * @return the accountbrowser
	 */
	public static AccountBrowser getInstance() {
		if(accountbrowser == null) {
			return new AccountBrowser();
		}
		return accountbrowser;
	}
	
	/**
	 * Constructor for AccountBrowser and stores an ArrayList of all the accounts the user is searching for
	 */
	private AccountBrowser() {
		this.accounts = new ArrayList<Account>();
		accountstorer = new AccountStorer();
	}
	
	/**
	 * Accessor for the ArrayList account, checks to see the account a user is searching for is a real account
	 * @param accountName
	 * @return the account if it is found if not returns null
	 */
	public Account getAccount(String accountName) {
		
		for(Account account : accounts) {
			if(account.getAccountName().equals(accountName)) {
				return account;
			}
		}
		
		return null;
	}
	
	/**
	 * 
	 */
	public void writeAccounts(){
		
		accountstorer.writeAccounts(this.accounts);
	}
	
	/**
	 * 
	 */
	public void readAccounts(){
		
		this.accounts = accountstorer.readAccounts();
	}
	
	/**
	 * Adds an account into the system
	 * @param account
	 */
	public void addAccount(Account account) {
		accounts.add(account);
		this.writeAccounts();
	}
	
	/**
	 * Creates a new account with all of the variables that define an account
	 * @param accountName
	 * @param userFullName
	 * @param dob
	 * @param address
	 * @param phoneNumber
	 * @param userName
	 * @param password
	 */
	public void addAccount(String accountName, String userFullName, String dob, String address, String phoneNumber, String userName, String password) {
		Account account1 = new Account(accountName, userFullName, dob, address, phoneNumber, userName, password);
		accounts.add(account1);
		this.writeAccounts();
	}
}
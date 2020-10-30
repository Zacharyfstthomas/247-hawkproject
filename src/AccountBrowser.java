import java.util.ArrayList;

public class AccountBrowser {
	
	public ArrayList<Account> accounts;
	public static AccountBrowser accountbrowser;
	private int count;
	
	public static AccountBrowser getInstance() {
		if(accountbrowser == null) {
			return new AccountBrowser();
		}
		return accountbrowser;
	}
	
	private AccountBrowser() {
		this.count = 0;
		this.accounts = new ArrayList<Account>();
	}
	
	public void addAccount(String accountName, String userFullName, int dob, String emailAddress, int phoneNumber, String userName, String password, Review reviews) {
		Account account1 = new Account(accountName, userFullName, dob, emailAddress, phoneNumber, userName, password, reviews);
		accounts.add(account1);
	}
}
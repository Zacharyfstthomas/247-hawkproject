import java.util.ArrayList;

public class AccountBrowser {
	
	public ArrayList<Account> accounts;
	public static AccountBrowser accountbrowser;
	private AccountStorer accountstorer;
	
	public static AccountBrowser getInstance() {
		if(accountbrowser == null) {
			return new AccountBrowser();
		}
		return accountbrowser;
	}
	
	private AccountBrowser() {
		this.accounts = new ArrayList<Account>();
		accountstorer = new AccountStorer();
	}
	
	
	public Account getAccount(String accountName) {
		
		for(Account account : accounts) {
			if(account.getAccountName().equals(accountName)) {
				return account;
			}
		}
		
		return null;
	}
	
	public void writeAccounts(){
		
		accountstorer.writeAccounts(this.accounts);
	}
	
	public void readAccounts(){
		
		this.accounts = accountstorer.readAccounts();
	}
	
	public void addAccount(Account account) {
		accounts.add(account);
		this.writeAccounts();
	}
	
	public void addAccount(String accountName, String userFullName, String dob, String address, String phoneNumber, String userName, String password) {
		Account account1 = new Account(accountName, userFullName, dob, address, phoneNumber, userName, password);
		accounts.add(account1);
		this.writeAccounts();
	}
}
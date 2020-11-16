import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.BeforeEach.*;
import static org.junit.jupiter.api.AfterEach.*;
import static org.junit.jupiter.api.Test.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach.*;
import org.junit.jupiter.api.AfterEach.*;
import org.junit.jupiter.api.Test.*;

public class AccountStorerTest {

	private AccountBrowser accountbrowser = AccountBrowser.getInstance();
	private ArrayList<Account> account = AccountStorer.readAccounts();
	
	@BeforeEach
	public void setup() {
		accountbrowser.account = account;
		accountbroswer.account.clear();
		
		accountbrowser.addAccount("Hunter", "Hunter Kaelin", "123 state st", "HK", "coding", "october", "123-456-7890");
		accountbrowser.addAccount("Patrick", "Patrick Star", "Bikini Bottom", "PS", "rock", "november", "098-765-4321");
		accountbrowser.addAccount("qwerty", "The Rock", "New York", "Mountain", "pass", "july", "111-111-1111");
		AccountStorer.writeAccounts();
		
	}
 	
	@AfterEach
	public void tearDown() {
		accountbrowser.accounts.clear();
		AccountStorer.writeAccount(accountbrowser.accounts);
	}
	
	@Test
	public void testWriteAccount() {
		
	}
	
	@Test
	public void testGetAccountJSON() {
		
	}
	
	@Test
	public void test readAccounts() {
		
	}
	
	
}

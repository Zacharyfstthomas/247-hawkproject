import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AccountBrowserTest {
	public ArrayList<Account> accounts;
	public static AccountBrowser accountbrowser;
	private AccountStorer accountstorer;
	
/*
 * tests for getInstance
 */
	@Test
	public void testEmptyAccountBrowser_CreatesNewAccountBrowser(AccountBrowser accountbrowser) {
		assertNull("should be null & create new browser" , new AccountBrowser());
	}
	
	@Test
	public void testOccupiedAccountBrowser_ReturnsAccountBrowser(AccountBrowser accountbrowser) {
		assertNotNull("should not be null & return accountbrowser" , accountbrowser);
	}
/*
 * tests for AccountBrowser
 */
	@Test
	public void testIfBrowser() {
		testAcc = new Account(jsmithfield , jimmyroad);
		assertEquals("success - new account arraylist" , accountstorer);
	}
	
/*
 * tests for getAccount
 */
	@Test
	public void testAccountExists_ReturnsAccount(String accountName) {
		String accountName = "mike";
		assertEquals("success - mike exists", "mike" , account.getAccountName());
	}
	//assert null
	@Test
	public void testAccountDoesntExist_ReturnsNull(String accountName) {
		String accountName = "sallyJoe";
		assertEquals("success - sallyJoe doesn't exist, return null", null, account.getAccountName());
	}
	
/*
 * tests for addAccount
 */
	@Test
	public void testCreateValidAccount() {
		accounts.add("hannahFaus" , "Hannah Faus" , "11122000" , "1929 Bluff Rd" , "9199851195" , "hfaus" , "myPassword");
		account = new Account();
		assertEquals("success - hfaus account created" ,  )//unsure about here
	}

/*
 * tests for writeAccounts and readAccounts
 */
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	
	@Test
	public void testWriteAndReadAccounts() {
		File file = folder.newFile("testAccountFile.txt");
		FileUtils.writeStringToFile(testAccountFile, "jasonBlue - new account");
		final String str = FileUtils.readFileToString(testAccountFile);
		assertEquals("jasonBlue - new account" , str);
	}
	
}


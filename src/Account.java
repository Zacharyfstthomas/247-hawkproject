/**
 * This class represents everything a user needs for their account and while setting a constructor for Account and uses accessors and mutators for all the variables that go into an account
 * @author hkael
 *
 */
public class Account {

	/**
	 * variables for Account all of which are protected
	 */
	protected String accountName;
	protected String userFullName;
	protected String dob;
	protected String address;
	protected String phoneNumber;
	protected String userName;
	protected String password;
	
	/**
	 * Default constructor for Account
	 */
	public Account() {
		
		
	}
	
	/**
	 * Constructor for Account 
	 * @param accountName
	 * @param userFullName
	 * @param dob
	 * @param address
	 * @param phoneNumber
	 * @param userName
	 * @param password
	 */
	public Account(String accountName, String userFullName, String dob, String address, String phoneNumber, String userName, String password) {
		this.accountName = accountName;
		this.userFullName = userFullName;
		this.dob = dob;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
	}

	 /**
	  * Accessor for the name of the user's account
	  * @return accountName
	  */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * Mutator for AccountName and sets the accountName equal to accountName
	 * @param accountName
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	  * Accessor for the user's full name
	  * @return userFullName
	  */
	public String getUserFullName() {
		return userFullName;
	}

	/**
	 * Mutator for UserFullName and sets the userFullName equal to userFullName
	 * @param userFullName
	 */
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	/**
	  * Accessor for Dob
	  * @return dob
	  */
	public String getDob() {
		return dob;
	}

	/**
	 * Mutator for Dob and sets dob equal to dob
	 * @param dob
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	  * Accessor for the user's address
	  * @return address
	  */
	public String getaddress() {
		return address;
	}

	/**
	 * Mutator for address and sets address equal to address
	 * @param address
	 */
	public void setaddress(String address) {
		this.address = address;
	}

	/**
	  * Accessor for the user's phone number
	  * @return phoneNumber
	  */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Mutator for PhoneNumber and sets phoneNumber equal to phoneNumber
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	  * Accessor for a user's user name
	  * @return userName
	  */
	public String getUserName() {
		return userName;
	}

	/**
	 * Mutator for UserName and sets userName equal to userName
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	  * Accessor for user's password
	  * @return password
	  */
	public String getPassword() {
		return password;
	}

	/**
	 * Mutator for Password and sets password equal to password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
}
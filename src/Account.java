public class Account {

	protected String accountName;
	protected String userFullName;
	protected int dob;
	protected String emailAddress;
	protected int phoneNumber;
	protected String userName;
	protected String password;
	protected Review reviews;
	
	public Account(String accountName, String userFullName, int dob, String emailAddress, int phoneNumber, String userName, String password, Review reviews) {
		this.accountName = accountName;
		this.userFullName = userFullName;
		this.dob = dob;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
		this.reviews = reviews;
	}
	
	public void viewPage() {}
	
	public void deleteAccount() {}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public int getDob() {
		return dob;
	}

	public void setDob(int dob) {
		this.dob = dob;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Review getReviews() {
		return reviews;
	}

	public void setReviews(Review reviews) {
		this.reviews = reviews;
	}
	
	
	
}
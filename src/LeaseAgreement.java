import java.io.*;
import java.util.Date;

public class LeaseAgreement extends Listing{
	private Listing listing;
	private String zipcode;
	private String leaseStart;
	private String leaseEnd;
	
	
	public LeaseAgreement(Listing listing) {
		
		this.listing = listing;
		
	}
	
	
	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getLeaseStart() {
		return leaseStart;
	}


	public void setLeaseStart(String leaseStart) {
		this.leaseStart = leaseStart;
	}


	public String getLeaseEnd() {
		return leaseEnd;
	}


	public void setLeaseEnd(String leaseEnd) {
		this.leaseEnd = leaseEnd;
	}


	// may take parameters of three Accounts, user account, included account, and landlord account (for our sakes we can have this be person who created the listing, i hope.) Included account can be null (no other tenants).	
	public void writeLeaseAgreement(Account mainStudent, Account friendStudent, Account landlord) throws FileNotFoundException, IOException {
	//Scanner input = new Scanner(System.in);
	
		try {
		// this creates or overwrites the file input.txt in the local src folder
			PrintWriter newFile = new PrintWriter(new FileOutputStream("input.txt"));
			Date date = new Date();
		
			newFile.println("This Lease Agreement is made and entered on "+ date.toString() +" by and between <LANDLOARD> and <TENANT(s)>.\r");
			newFile.println("Subject to the terms and conditions stated below the parties agree as follows:\r");
			newFile.println("1. Landloard Tenant Act. This Rental Agreement is governed by the South Carolina Residential Landlord and Tenant Act.\r");
			newFile.println("2. Property. Landloard, in consideration of the lease payments provided in this agreement, leases to Tenant a house with " + listing.getBedrooms() + " bedrooms and " + listing.getBedrooms() + " bathrooms, located at " + listing.getAddress() + ", South Carolina "+ this.zipcode+". No other portion of the building wherein the Property is located is included unless expressly provided for in this agreement.\r"); 
				
			newFile.println("3. Term. The Tenant will coninue to pay rent from "+this.leaseStart+" to "+this.leaseStart+".\r");
			newFile.println("4. Rent. The Tenant will pay $"+listing.getPrice()+" each month on the first of the month.\r");
			newFile.println("5. Payment should be sent to:<PAYMENT ADDRESS>\r"); //landlord account address
			newFile.println("6. Damages. Charges will be billed to the client for damaged property.\r"); 
			newFile.println("7. Signatures\r");
			newFile.println();
			newFile.println("---------------------------");
			newFile.println(mainStudent.getUserFullName()); // main tenant, aka current user initializing the lease
			
		if(friendStudent != null) {
			newFile.println();
			newFile.println("---------------------------");
			newFile.println(friendStudent.getUserFullName()); // account.name or somethin
		}
		
		newFile.println();
		newFile.println("---------------------------");
		newFile.println(landlord.getUserFullName()); 
			newFile.close();
		
			} catch (Exception e) {
				e.getMessage();
		
			}
	
	

	}
}
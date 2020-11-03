import java.io.*;
import java.util.Date;

/**
 * Required to be able to rent a listing
 * @author hkael
 *
 */
public class LeaseAgreement extends Listing{
	
	/**
	 * Variables for LeaseAgreement
	 */
	private Listing listing;
	private String zipcode;
	private String leaseStart;
	private String leaseEnd;
	
	
	/**
	 * Constructor for LeaseAgreement
	 * @param listing
	 */
	public LeaseAgreement(Listing listing) {
		
		this.listing = listing;
		
	}
	
	/**
	 * Accessor for Zipcode
	 * @return zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * Mutator for Zipcode and sets the zipcode equal to zipcode
	 * @param zipcode
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * Accessor for when a lease will start
	 * @return leaseStart
	 */
	public String getLeaseStart() {
		return leaseStart;
	}

	/**
	 * Mutator for LeaseStart and sets leaseStart equal to leaseStart
	 * @param leaseStart
	 */
	public void setLeaseStart(String leaseStart) {
		this.leaseStart = leaseStart;
	}

	/**
	 * Accessor for when the lease will end
	 * @return leaseEnd
	 */
	public String getLeaseEnd() {
		return leaseEnd;
	}

	/**
	 * Mutator for LeaseEnd and sets leaseEnd equal to leaseEnd
	 * @param leaseEnd
	 */
	public void setLeaseEnd(String leaseEnd) {
		this.leaseEnd = leaseEnd;
	}

	/**
	 * Goes through and creates a new file of the lease agreement and sets the terms of the lease
	 * @param mainStudent
	 * @param friendStudent
	 * @param landlord
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	// may take parameters of three Accounts, user account, included account, and landlord account (for our sakes we can have this be person who created the listing, i hope.) Included account can be null (no other tenants).	
	public void writeLeaseAgreement(Account mainStudent, Account friendStudent, Account landlord) throws FileNotFoundException, IOException {
	//Scanner input = new Scanner(System.in);
	
		try {
		// this creates or overwrites the file input.txt in the local src folder
			PrintWriter newFile = new PrintWriter(new FileOutputStream("LeaseAgreement.txt"));
			Date date = new Date();
		
			newFile.println("This Lease Agreement is made and entered on "+ date.toString() +" by and between "+mainStudent.getUserFullName()+" and "+mainStudent.getUserFullName()+".\r");
			newFile.println("Subject to the terms and conditions stated below the parties agree as follows:\r");
			newFile.println("1. Landloard Tenant Act. This Rental Agreement is governed by the South Carolina Residential Landlord and Tenant Act.\r");
			newFile.println("2. Property. Landloard, in consideration of the lease payments provided in this agreement, leases to Tenant a house with " + listing.getBedrooms() + " bedrooms and " + listing.getBedrooms() + " bathrooms, located at " + listing.getAddress() + ", South Carolina "+ this.zipcode+". No other portion of the building wherein the Property is located is included unless expressly provided for in this agreement.\r"); 
				
			newFile.println("3. Term. The Tenant will coninue to pay rent from "+this.leaseStart+" to "+this.leaseStart+".\r");
			newFile.println("4. Rent. The Tenant will pay $"+listing.getPrice()+" each month on the first of the month.\r");
			newFile.println("5. Payment should be sent to:"+landlord.getaddress()+"\r"); //landlord account address
			newFile.println("6. Damages. Charges will be billed to the client for damaged property.\r"); 
			newFile.println("7. Signatures\r");
			newFile.println();
			newFile.println("---------------------------");
			newFile.println(mainStudent.getUserFullName()); // main tenant, aka current user initializing the lease
			
		if(friendStudent != null) {
			newFile.println();
			newFile.println("---------------------------");
			newFile.println(friendStudent.getUserFullName()); 
		}
		
		newFile.println();
		newFile.println("---------------------------");
		newFile.println(landlord.getUserFullName()); 
			newFile.close();
			System.out.println("Lease Agreement Generated");
		
			} catch (Exception e) {
				System.out.println(e.getMessage());
		
			}
	
	

	}
}
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
public class HousingDriver {

	
	boolean loggedIn = false;
	//ideally to be used to log into an account, and register new accounts.
	// "registering" referring to writing them into a json file.
	
	public void promptAccount() {
		Scanner input = new Scanner(System.in);
		AccountBrowser accounts = AccountBrowser.getInstance();
		System.out.println("Welcome back! Do you have an account with us?");
		String choice = input.nextLine();
		
		if(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")){
			boolean tryagain = true;
			while(tryagain) {
			System.out.println("Username:");
			String username = input.nextLine();
			System.out.println("Password:");
			String password = input.nextLine();
			
			boolean accFlag = false;
			for(Account account : accounts.accounts) {
				if(account.getUserName().equals(username) && account.getPassword().equals(password)) {
					accFlag = true;
					loggedIn = true;
					
				} 
			}
			
			if(!accFlag) {
				System.out.println("Incorrect username/password. Try again?");
				if(choice.equalsIgnoreCase("no") || choice.equalsIgnoreCase("n")) {
					tryagain = false;
					}
				}
			}
			//TODO Add verification ability through accountPage or accountBrowser, so it can actually verify that someone
			// is logging into an actual account. As of now, just takes 2 inputs..
			
		} else {
			System.out.println("Would you like to create one?");
			choice = input.nextLine();
			if(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")){
				
				System.out.println("Enter your Account Display name:");
				String accountName = input.nextLine();
				System.out.println("Enter your Full name:");
				String userFullName = input.nextLine();
				System.out.println("Enter your Username:");
				String userName = input.nextLine();
				System.out.println("Enter your Password:");
				String password = input.nextLine();
				System.out.println("Enter your Date of birth (mm/dd/yyyy):");
				String dob = input.nextLine();
				System.out.println("Enter your Phone Number:");
				String phoneNumber= input.nextLine();
				System.out.println("Enter your Address:");
				String address= input.nextLine();
				
				
				accounts.addAccount(accountName, userFullName, dob, address, phoneNumber, userName, password);
				//Other account details will be added here.
			} 
				
			return;
		
		}
		
	}
	
	
	
	
	
	public void run() throws FileNotFoundException, IOException {
		
		
		while(true) {	
			
			
			Scanner input = new Scanner(System.in);
			ListingBrowser listings = ListingBrowser.getInstance();
			SearchListings find = new SearchListings();
			
			
			listings.readListings();
		//ListingStorer listingmanager = new ListingStorer();
//							price address am. available, 2 bed 2 bath, distance, type, available(boolean), description
			
			
		//	listings.addListing(40, "453 Gervais St", 4, 2, 2, 0.5, "house", true, "mediocre");
		//	listings.addListing(40, "753 Gervais St", 6, 3, 2, 0.75, "house", true, "shabby");
			
			
			listings.getListing(1).addAmmenity("clownworld");
		
			
			
			listings.display();
	
		
		
		
			System.out.println("Would you like to search for a specific listing?");
			String choice = input.nextLine();
			if(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")){
			// the below line has poor naming, but basically gets the arraylist from the listing instance.
			ArrayList<Listing> resultsListings = find.getCriteria(listings.listings);
			
			
			System.out.println("Would you like to search for ammenities?");
			choice = input.nextLine();
		
			if(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
				System.out.println("Enter your ammenities of interest, type \"done\" when finished.");
					String amenity;
					while(true){
						amenity = input.nextLine();
						if(amenity.equalsIgnoreCase("done")) {
							listings.display(resultsListings);
							break;
						}
						resultsListings = find.findAmmenitiesMatches(amenity, resultsListings);
						if(resultsListings.size() == 0) {
							listings.display(resultsListings);
							break;
						}
					}	
					
		
			} else {
				listings.display(resultsListings);
			}
			
			
		
			}
			
			System.out.println("Would you like to produce a lease agreement for a lisitng?");
			 choice = input.nextLine();
			 
			if(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")){
				if(!loggedIn) {
					System.out.println("You need to log in to produce a lease agreeement");
				} else {
				System.out.println("Which lease are you interested in? Choose them using their number.");
				int IDchoice = -1;
				try {
				IDchoice = input.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Invalid input, ignoring.");
				}
				 boolean foundFlag = false;
				for(Listing listing : listings.listings) {
					if(listing.getId() == IDchoice){
						foundFlag = true;
						LeaseAgreement leaseSign = new LeaseAgreement(listing);
						System.out.println("Excellent choice! We just need a few things from you.");
						input.nextLine();
						System.out.println("What is the zipcode of the address?");
						String answer = input.nextLine();
						leaseSign.setAddress(answer);
						System.out.println("When do you plan to begin the lease?");
						answer = input.nextLine();
						leaseSign.setLeaseStart(answer);
						System.out.println("When do you plan to end the lease?");
						answer = input.nextLine();
						leaseSign.setLeaseEnd(answer);
						leaseSign.writeLeaseAgreement(null, null, null);
						//absolute bugtesting
					}
				}
				if(!foundFlag) {
					System.out.println("That listing was not found.");
					}
				}
			}
			
			
			
			System.out.println("Continue?");
			String exitchoice = input.nextLine();
			if(exitchoice.equals("no")){
				System.exit(0);
			}
			
			if(listings.getCount() > 5) {
				System.out.println("Return to previous page?");
				String backchoice = input.nextLine();
			if(backchoice.equals("yes")){
				listings.pageBackward();
				}
			}
			
		}
	
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		HousingDriver stockDriver = new HousingDriver();
		stockDriver.promptAccount();
		stockDriver.run();
	}
	
	
}

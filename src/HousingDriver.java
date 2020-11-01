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
		accounts.readAccounts();
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
					tryagain = false;
					System.out.println("Login successful.");
				} 
			}
			
			if(!accFlag) {
				System.out.println("Incorrect username/password. Try again?");
				choice = input.nextLine();
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
				loggedIn = true;
				//Other account details will be added here.
				System.out.println("Account successfully created. Press enter to continue");
				input.nextLine();
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
	
			if(loggedIn) {
				ArrayList<String> driverammenities = new ArrayList<String>();
				System.out.println("Would you like to add a listing?");
				String choice = input.nextLine();
				if(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")){
					System.out.println("Excellent!");
					
					System.out.println("Enter the listing's price:");
					double price = Double.parseDouble(input.nextLine());
					System.out.println("Enter the listing's address:");
					String address = input.nextLine();
					System.out.println("Enter the listing's distance from campus:");
					double distance = Double.parseDouble(input.nextLine());
					System.out.println("Enter amount of availabilities at the listing");
					int capacity = Integer.parseInt(input.nextLine());
					System.out.println("Enter the type of listing (house, apartment, ect.):");
					String housingType = input.nextLine();
					System.out.println("Enter amount of bedrooms at the listing");
					int bedrooms = Integer.parseInt(input.nextLine());
					System.out.println("Enter amount of bathrooms at the listing");
					int baths= Integer.parseInt(input.nextLine());
					System.out.println("Enter the listing's description:");
					String description= input.nextLine();
					
					System.out.println("Does the listing have ammenities? :");
					boolean hasAmmenties = false;
					choice = input.nextLine();
					if(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")){
							hasAmmenties = true;
							
							System.out.println("Enter the ammenties you want to add, type \"done\" when finished.");
							
							while(true){
								
								String ammenity = input.nextLine();
								driverammenities.add(ammenity);
								if(ammenity.equalsIgnoreCase("done")) {
									break;
								}
							}
							
								
						}
					
					Listing listing = new Listing(price, address, capacity, bedrooms, baths, distance, housingType, true, description);
					if(hasAmmenties) {
							listing.createAmmenitiesArrayList();
							for(String ammenity : driverammenities) {
									listing.addAmmenity(ammenity);
							}
							
							
						}
					
					listings.addListing(listing);
				}
			}
		
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
						System.out.println("Successfully generated a lease agreement.");
					//	listing.setAvaliability(false);
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
				listings.writeListings();
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

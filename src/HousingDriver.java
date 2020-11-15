import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * 
 * @author hkael, zacstthomas, hfaus, groach
 *
 */
public class HousingDriver {

	Account userAccount; 
	boolean loggedIn = false;
	//ideally to be used to log into an account, and register new accounts.
	// "registering" referring to writing them into a json file.
	
	/**
	 * Starts the program and checks to see if you have an account which the user will then input their username and password.
	 * If the user doesn't have an account they will be asked if they want to create one and go through the account creation process.
	 */
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
					userAccount = account;
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
			//Add verification ability through accountPage or accountBrowser, so it can actually verify that someone
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
	
	/**
	 * This runs the program, a user can either add a listing inputing all the details a certain listing has or search for a listing inputting everything they are looking for in a certain listing.
	 * If the user finds a listing that is suitable for them the program will ask if they want to see a lease agreement which the user will be required to log in for. 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void run() throws FileNotFoundException, IOException {
		
		while(true) {	
			Scanner input = new Scanner(System.in);
			ListingBrowser listings = ListingBrowser.getInstance();
			SearchListings find = new SearchListings();
			listings.readListings();	
			if(listings.listings == null || listings.listings.size() == 0) {
				System.out.println("No results found.");
				} else {
					System.out.print("Results:");
					System.out.println(listings.display());
				}
			if(loggedIn) {
				System.out.println("Would you like to add a listing?");
				String choice = input.nextLine();
				if(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")){
					System.out.println("Excellent!");
					System.out.println("Are you creating a complex?");
						choice = input.nextLine();
						if(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")){
							//ComplexCreation method, updates the listings for us
							listings = ComplexCreation(listings,input);
						}else {
					//Singular Listing Addition method
							listings = addSingleListing(listings, input);
					}
				continue;
				}
			}
		
			System.out.println("Would you like to search for a specific listing?");
			String choice = input.nextLine();
			if(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")){
			
			ArrayList<Listing> resultsListings = getCriteria(listings.listings, find);
			if(resultsListings != null) {
				System.out.println("Would you like to search for ammenities?");
				choice = input.nextLine();
				if(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
				//addAmmenitiesToListing(Scanner input, ListingBrowser listings)
					
				System.out.println("Enter your ammenities of interest, type \"done\" when finished.");
					String amenity;
					while(true){
						amenity = input.nextLine();
						if(amenity.equalsIgnoreCase("done")) {
							System.out.println("Results:");
							System.out.println(listings.display(resultsListings));
							break;
							}
						resultsListings = find.findAmmenitiesMatches(amenity, resultsListings);
						if(resultsListings.size() == 0) {
							System.out.println("Results:");
							System.out.println(listings.display(resultsListings));
							break;
							}
						}	
					} else {
						System.out.println("Results:");
					System.out.println(listings.display(resultsListings));
				}
			
				if(resultsListings.size() == 0) {
				System.out.println("No results found.");
					}
				
				}
			}
			
			System.out.println("Would you like to produce a lease agreement for a lisitng?");
			 choice = input.nextLine();
			 
			if(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")){
				if(!loggedIn) {
					System.out.println("You need to log in to produce a lease agreeement");
				} else {
					AccountBrowser accounts = AccountBrowser.getInstance();
					accounts.readAccounts();
				System.out.println("Which lease are you interested in? Choose them using their number.");
				int IDchoice = -1;
				try {
				IDchoice = input.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Invalid input, ignoring.");
				}
				//Old code here (everything inside leaseSignPrompts)
				leaseSignPrompts(IDchoice, listings, input,accounts);
				}
			}
			System.out.println("Continue?");
			String exitchoice = input.nextLine();
			if(exitchoice.equalsIgnoreCase("no") || exitchoice.equalsIgnoreCase("n")){
				System.exit(0);
			}
			
			
		}
	
	}
	
	private ArrayList<Listing> getCriteria(ArrayList<Listing> listings, SearchListings find) {
		find.listings = listings;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your criteria of search:");
		String criteria = input.nextLine(); 
		
		if(criteria.equalsIgnoreCase("price") || criteria.equalsIgnoreCase("distance")) {
			System.out.println("Enter the value to search for:");
			double doubValue = input.nextDouble(); 
			return find.findDoubMatches(criteria, doubValue);
		}
		 
		if(criteria.equalsIgnoreCase("address") || criteria.equalsIgnoreCase("description") || criteria.equalsIgnoreCase("housing type") || criteria.equalsIgnoreCase("housing") || criteria.equalsIgnoreCase("housingtype") ) {
			System.out.println("Enter the value to search for:");
			String strnValue = input.next(); 
			return find.findStrnMatches(criteria, strnValue);
		}
		
		if(criteria.equalsIgnoreCase("bedrooms") || criteria.equalsIgnoreCase("baths") || criteria.equalsIgnoreCase("amountavaliable") || criteria.equalsIgnoreCase("amount avaliable") || criteria.equalsIgnoreCase("id")) {
			System.out.println("Enter the value to search for:");
			int intValue = input.nextInt(); 
			return find.findIntMatches(criteria, intValue);
			
		}
		
		System.out.println("Invalid criteria selection, will ignore");
		return null;
	}

	private ListingBrowser addSingleListing(ListingBrowser listings, Scanner input){
		
		ArrayList<String> ammenitiesList = new ArrayList<String>();
		System.out.println("Enter the listing's price per month:");
		double price = Double.parseDouble(input.nextLine());
		System.out.println("Enter the listing's address:");
		String address = input.nextLine();
		System.out.println("Enter the listing's distance from campus:");
		double distance = Double.parseDouble(input.nextLine());
		System.out.println("Enter amount of availabilities at the listing:");
		int capacity = Integer.parseInt(input.nextLine());
		System.out.println("Enter the type of listing (house, apartment, ect.):");
		String housingType = input.nextLine();
		System.out.println("Enter amount of bedrooms at the listing");
		int bedrooms = Integer.parseInt(input.nextLine());
		System.out.println("Enter amount of bathrooms at the listing");
		int baths= Integer.parseInt(input.nextLine());
		System.out.println("Enter the listing's description:");
		String description= input.nextLine();
		//Account name we can get from what they logged in as
		String owner = userAccount.getAccountName(); 

		System.out.println("Does the listing have ammenities?");
		boolean hasAmmenties = false;
		String choice = input.nextLine();
		
		if(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")){
			hasAmmenties = true;
			System.out.println("Enter the ammenties you want to add, type \"done\" when finished.");
			while(true){
				String ammenity = input.nextLine();
				if(ammenity.equalsIgnoreCase("done")) {
					break;
				}
				ammenitiesList.add(ammenity);
			}
		}

		Listing listing = new Listing(price, address, capacity, bedrooms, baths, distance, housingType, true, description,owner);
		if(hasAmmenties) {
			listing.createAmmenitiesArrayList();
			for(String ammenity : ammenitiesList) {
				listing.addAmmenity(ammenity);
			}
		}
		
		listings.addListing(listing);
		
		return listings;
	
	}
	
	
	private ListingBrowser ComplexCreation(ListingBrowser listings, Scanner input) {
		
		ArrayList<String> ammenitiesList = new ArrayList<String>();
		System.out.println("How many suites are you adding?");
		int suites = Integer.parseInt(input.nextLine());
		System.out.println("Enter the complex's address:");
		String address = input.nextLine();
		System.out.println("Enter the complex's distance from campus:");
		double distance = Double.parseDouble(input.nextLine());
		System.out.println("Enter the type of suites:");
		String housingType = input.nextLine();
		System.out.println("Does the complex have ammenities? :");
		boolean hasAmmenties = false;
		String choice = input.nextLine();
		if(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")){
				hasAmmenties = true;
				
				System.out.println("Enter the ammenties you want to add, type \"done\" when finished.");
				
				while(true){
					
					String ammenity = input.nextLine();
					ammenitiesList.add(ammenity);
					if(ammenity.equalsIgnoreCase("done")) {
						break;
					}
				}
				
					
			}
		
		
		for(int i = 0; i < suites; i++){
			System.out.println("Enter suite "+(i+1)+"'s availabilities:");
			int capacity = Integer.parseInt(input.nextLine());
			System.out.println("Enter amount of bedrooms at the suite");
			int bedrooms = Integer.parseInt(input.nextLine());
			System.out.println("Enter amount of bathrooms at the suite");
			int baths= Integer.parseInt(input.nextLine());
			System.out.println("Enter the suite's price per month:");
			double price = Double.parseDouble(input.nextLine());
			System.out.println("Enter the listing's description:");
			String description= input.nextLine();
			System.out.println("Enter your account name:");
			String owner = input.nextLine(); 
			Listing listing = new Listing(price, address, capacity, bedrooms, baths, distance, housingType, true, description, owner);
			listings.addListing(listing);
			if(ammenitiesList.size() != 0){
				for(String ammenity : ammenitiesList) {
					listing.addAmmenity(ammenity);
				}
				
			}
			
		}
		
		return listings;
		
		
	}
	

	private void leaseSignPrompts(int idChoice, ListingBrowser listings , Scanner input, AccountBrowser accounts) throws FileNotFoundException, IOException{
		
		 boolean foundFlag = false;
		 
		 //Method here to do this
		for(Listing listing : listings.listings) {
			if(listing.getId() == idChoice){
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
				System.out.println("Are you signing with someone else?");
				answer = input.nextLine();
				if(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
					System.out.println("Enter their account name");
					String friendAccountName = input.nextLine();
					//Your account name: grab from userAccount
					String accountName = userAccount.getAccountName(); 
					//The landlord account's name: grab from the listing's owner string.
					String landLordAccountName = listings.getListing(idChoice).getOwner();
				try {
					leaseSign.writeLeaseAgreement(accounts.getAccount(accountName), accounts.getAccount(friendAccountName), accounts.getAccount(landLordAccountName));
					
					} catch (NullPointerException e) {
						System.out.println("Freind's account wasn't found. The lease agreement was not generated.");
					}
				} else {
					String accountName = userAccount.getAccountName(); 
					//The landlord account's name: grab from the listing's owner string.
					String landLordAccountName = listings.getListing(idChoice).getOwner();
				
				try {
					leaseSign.writeLeaseAgreement(accounts.getAccount(accountName), null, accounts.getAccount(landLordAccountName));
					
					}catch (NullPointerException e) {
						System.out.println("One of those accounts wasn't found. The lease agreement was not generated.");
					}	
				}//	listing.setAvaliability(false);
			}
		}
		if(!foundFlag) {
			System.out.println("That listing was not found.");
			}
		
		
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		HousingDriver stockDriver = new HousingDriver();
		stockDriver.promptAccount();
		stockDriver.run();
	}
	
	
}

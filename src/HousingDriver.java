import java.util.Scanner;
import java.util.ArrayList;
public class HousingDriver {

	//ideally to be used to log into an account, and register new accounts.
	// "registering" referring to writing them into a json file.
	
	public void promptAccount() {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome back! Do you have an account with us?");
		String choice = input.nextLine();
		
		if(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")){
			System.out.println("Username:");
			String username = input.nextLine();
			System.out.println("Password:");
			String password = input.nextLine();
			//TODO Add verification ability through accountPage or accountBrowser, so it can actually verify that someone
			// is logging into an actual account. As of now, just takes 2 inputs..
			
		} else {
			System.out.println("Would you like to create one?");
			choice = input.nextLine();
			if(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")){
				System.out.println("Enter your Username:");
				String username = input.nextLine();
				System.out.println("Enter your Password:");
				String password = input.nextLine();
				//Other account details will be added here.
			} 
				
			return;
		
		}
		
	}
	
	
	
	
	
	public void run() {
		
		
		while(true) {	
			
			
			Scanner input = new Scanner(System.in);
			ListingBrowser listings = ListingBrowser.getInstance();
			SearchListings find = new SearchListings();
		//ListingStorer listingmanager = new ListingStorer();
//							price address am. available, 2 bed 2 bath, distance, type, available(boolean), description
			listings.addListing(40, "453 Gervais St", 4, 2, 2, 0.5, "house", true, "mediocre");
			listings.addListing(40, "753 Gervais St", 6, 3, 2, 0.75, "house", true, "shabby");
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
					
				//TODO add something here to search a listing's ammenities, and see if they match the inputted ammenities.
				// Only searches through the resultsListings arrayList, as these are the only ones who will have ammeneties that matter.
				// Should still show the reulstsLisitng, even if there are no ammeneties matches.
						
			} else {
				listings.display(resultsListings);
			}
			
			
			//also search for amenities
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
	
	public static void main(String[] args){
		HousingDriver stockDriver = new HousingDriver();
		stockDriver.promptAccount();
		stockDriver.run();
	}
	
	
}

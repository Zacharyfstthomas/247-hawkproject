import java.util.Scanner;
public class HousingDriver {

	
	
	
	public void run() {
		while(true) {	
		Scanner input = new Scanner(System.in);
		ListingBrowser listings = ListingBrowser.getInstance();
		SearchListings find = new SearchListings();
		//ListingStorer listingmanager = new ListingStorer();
//							price address am. available, 2 bed 2 bath, distance, type, available(boolean), description
		listings.addListing(40, "453 Gervais St", 4, 2, 2, 0.5, "house", true, "mediocre");

		
		listings.display();
	
		
		
		
		
		System.out.println("Would you like to search for a specific listing?");
		String choice = input.nextLine();
		if(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")){
			// the below line has poor naming, but basically gets the arraylist from the listing instance.
			listings.display(find.getCriteria(listings.listings));
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
		stockDriver.run();
	}
	
	
}

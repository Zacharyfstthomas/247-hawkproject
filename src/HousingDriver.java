import java.util.Scanner;
public class HousingDriver {

	
	
	
	public void run() {
		while(true) {	
		Scanner input = new Scanner(System.in);
		ListingBrowser listings = ListingBrowser.getInstance();
		Search find = new Search();
		//ListingStorer listingmanager = new ListingStorer();
		listings.addListing(40, "453 Gervais St", 4, 0.5, "house", true, "mediocre");

		
		listings.display();
	
		
		
		
		
		System.out.println("Would you like to search for a specific listing?");
		String choice = input.nextLine();
		if(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")){
			find.getCriteria();
			//also search for amenities
		}
		
			System.out.println("Continue?");
			String exitchoice = input.nextLine();
			if(choice.equals("no")){
				System.exit(0);
			}
			
			if(listings.getCount() > 5) {
			System.out.println("Return to previous page?");
			String backchoice = input.nextLine();
			if(choice.equals("yes")){
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

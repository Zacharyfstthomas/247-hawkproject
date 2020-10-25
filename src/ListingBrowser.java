import java.util.ArrayList;

public class ListingBrowser {

	public ArrayList<Listing> listings;
	public static ListingBrowser listingbrowser;
	private int count;
	
	public static ListingBrowser getInstance() {
		if(listingbrowser == null) {
			return new ListingBrowser();
		} 
		
		return listingbrowser;
	}
	
	
	private ListingBrowser() {
		this.count = 0;
		this.listings = new ArrayList<Listing>();
		
	}
	
	//**ADD TO UML**

	//As of now, used for adding default listings.
	//Likely will be used for the other accounts as well.
	public void addListing(double price, String address, int capacity, double distance, String housingType, boolean avaliable, String description) {
		Listing listing1 = new Listing(price, address, capacity, distance, housingType, avaliable, description);
		listings.add(listing1);
		listing1.setId(listings.size()-1);
		//TODO code here to add to JSON file
	}
	
//count here is used to ensure that 5 listings are displayed a page.
// Will hopefully continue through a steady line of all available listings
// try-catch will break out of display when at the end of the list
	public void display() {
		do{
			try {
				Listing listing = listings.get(count);
				if(listing.getAvaliability()) {
				System.out.println("--------------- Listing " + (listing.getId() + 1) + " ------------------");	
				System.out.println(listing.toString());
					}	
				count++;
			} catch(IndexOutOfBoundsException e){
				return;
			}
		}while(count % 5  != 0);
		
		
		
	}
	//is this nessicary?
	public void pageForward() {
		
	
	}
	
	public int getCount() {
		
		return this.count;
	}
	
	public void pageBackward() {
		if(count % 5 == 0) {
			++count;
		}
		count = count - 5;
	}

	
	
}

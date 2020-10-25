import java.util.ArrayList;

public class ListingBrowser {

	public ArrayList<Listing> listings;
	public static ListingBrowser listingbrowser;
	
	public static ListingBrowser getInstance() {
		if(listingbrowser == null) {
			return new ListingBrowser();
		} 
		
		return listingbrowser;
	}
	
	
	private ListingBrowser() {
		
		this.listings = new ArrayList<Listing>();
		
	}
	
	//**ADD TO UML**

	//As of now, used for adding default listings.
	//Likely will be used for the other accounts as well.
	public void addListing(double price, String address, int capacity, double distance, String housingType, boolean avaliable, String description) {
		Listing listing1 = new Listing(price, address, capacity, distance, housingType, avaliable, description);
		listings.add(listing1);
		listing1.setId(listings.size()-1); 
	}
	

	
	public void display() {
		for(Listing listing : listings){
			if(listing.getAvaliability()) {
			System.out.println("--------------- Listing " + listing.getId() + " ------------------");	
			System.out.println(listing.toString());
			}	
		}
	}

	public void pageForward() {}
	
	public void pageBackward() {}

	
	
}

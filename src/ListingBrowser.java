
import java.util.ArrayList;

public class ListingBrowser {

	public ArrayList<Listing> listings; 
	public static ListingBrowser listingbrowser;
	private ListingStorer listingsstorer;
	private int count;
	
	public static ListingBrowser getInstance() {
		if(listingbrowser == null) {
			return new ListingBrowser();
		}
		
		return listingbrowser;
	}


	private ListingBrowser() {
		this.count = 0;
		this.listingsstorer = new ListingStorer();
	}
	
	//**ADD TO UML**

	//As of now, used for adding default listings.
	//Likely will be used for the other accounts as well.
	public void addListing(double price, String address, int capacity, int bedrooms, int baths, double distance, String housingType, boolean avaliable, String description, String owner) {
		Listing listing1 = new Listing(price, address, capacity,  bedrooms, baths, distance, housingType, avaliable, description, owner);
		this.listings.add(listing1);
		listing1.setId(listings.size());
		this.writeListings();
		
	}
	// not sure if this is nessicary...
	public void addListing(Listing listing) {
		this.listings.add(listing);
		listing.setId(listings.size());
		this.writeListings();
	}
	
	public void writeListings(){
		
		listingsstorer.writeListing(this.listings);
	}
	
	public void readListings(){
		
		this.listings = listingsstorer.readListings();
	}
	
	
//count here is used to ensure that 5 listings are displayed a page.
// Will hopefully continue through a steady line of all available listings
// try-catch will break out of display when at the end of the list
	
	// This displays the entire arrayList of Listings
	public void display() {
		do{
			try {
				Listing listing = listings.get(count);
				count++;
				if(listing.isAvaliable()) {
				System.out.println("--------------- Listing " + (listing.getId()) + " ------------------");	
				if((listing.getAmmenitiesArrayList() != null) && (listing.getAmmenitiesSize() != 0)) {
					System.out.println(listing.toString());
					System.out.println(listing.returnAmenities());
					
				} else {
				
				System.out.println(listing.toString());
					}	
				
			} } catch(IndexOutOfBoundsException e){
				return;
			}
		}while(count % 25  != 0);
		
		
		
	}
	
	public Listing getListing(int id) {
		for(Listing listing : listings) {
			
			if(listing.getId() == id) {
				return listing;
			}
		}
		
		return null;
	}
	
	// This displays an arrayList entered in, used more often than alone display
	public void display(ArrayList<Listing> listings) {
		if(listings == null) {
			return;
			}
		if(listings.size() == 0) {
			System.out.println("No results found.");
		}
		System.out.println("Results:");
		for(Listing listing : listings) {
			System.out.println("--------------- Listing " + (listing.getId()) + " ------------------");	
			// returns list of ammenities if ammenities is not empty
			if((listing.getAmmenitiesArrayList() != null) && (listing.getAmmenitiesSize() != 0)) {
				System.out.println(listing.toString());
				System.out.println(listing.returnAmenities());
				
			} else {
			System.out.println(listing.toString());
			}
		}
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

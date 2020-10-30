import java.util.ArrayList;

import jdk.nashorn.internal.parser.JSONParser;

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
		this.listings = new ArrayList<Listing>();
		
	}
	
	//**ADD TO UML**

	//As of now, used for adding default listings.
	//Likely will be used for the other accounts as well.
	public void addListing(double price, String address, int capacity, int bedrooms, int baths, double distance, String housingType, boolean avaliable, String description) {
		Listing listing1 = new Listing(price, address, capacity,  bedrooms, baths, distance, housingType, avaliable, description);
		listings.add(listing1);
		listing1.setId(listings.size()-1);
		//TODO code here to add to JSON file
	}
	
	
		public Listing readListing() {

			try {
				Listing listing = JSONParser.parse(new FileReader("json/listing.json"));
				JSONObject listing = (JSONObject)o;

				listing.price = (Integer) listing.get("price");
				listing.address = (String) listing.get("address");
				listing.capacity = (Integer) listing.get("capacity");
				listing.id = (Integer) listing.get("id");
				listing.distance = (Integer) listing.get("distance");
				listing.housingType = (String) listing.get("housing type");
				listing.availible = (String) listing.get("availible");
				listing.description = (String) listing.get("description");
				
				
			//	Iterator iterator = review.iterator();
			//	while (iterator.hasNext()) {
			//		System.out.println(iterator.next());
		//	}
		
	} catch (Exception e) {
		System.out.println("Somethin went wrong boss");
	}
	
}
//count here is used to ensure that 5 listings are displayed a page.
// Will hopefully continue through a steady line of all available listings
// try-catch will break out of display when at the end of the list
	public void display() {
		do{
			try {
				Listing listing = listings.get(count);
				if(listing.isAvaliable()) {
				System.out.println("--------------- Listing " + (listing.getId() + 1) + " ------------------");	
				System.out.println(listing.toString());
					}	
				count++;
			} catch(IndexOutOfBoundsException e){
				return;
			}
		}while(count % 5  != 0);
		
		
		
	}
	
	// Potentially another display to display a custom amount 
	public void display(ArrayList<Listing> listings) {
		if(listings == null) {
			return;
			}
		if(listings.size() == 0) {
			System.out.println("No results found.");
		}
		for(Listing listing : listings) {
			System.out.println("Results:");
			System.out.println("--------------- Listing " + (listing.getId() + 1) + " ------------------");	
			System.out.println(listing.toString());
		}
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

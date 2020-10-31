import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;


//import jdk.nashorn.internal.parser.JSONParser;

import org.json.*;

public class ListingBrowser {

	public ArrayList<Listing> listings; 
	public static ListingBrowser listingbrowser;
	private ListingStorer listingsstorer;
	private int count;
	
	public static ListingBrowser getInstance() {
		if(listingbrowser == null) {
			return new ListingBrowser();
		}
		listingbrowser.setListings();
		return listingbrowser;
	}

	
	private void setListings() {
		this.listings = this.readListings();
		
	}


	private ListingBrowser() {
		this.count = 0;
		this.listings = this.readListings();
	}
	
	//**ADD TO UML**

	//As of now, used for adding default listings.
	//Likely will be used for the other accounts as well.
	public void addListing(double price, String address, int capacity, int bedrooms, int baths, double distance, String housingType, boolean avaliable, String description) {
		Listing listing1 = new Listing(price, address, capacity,  bedrooms, baths, distance, housingType, avaliable, description);
		listings.add(listing1);
		listing1.setId(listings.size());
		//TODO code here to write to JSON file.
	}
	
	public void addListing(Listing listing) {
		listings.add(listing);
		// to be used by json reader.
		
	}
	
	
	
	public ArrayList<Listing> readListings() {
		
		ArrayList<Listing> returnListings = new ArrayList<Listing>();
			
			try {
				FileReader reader = new FileReader("src/listing.json");
				JSONParser parser = new JSONParser();
				JSONArray jsonlistings = (JSONArray) parser.parse(reader);
				
				for(int i = 0; i < jsonlistings.size(); i++) {
					JSONObject JSONlisting = (JSONObject)jsonlistings.get(i);
					Listing listing = new Listing();
					listing.setPrice((int) (long) JSONlisting.get("price"));
					listing.setAddress((String) JSONlisting.get("address"));
					listing.setCapacity((int) (long) JSONlisting.get("capacity"));
					listing.setId((int) (long) JSONlisting.get("id"));
					listing.setDistance((int) (long) JSONlisting.get("distance"));
					listing.setHousingType((String) JSONlisting.get("housing type"));
					listing.setBedrooms((int) (long) JSONlisting.get("bedrooms"));
					listing.setBaths((int) (long) JSONlisting.get("baths"));
					listing.setDescription((String) JSONlisting.get("description"));
					listing.setAvaliability((boolean) JSONlisting.get("available"));
					//	listing.setAmmenities()
					
					returnListings.add(listing);
					}
				
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return returnListings;
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
		}while(count % 5  != 0);
		
		
		
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

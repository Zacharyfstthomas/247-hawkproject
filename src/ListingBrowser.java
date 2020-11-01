
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
	public void addListing(double price, String address, int capacity, int bedrooms, int baths, double distance, String housingType, boolean avaliable, String description) {
		Listing listing1 = new Listing(price, address, capacity,  bedrooms, baths, distance, housingType, avaliable, description);
		listings.add(listing1);
		listing1.setId(listings.size());
		
		
	}
	// not sure if this is nessicary...
	public void addListing(Listing listing) {
		listings.add(listing);
		
	}
	
	public void writeListings(){
		
		listingsstorer.writeListing(this.listings);
	}
	
	public void readListings(){
		
		this.listings = listingsstorer.readListings();
	}
	
	
	/*
	
	private void writeListing() {
		
		JSONArray jsonListings = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< listings.size(); i++) {
			jsonListings.add(getListingJSON(listings.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter("src/listing.json")) {
 
            file.write(jsonListings.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getListingJSON(Listing listing) {
		
		JSONObject listingDetails = new JSONObject();
		listingDetails.put("price", listing.getPrice());
		listingDetails.put("address", listing.getAddress());
		listingDetails.put("capacity", listing.getCapacity());
		listingDetails.put("id", listing.getId());
		listingDetails.put("distance", listing.getDistance());
		listingDetails.put("housingType", listing.getHousingType());
		listingDetails.put("bedrooms", listing.getBedrooms());
		listingDetails.put("baths", listing.getBaths());
		listingDetails.put("description", listing.getDescription());
		listingDetails.put("available", listing.isAvaliable());
		
        return listingDetails;
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
					listing.setPrice((int) (double) JSONlisting.get("price"));
					listing.setAddress((String) JSONlisting.get("address"));
					listing.setCapacity((int) (long) JSONlisting.get("capacity"));
					listing.setId((int) (long) JSONlisting.get("id"));
					listing.setDistance((int) (double) JSONlisting.get("distance"));
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
	
	*/
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

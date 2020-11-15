import org.json.simple.JSONArray;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

/**
 * Stores all the Listings a user has searched for
 * @author hkael
 *
 */
public class ListingStorer {
	

	
	private static final String FILELOCATION = "src/listing.json";
	private static final String PRICE = "price";
	private static final String ADDRESS= "address";
	private static final String CAPACITY = "capacity";
	private static final String ID = "id";
	private static final String DISTANCE = "distance";
	private static final String HOUSINGTYPE = "housingType";
	private static final String BEDROOMS = "bedrooms";
	private static final String BATHS = "baths";
	private static final String DESCRIPTION = "description";
	private static final String AVAILABLE = "available";
	private static final String HASAMMENITIES = "hasAmmenities";
	private static final String AMOUNTAMMENITIES = "amountAmmenities";
	private static final String OWNER = "owner";
	private static final String AMMENITY = "ammenity ";
	
	public static ListingStorer listingstorer;

	/**
	 * Default constructor
	 */
	public ListingStorer() {
		
	}
	
	/**
	 * creates a new JSON array and then gets the size of the array followed by a try catch block for the JSON file
	 * @param listings
	 */
	public static void writeListing(ArrayList<Listing> listings) {
		JSONArray jsonListings = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< listings.size(); i++) {
			jsonListings.add(getListingJSON(listings.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(FILELOCATION)) {
 
            file.write(jsonListings.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * creates a new JSONobject and put all the variables that define a listing into the file
	 * @param listing
	 * @return listingDetails
	 */
	private static JSONObject getListingJSON(Listing listing) {
		
		JSONObject listingDetails = new JSONObject();
		listingDetails.put(PRICE, listing.getPrice());
		listingDetails.put(ADDRESS, listing.getAddress());
		listingDetails.put(CAPACITY, listing.getCapacity());
		listingDetails.put(ID, listing.getId());
		listingDetails.put(DISTANCE, listing.getDistance());
		listingDetails.put(HOUSINGTYPE, listing.getHousingType());
		listingDetails.put(BEDROOMS, listing.getBedrooms());
		listingDetails.put(BATHS, listing.getBaths());
		listingDetails.put(DESCRIPTION, listing.getDescription());
		listingDetails.put(AVAILABLE, listing.isAvaliable());
		listingDetails.put(HASAMMENITIES, listing.hasAmmenities());
		listingDetails.put(AMOUNTAMMENITIES, listing.getAmmenitiesSize());
		listingDetails.put(OWNER, listing.getOwner());
		if(listing.hasAmmenities()) {
			
			ArrayList<String> ammenities = listing.getAmmenitiesArrayList();
			
			for(int i = 0; i < ammenities.size(); i++) {
				listingDetails.put(AMMENITY + i, ammenities.get(i));
			}
		}
		
        return listingDetails;
	}

	/**
	 * Allows the JSON files to be read
	 * @return returnListings
	 */
	public static ArrayList<Listing> readListings() {
		ArrayList<Listing> returnListings = new ArrayList<Listing>();
			
			try {
				FileReader reader = new FileReader(FILELOCATION);
				JSONParser parser = new JSONParser();
				JSONArray jsonlistings = (JSONArray) parser.parse(reader);
				
				for(int i = 0; i < jsonlistings.size(); i++) {
					JSONObject JSONlisting = (JSONObject)jsonlistings.get(i);
					Listing listing = new Listing();
					listing.setPrice((double) JSONlisting.get(PRICE));
					listing.setAddress((String) JSONlisting.get(ADDRESS));
					listing.setCapacity((int) (long) JSONlisting.get(CAPACITY));
					listing.setId((int) (long) JSONlisting.get(ID));
					listing.setDistance((double) JSONlisting.get(DISTANCE));
					listing.setHousingType((String) JSONlisting.get(HOUSINGTYPE));
					listing.setBedrooms((int) (long) JSONlisting.get(BEDROOMS));
					listing.setBaths((int) (long) JSONlisting.get(BATHS));
					listing.setDescription((String) JSONlisting.get(DESCRIPTION));
					listing.setAvaliability((boolean) JSONlisting.get(AVAILABLE));
					listing.setHasAmmenities((boolean) JSONlisting.get(HASAMMENITIES));
					listing.setOwner((String) JSONlisting.get(OWNER));
					int amountAmmenities = ((int)(long) JSONlisting.get(AMOUNTAMMENITIES));
					if(listing.hasAmmenities()) {
						listing.createAmmenitiesArrayList();
						for(int j = 0; j < amountAmmenities; j++) {
							listing.addAmmenity((String) JSONlisting.get(AMMENITY + j));
							
						}
					}
					
					returnListings.add(listing);
					}
				
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return returnListings;
	}



	
	
	
	
}

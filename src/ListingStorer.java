import org.json.simple.JSONArray;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class ListingStorer {
	

	// This ideally is where we'd put the JSON reader/writer?
	public static ListingStorer listingstorer;

	
	public ListingStorer() {
		
	}
	

	public void writeListing(ArrayList<Listing> listings) {
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
	
	private static JSONObject getListingJSON(Listing listing) {
		
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



	
	
	
	
}

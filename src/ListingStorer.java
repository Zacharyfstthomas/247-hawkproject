
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class ListingStorer {

	// This ideally is where we'd put the JSON reader/writer?
	private Listing listing;
	private int id;

	public ListingStorer(Listing listing) {}

	//write new listings to the JSON file
	public static void writeListing() {
		Listing listing = Listing.getInstance();
		ArrayList<Listing> listings = listing.getListing();
		JSONArray jsonListings = new JSONArray();
		
		for(int i=0; i<listings.size(); i++) {
			jsonListings.add(getListingJSON(listings.get(i)));
		}
		
		try(FileWriter file = new FileWriter(fileName****)) {
			file.write(jsonListings.toJSONString());
			file.flush();
		}
		catch(IOException e) {
		e.printStackTrace();
	}
	}
	
	public static JSONObject getListingJSON(Listing listing) {
		JSONObject listingDetails = new JSONObject();
		listingDetails.put("600",listing.getPrice());
		listingDetails.put("122 Street Ln",listing.getAddress());
		listingDetails.put("3",listing.getCapacity());
		listingDetails.put("10",listing.getId());
	}

	//read the listings from the JSON file
	
	public Listing readListing() {
		JSONParser parser = new JSONParser();

		
		try {
			Object o = jsonParser.parse(new FileReader("json/listing.json"));
			JSONObject listing = (JSONObject)o;

			Integer price = (Integer) listing.get("price");
			String address = (String) listing.get("address");
			Integer capacity = (Integer) listing.get("capacity");
			Integer id = (Integer) listing.get("id");
			Integer distance = (Integer) listing.get("distance");
			String housingType = (String) listing.get("housing type");
			String availible = (String) listing.get("availible");
			String description = (String) listing.get("description");
			JSONArray review = (JSONArray) listing.get("review");

			System.out.println("Price: " + price);
			System.out.println("Addresss: " + address);
			System.out.println("Capacity: " + capacity);
			System.out.println("ID: " + id);
			System.out.println("Distance from campus (in miles): " + distance);
			System.out.println("Housing type: " + housingType);
			System.out.println("Availbible: " + availible);
			System.out.println("Description: " + description);
			System.out.println("Reviews: " + review);

			Iterator iterator = review.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
		}
		} catch(Exception e) {
			e.printStackTrace;
		}	
	}
	}
}

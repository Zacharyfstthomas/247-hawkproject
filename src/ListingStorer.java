
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
			FileReader reader = new FileReader("json/listing.json");
			JSONParser parser = new JSONParser();
			JSONArray listingJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < listingJSON.size(); i++) {
				Integer price = (Integer) listingJSON.get("price");
				String address = (String) listingJSON.get("address");
				Integer capacity = (Integer) listingJSON.get("capacity");
				Integer id = (Integer) listingJSON.get("id");
				Integer distance = (Integer) listingJSON.get("distance");
				String housingType = (String) listingJSON.get("housing type");
				String availible = (String) listingJSON.get("availible");
				String description = (String) listingJSON.get("description");
				String review = (String) listingJSON.get("review");
				
				listing.add(new Listing(price, address, capacity, id, distance, housingType, availible, description, review));
			}
			
			return listing;

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
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

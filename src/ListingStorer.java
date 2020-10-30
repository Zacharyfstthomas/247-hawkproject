
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class ListingStorer {

	// This ideally is where we'd put the JSON reader/writer?
	private Listing listing;
	private int id;

	public ListingStorer(Listing listing) {}

	//write new listings to the JSON file
	public void writeListing() {

		
	}

	//read the listings from the JSON file
	
	public Listing readListing() {
		JSONParser parser = new JSONParser();

		try {
			JSONArray listings = jsonParser.parse(new FileReader("json/listing.json"));
			listings.forEach(listing -> {
				JsonObject object = (JsonObject) listing;
				System.out.println(object.get("price"));
				System.out.println(object.get("address"));
				System.out.println(object.get("capacity"));
				System.out.println(object.get("id"));
				System.out.println(object.get("distance"));
				System.out.println(object.get("availible"));
				System.out.println(object.get("description"));
				System.out.println(object.get("review"));
			})
		} catch (Exeception ex) {
			System.out.println(ex);
		}
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

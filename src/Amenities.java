import java.util.ArrayList;

/**
 * Certain characteristic of a listing that a user can input which options they are looking for
 * @author hkael
 *
 */
public class Amenities extends Listing{

	/**
	 * Variables for amenities
	 */
	private Listing listing;
	protected ArrayList<String> amenities;
	private String amenity;
	
	/**
	 * Constructor for Amenities
	 */
	public Amenities() {
		amenities = new ArrayList<String>();
		this.amenity = amenity;
		this.listing = listing;
	}
	
	/**
	 * Adds a certain amenity specified by the user in the ArrayList of amenities
	 * @param amenity
	 */
	public void addAmenity(String amenity) {
		this.amenities.add(amenity);
	}
	
	/**
	 * Gives a String of all the amenities a user is looking for
	 * @return the string of amenities
	 */
	public String returnAmenities() {
		
		String returnstring = "";
		for(String amenity : amenities) {
			
			returnstring += amenity + "\n";
		}
		
		return returnstring;
	}
}
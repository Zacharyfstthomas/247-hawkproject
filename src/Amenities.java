import java.util.ArrayList;
public class Amenities extends Listing{

	private Listing listing;
	protected ArrayList<String> amenities;
	private String amenity;
	
	public Amenities() {
		amenities = new ArrayList<String>();
		this.amenity = amenity;
		this.listing = listing;
	}
	
	public void addAmenity(String amenity) {
		this.amenities.add(amenity);
	}
	
	
	
	public String returnAmenities() {
		
		String returnstring = "";
		for(String amenity : amenities) {
			
			returnstring += amenity + "\n";
		}
		
		return listing.ammenitiesReturn() + returnstring;
	}
}
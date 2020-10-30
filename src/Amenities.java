import java.util.ArrayList;
public abstract class Amenities extends Listing{

	private Listing listing;
	protected ArrayList<String> amenities;
	
	public Amenities(Listing listing) {
		this.amenities = amenities;
	}
	
	public String addAmenities() {
		return amenities.addAmenities();
	}
}

import java.util.*;
public class Listing {
	
	private double price;
	private String address;
	private int capacity; //CAPACITY IS NOT CAPACITY. Now represents 'amount avaliable' (see project website)
	private int id;
	private double distance;
	private String housingType;
	private boolean avaliable;
	private int bedrooms;
	private int baths;
	private String description;
	private ArrayList<String> amenities;
	
		public Listing() {
			// as of now, not to be callled\\ 
			}
	
	
	public Listing(double price, String address, int capacity, int bedrooms, int baths, double distance, String housingType, boolean avaliable, String description) {
			this.price = price;
			this.address = address;
			this.capacity = capacity;
			this.bedrooms = bedrooms;
			this.baths = baths;
			this.distance = distance;
			this.housingType = housingType;
			this.avaliable = avaliable;
			this.description = description;
			this.amenities = new ArrayList<String>();
	}
	
	public void storeListing() {
		
		
	}
	
	public void toggleAvaliability() {
		
		this.avaliable = !(this.avaliable);
		
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setAvaliability(boolean avaliable) {
		
		this.avaliable = avaliable;
	}
	
	public void setAmmenities(double price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<String> getAmmenitiesArrayList() {
		
		return this.amenities;
	}
	
	public int getAmmenitiesSize() {
		
		return this.amenities.size();
	}
	
	public String toString() {
		
		return this.address + "\nAmount Avaliable: " + this.capacity + "\nDistance from Campus: " + this.distance + "\nHousing Type: " + this.housingType + "\nBedrooms: "+ this.bedrooms + "\nBaths: " + this.baths + "\nDescription: " + this.description + "\nPrice: " + this.price;
	}
	
	
	
	public void addAmmenity(String amenity){
		if(this.amenities == null) {
			this.amenities = new ArrayList<String>();
			this.amenities.add(amenity);
		} else {
			this.amenities.add(amenity);
		}
	}
	public String returnAmenities() {
		
		String returnstring = "";
		for(String amenity : amenities) {
			
			returnstring += amenity + "\n";
		}
		
		return "Ammenities: \n" + returnstring;
	}
	
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getHousingType() {
		return housingType;
	}

	public void setHousingType(String housingType) {
		this.housingType = housingType;
	}

	public boolean isAvaliable() {
		return avaliable;
	}

	public int getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}

	public int getBaths() {
		return baths;
	}

	public void setBaths(int baths) {
		this.baths = baths;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public boolean foundAmmenityMatch(String ammenity) {
		for(String amenity: this.amenities) {
			if(amenity.equalsIgnoreCase(ammenity)) {
				return true;
			}
			
		}
		
		
		
		return false;
	}


	public boolean hasAmmenities() {
		if(this.amenities == null) {
			return false;
	}
		return true;
	}

	
	
}

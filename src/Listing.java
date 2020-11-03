import java.util.*;

/**
 * Details of a property that can be rented
 * @author hkael
 *
 */
public class Listing {
	
	/**
	 * Variables of Listing
	 */
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
	private String owner;
	private ArrayList<String> amenities;
	private int amountAmmenities;
	
	/**
	 * Default constructor for Listing
	 */
	public Listing() {
		// as of now, not to be called\\ 
	}
	
	/**
	 * Constructor for Listing
	 * @param price
	 * @param address
	 * @param capacity
	 * @param bedrooms
	 * @param baths
	 * @param distance
	 * @param housingType
	 * @param avaliable
	 * @param description
	 * @param owner
	 */
	public Listing(double price, String address, int capacity, int bedrooms, int baths, double distance, String housingType, boolean avaliable, String description, String owner) {
			this.price = price;
			this.address = address;
			this.capacity = capacity;
			this.bedrooms = bedrooms;
			this.baths = baths;
			this.distance = distance;
			this.housingType = housingType;
			this.avaliable = avaliable;
			this.description = description;
			this.owner = owner;
	}
	
	/**
	 * Mutator for the owner of a property and sets owner equal to owner
	 * @param owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	/**
	 * Accessor for Owner
	 * @return Owner
	 */
	public String getOwner() {
		return this.owner;
	}
	
	/**
	 * Creates a new ArrayList of strings for amenities
	 */
	public void createAmmenitiesArrayList() {
		this.amenities = new ArrayList<String>();		
	}
	
	/**
	 * Checks to see if a property is avaliable
	 */
	public void toggleAvaliability() {
		
		this.avaliable = !(this.avaliable);
		
	}

	/**
	 * Accessor for price of a property
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Mutator for price and sets price equal to price
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Mutator for if a property is available and sets avaliable equal to avaliable
	 * @param avaliable
	 */
	public void setAvaliability(boolean avaliable) {
		
		this.avaliable = avaliable;
	}
	
	//public void setAmmenities() {
	//	this.price = price;
	//}

	/**
	 * Accessor to the address of a property
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Mutator of a properties address and sets address equal to address
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Accessor for the capacity of a property
	 * @return capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Mutator for capacity and sets capacity equal to capacity
	 * @param capacity
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Accessor for Id
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Mutator for Id and sets equal id to id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Accessor for the array list of ammenities
	 * @return amenities
	 */
	public ArrayList<String> getAmmenitiesArrayList() {
		
		return this.amenities;
	}
	
	/**
	 * gets the size of the array list
	 * @return if the array list is empty return 0 if not returns the size
	 */
	public int getAmmenitiesSize() {
		
		if(this.amenities == null) {
			return 0;
		}
		
		return this.amenities.size();
	}
	
	/**
	 * String of all the details of a Listing
	 * @return the String
	 */
	public String toString() {
		
		return this.address + "\nAmount Avaliable: " + this.capacity + "\nDistance from Campus: " + this.distance + "\nHousing Type: " + this.housingType + "\nBedrooms: "+ this.bedrooms + "\nBaths: " + this.baths + "\nDescription: " + this.description + "\nPrice: " + this.price + "\nOwner: " + this.owner;
	}
	
	/**
	 * Adds an amenity to the Array List amenities
	 * @param amenity
	 */
	public void addAmmenity(String amenity){
		if(this.amenities == null) {
			this.amenities = new ArrayList<String>();
			this.amenities.add(amenity);
		} else {
			this.amenities.add(amenity);
		}
	}
	
	/**
	 * Gives a String of all the amenities a user is looking for
	 * @return String of all amenities
	 */
	public String returnAmenities() {
		
		String returnstring = "";
		for(String amenity : amenities) {
			
			returnstring += amenity + "\n";
		}
		
		return "Ammenities: \n" + returnstring;
	}
	
	/**
	 * Accessor for how far the property is from campus
	 * @return distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * Mutator for distance and sets distance equal to distance
	 * @param distance
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

	/**
	 * Accessor for the Type of property
	 * @return housingType
	 */
	public String getHousingType() {
		return housingType;
	}

	/**
	 * Mutator for housingType
	 * @param housingType
	 */
	public void setHousingType(String housingType) {
		this.housingType = housingType;
	}

	/**
	 * checks to see if a property is avaliable
	 * @return avaliable
	 */
	public boolean isAvaliable() {
		return avaliable;
	}

	/**
	 * Accessor for how many bedrooms a property has
	 * @return bedrooms
	 */
	public int getBedrooms() {
		return bedrooms;
	}

	/**
	 * Mutator for bedrooms
	 * @param bedrooms
	 */
	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}

	/**
	 * Accessor for how many bathrooms a property has
	 * @return baths
	 */
	public int getBaths() {
		return baths;
	}

	/**
	 * Mutator for baths
	 * @param baths
	 */
	public void setBaths(int baths) {
		this.baths = baths;
	}

	/**
	 * Accessor for the description of the property
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Mutator for description
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Checks to see if the amenity searched for is found
	 * @param ammenity
	 * @return true if it is otherwise return false
	 */
	public boolean foundAmmenityMatch(String ammenity) {
		for(String amenity: this.amenities) {
			if(amenity.equalsIgnoreCase(ammenity)) {
				return true;
			}
			
		}
		
		
		
		return false;
	}

	/**
	 * Checks property for amenities
	 * @return false if it does not have amenities otherwise true
	 */
	public boolean hasAmmenities() {
		if(this.amenities == null) {
			return false;
	}
		return true;
	}


	/**
	 * Creates a new array list
	 * @param hasAmmenities
	 */
	public void setHasAmmenities(boolean hasAmmenities) {
		if(hasAmmenities) {
			this.amenities = new ArrayList<String>();
		}
		
		
	}


	
	
}

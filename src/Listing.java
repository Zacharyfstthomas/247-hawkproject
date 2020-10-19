
public class Listing {
	
	private double price;
	private String address;
	private int capacity;
	private int id;
	private double distance;
	private String housingType;
	private boolean avaliable;
	private String description;
	private Review review;
	
	public Listing(double price, String address, int capactiy, double distance, String housingType, boolean avaliable, String description) {
		
			this.price = price;
			this.address = address;
			this.capacity = capacity;
			this.id = id;
			this.distance = distance;
			this.housingType = housingType;
			this.avaliable = avaliable;
			this.description = description;
			this.review = review;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}
	
	
	
}

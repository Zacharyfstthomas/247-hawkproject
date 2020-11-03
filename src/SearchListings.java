import java.util.Scanner;
import java.util.ArrayList;


public class SearchListings extends Search{

	
	protected ArrayList<Listing> listings; 
	
	//Search so far takes in a criteria which identifies whether its price, address, or whatever it may be
	// Then branches and takes in a double, int or string, depending on what was enterd
	public ArrayList<Listing> getCriteria(ArrayList<Listing> listings) {
		
		this.listings = listings;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your criteria of search:");
		String criteria = input.nextLine(); 
		
		if(criteria.equalsIgnoreCase("price") || criteria.equalsIgnoreCase("distance")) {
			System.out.println("Enter the value to search for:");
			double doubValue = input.nextDouble(); 
			return this.findDoubMatches(criteria, doubValue);
		}
		 
		if(criteria.equalsIgnoreCase("address") || criteria.equalsIgnoreCase("description") || criteria.equalsIgnoreCase("housing type") || criteria.equalsIgnoreCase("housing") || criteria.equalsIgnoreCase("housingtype") ) {
			System.out.println("Enter the value to search for:");
			String strnValue = input.next(); 
			return this.findStrnMatches(criteria, strnValue);
		}
		
		if(criteria.equalsIgnoreCase("bedrooms") || criteria.equalsIgnoreCase("baths") || criteria.equalsIgnoreCase("amountavaliable") || criteria.equalsIgnoreCase("amount avaliable") || criteria.equalsIgnoreCase("id")) {
			System.out.println("Enter the value to search for:");
			int intValue = input.nextInt(); 
			return this.findIntMatches(criteria, intValue);
			
		}
		
		System.out.println("Invalid criteria selection, will ignore");
		return null;
	}

	
	// Lines below could be replaced by iterator design pattern
	public ArrayList<Listing> findIntMatches(String criteria, int value){
		ArrayList<Listing> returnArrList = new ArrayList<Listing>();
		for(Listing listing : this.listings) {
			if(criteria.equals("id")) {
				if(listing.getId() == value) {
					returnArrList.add(listing);
				}
				
			} else if(criteria.equals("bedrooms")) {
				if(listing.getBedrooms() == value) {
					returnArrList.add(listing);
				}
			} else if(criteria.equals("baths")) {
				if(listing.getBaths() == value) {
					returnArrList.add(listing);
				}
			}			
			
			else{
				if(listing.getCapacity() == value) {
					returnArrList.add(listing);
				}
			}
			
			
		}
		return returnArrList;
	}
	
	public ArrayList<Listing> findDoubMatches(String criteria, double value){
		ArrayList<Listing> returnArrList = new ArrayList<Listing>();
		for(Listing listing : this.listings) {
			if(criteria.equals("price")) {
				if(listing.getPrice() == value) {
					returnArrList.add(listing);
				}
				
			} else {
				if(listing.getDistance() == value) {
					returnArrList.add(listing);
				}
			}
			
		}
		return returnArrList;
	}
	
	public ArrayList<Listing> findStrnMatches(String criteria, String value){
		ArrayList<Listing> returnArrList = new ArrayList<Listing>();
		for(Listing listing : this.listings) {
			if(criteria.equals("address")) {
				if(listing.getAddress().equals(value)) {
					returnArrList.add(listing);
				}
				
			} else if(criteria.equals("description")){
				if(listing.getDescription().equals(value)) {
					returnArrList.add(listing);
				}
			} else {
				if(listing.getHousingType().equals(value)) {
					returnArrList.add(listing);
				}				
			}
			
		}
		return returnArrList;
	}
	
	public ArrayList<Listing> findAmmenitiesMatches(String ammenity, ArrayList<Listing> listings){
		ArrayList<Listing> returnArrList = new ArrayList<Listing>();
		for(Listing listing : listings) {
			if(listing.hasAmmenities()) {
				if(listing.foundAmmenityMatch(ammenity)) {
					returnArrList.add(listing);
					}
			}
			
		}
		return returnArrList;
	}
	
}

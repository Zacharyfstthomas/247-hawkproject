import java.util.Scanner;
import java.util.ArrayList;


public class SearchListings extends Search{

	
	protected ArrayList<Listing> listings; 
	
	//Search so far takes in a criteria which identifies whether its price, address, or whatever it may be
	// Then branches and takes in a double, int or string, depending on what was entered

	
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
			}  else if(criteria.contentEquals("owner")) {
				if(listing.getOwner().equals(value)) {
					returnArrList.add(listing);
				}
			}else {
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

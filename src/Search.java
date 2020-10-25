import java.util.Scanner;
import java.util.ArrayList;
public class Search <T> {

	
	public void showPage() {};
	
	public void getCriteria() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your criteria of search:");
		String criteria = input.nextLine(); 
		
		if(criteria.equalsIgnoreCase("price") || criteria.equalsIgnoreCase("distance")) {
			System.out.println("Enter the value to search for:");
			double doubValue = input.nextDouble(); 
			this.findDoubMatches(criteria, doubValue);
		}
		
		if(criteria.equalsIgnoreCase("address") || criteria.equalsIgnoreCase("housingType") || criteria.equalsIgnoreCase("description")) {
			System.out.println("Enter the value to search for:");
			String strnValue = input.next(); 
			this.findStrnMatches(criteria, strnValue);
		}
		
		if(criteria.equalsIgnoreCase("capacity") || criteria.equalsIgnoreCase("id")) {
			System.out.println("Enter the value to search for:");
			int intValue = input.nextInt(); 
			this.findIntMatches(criteria, intValue);
			
		}
		
	}

	
	
	public ArrayList<Listing> findIntMatches(String criteria, int value){
		
		return null;
	}
	
	public ArrayList<Listing> findDoubMatches(String criteria, double value){
		
		return null;
	}
	
	public ArrayList<Listing> findStrnMatches(String criteria, String value){
		
		return null;
	}
}

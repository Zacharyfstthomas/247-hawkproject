import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.BeforeEach.*;
import static org.junit.jupiter.api.AfterEach.*;
import static org.junit.jupiter.api.Test.*;

import java.util.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SearchListingsTest {

	
	private ListingBrowser listingbrowser = ListingBrowser.getInstance();
	private SearchListings search = new SearchListings();
	
	@BeforeEach
	public void setup() {
		listingbrowser.listings = ListingStorer.readListings();
		listingbrowser.listings.clear();
		
		//                       price address         cap bed bath dist  houseType avail    descr   owner
		listingbrowser.addListing(640, "560 Bull Street", 2, 2, 2, 3.1, "Apartment", true, "Comfy!", "PropertyMan");
		listingbrowser.addListing(750, "7686 Gervais Ave", 5, 1, 1, 1.6, "House", true, "Cozy!", "PropertyMan");
		listingbrowser.addListing(640, "812 Spencer Place", 2, 6, 4, 3.1, "Apartment", true, "Spooky!", "PropertyMan");
		listingbrowser.addListing(750, "690 Main Street", 5, 4, 1, 1.6, "Complex", true, "Quirky!", "PropertyMan");
		listingbrowser.addListing(450, "812 Spencer Place", 4, 4, 3, 7.5, "Apartment", true, "Popping!", "SickLandLord");
		listingbrowser.addListing(789, "299 Blossom Drive", 5, 2, 1, 1.6, "House", true, "Cozy!", "SickLandLord");
		listingbrowser.listings.get(0).addAmmenity("pool");
		listingbrowser.listings.get(1).addAmmenity("pool");
		listingbrowser.listings.get(0).addAmmenity("gym");
		
		ListingStorer.writeListing(listingbrowser.listings);
		search.listings = listingbrowser.listings;
	}
	
	
	@AfterEach
	public void tearDown() {
		
		listingbrowser.listings.clear();
		ListingStorer.writeListing(listingbrowser.listings);
		
	}
	
	@Test
	public void testGetPriceMatches() {
		
		ArrayList<Listing> results = search.findDoubMatches("price", 750);
		
		assertTrue(results.get(0).equals(listingbrowser.listings.get(1)) && results.get(1).equals(listingbrowser.listings.get(3)));
	}
	
	@Test
public void testPriceMatchesMatch() {
		
		ArrayList<Listing> results = search.findDoubMatches("price", 750);
		
		assertTrue(results.get(0).getPrice() == results.get(1).getPrice());
	}
	
	
	@Test
	public void testGetAddressMatches() {
		
		ArrayList<Listing> results = search.findStrnMatches("address", "812 Spencer Place");
		
		assertTrue(results.get(0).equals(listingbrowser.listings.get(2)) && results.get(1).equals(listingbrowser.listings.get(4)));
	}
	
	@Test
public void testAddressMatchesMatch() {
		
		ArrayList<Listing> results = search.findStrnMatches("address", "812 Spencer Place");
		
		assertTrue(results.get(0).getAddress().equals(results.get(1).getAddress()));
	}
	
	
	@Test
	public void testGetCapacityMatches() {
		
		ArrayList<Listing> results = search.findIntMatches("capacity", 2);
		
		assertTrue(results.get(0).equals(listingbrowser.listings.get(0)) && results.get(1).equals(listingbrowser.listings.get(2)));
	}
	
	@Test
public void testCapacityMatchesMatch() {
		
		ArrayList<Listing> results = search.findIntMatches("capacity", 2);
		
		assertTrue(results.get(0).getCapacity() == results.get(1).getCapacity());
	}
	
	@Test
	public void testGetIDMatches() {
		
		ArrayList<Listing> results = search.findIntMatches("id", 2);
		
		assertTrue(results.get(0).equals(listingbrowser.listings.get(1)));
	}
	
	@Test
	public void testIDMatchesMatch() {
		
		ArrayList<Listing> results = search.findIntMatches("id", 2);
		
		assertTrue(results.get(0).getId() == 2);
	}
	
	@Test
	public void testGetBedroomMatches() {
		
		ArrayList<Listing> results = search.findIntMatches("bedrooms", 2);
		
		assertTrue(results.get(0).equals(listingbrowser.listings.get(0)) && results.get(1).equals(listingbrowser.listings.get(5)));
	}
	
	@Test
	public void testBedroomMatchesMatch() {
		
		ArrayList<Listing> results = search.findIntMatches("bedrooms", 2);
		
		assertTrue(results.get(0).getBedrooms() == results.get(1).getBedrooms());
	}
	
	@Test
	public void testGetBathMatches() {
		ArrayList<Listing> results = search.findIntMatches("baths", 1);
		
		assertTrue(results.get(0).equals(listingbrowser.listings.get(1)) && results.get(1).equals(listingbrowser.listings.get(3)));
	
	}
	
	@Test
	public void testBathMatchesMatch() {
		
		ArrayList<Listing> results = search.findIntMatches("baths", 1);
		
		assertTrue(results.get(0).getBaths() == results.get(1).getBaths());
	}
	
	
	

	@Test
	public void testGetDistanceMatches() {
		ArrayList<Listing> results = search.findDoubMatches("distance", 1.6);
		
		assertTrue(results.get(0).equals(listingbrowser.listings.get(1)) && results.get(1).equals(listingbrowser.listings.get(3)) && results.get(2).equals(listingbrowser.listings.get(5)) );
	
	}
	
	@Test
	public void testDistanceMatchesMatch() {
			
		ArrayList<Listing> results = search.findDoubMatches("distance", 1.6);
		
		assertTrue(results.get(0).getDistance() == results.get(1).getDistance() && results.get(2).getDistance() == results.get(1).getDistance() && results.get(0).getDistance() == results.get(2).getDistance());
		}
	
	@Test
	public void testGetHousingTypeMatches() {
		
		ArrayList<Listing> results = search.findStrnMatches("housingType", "House");
		
		assertTrue(results.get(0).equals(listingbrowser.listings.get(1)) && results.get(1).equals(listingbrowser.listings.get(5)));
	
		
	}
	
	@Test
	public void testHousingTypeMatchesMatch() {
			
		ArrayList<Listing> results = search.findStrnMatches("housingType", "House");
			
		assertTrue(results.get(0).getHousingType() == results.get(1).getHousingType());
		}
	
	
	@Test
	public void testGetDescriptionMatches() {
		ArrayList<Listing> results = search.findStrnMatches("description", "Cozy!");
		
		assertTrue(results.get(0).equals(listingbrowser.listings.get(1)) && results.get(1).equals(listingbrowser.listings.get(5)));
		
	}
	
	@Test
	public void testDescriptonMatchesMatch() {
		
		ArrayList<Listing> results = search.findStrnMatches("description", "Cozy!");
		
		assertTrue(results.get(0).getDescription().equals(results.get(1).getDescription()));
	}
	
	@Test
	public void testGetOwnerMatches() {
		
		ArrayList<Listing> results = search.findStrnMatches("owner", "SickLandLord");
		
		assertTrue(results.get(0).equals(listingbrowser.listings.get(4)) && results.get(1).equals(listingbrowser.listings.get(5)));
	}
	
	
	@Test
	public void testOwnerMatchesMatch() {
		
		ArrayList<Listing> results = search.findStrnMatches("owner", "SickLandLord");
		
		assertTrue(results.get(0).getOwner().equals(results.get(1).getOwner()));
	}

	
	@Test
	
	public void testGetAmmenitiesMatch() {
		
		ArrayList<Listing> results = search.findAmmenitiesMatches("pool", listingbrowser.listings);
				
				assertTrue(results.get(0).equals(listingbrowser.listings.get(0)) && results.get(1).equals(listingbrowser.listings.get(1)));
		
	}
	
	@Test
	public void testAmmenitiesMatchesMatch() {
		
		ArrayList<Listing> results = search.findAmmenitiesMatches("pool", listingbrowser.listings);
		
		assertTrue(results.get(0).getAmmenitiesArrayList().get(0).equals(results.get(1).getAmmenitiesArrayList().get(0)));
	}
	
}

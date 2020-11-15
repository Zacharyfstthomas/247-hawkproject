import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.BeforeEach.*;
import static org.junit.jupiter.api.AfterEach.*;
import static org.junit.jupiter.api.Test.*;

import java.util.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ListingStorerTest {
	
	private ListingBrowser listingbrowser = ListingBrowser.getInstance();
	private ArrayList<Listing> listings = ListingStorer.readListings();
		
	@BeforeEach
	public void setup() {
		listingbrowser.listings = listings;
		listingbrowser.listings.clear();
		listingbrowser.addListing(640, "560 Bull Street", 2, 2, 2, 3.1, "Apartment", true, "Comfy!", "PropertyMan");
		listingbrowser.addListing(750, "7686 Gervais Ave", 5, 2, 1, 1.6, "House", true, "Cozy!", "PropertyMan");
		listingbrowser.writeListings(); // calls ListingStorer's writeListings
	}
	
	@AfterEach
	public void tearDown(){
		listingbrowser.listings.clear();
		ListingStorer.writeListing(listingbrowser.listings);//  calls ListingStorer's writeListings
		
	}
	
	@Test
	public void testGetListingsSize() {
	
		
	
		assertEquals(2,listingbrowser.listings.size());
	
	}
	
	@Test
	public void testGetListingsSizeZero() {
		
		

		listingbrowser.listings.clear();
		assertEquals(0, listingbrowser.listings.size());
		

	}
	
	@Test
	public void testAddAmmenitiesToListing() {
		
		
		listingbrowser.getListing(1).addAmmenity("pool");
		assertEquals("pool",listingbrowser.getListing(1).getAmmenitiesArrayList().get(0));
		
	
		
	}
	@Test
	public void testWriteAmmenitiesToFile() {
		listingbrowser.getListing(1).addAmmenity("pool");
		listingbrowser.getListing(1).addAmmenity("car");
		ListingStorer.writeListing(listingbrowser.listings);
		ListingStorer.readListings();
		assertEquals("pool",listingbrowser.getListing(1).getAmmenitiesArrayList().get(0));
		
	}
	
	
}

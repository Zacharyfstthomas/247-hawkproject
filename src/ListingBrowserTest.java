import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ListingBrowserTest {
	public ArrayList<Listing> listings; 
	public static ListingBrowser listingbrowser;
	private ListingStorer listingsstorer;
	private int count;
/*
 * tests for getInstance
 */
	@Test
	public void testEmptyListingBrowser_CreatesNewListingBrowser(ListingBrowser listingbrowser) {
		assertNull("should be null & new listing browser" , new ListingBrowser());
	}
	
	@Test
	public void testOccupiedListingBrowser_ReturnsListingBrowser(ListingBrowser listingbrowser) {
		assertNotNull("should not be null & return listing browser" , listingbrowser);
	} 
/*
 * tests for ListingBrowser
 */
	@Test
	public void testIfBrowser() {
		testAcc = new Listing(17 , 6);
		assertEquals("success - new listing arraylist" , listingstorer);
	}
/*
 * tests for addListing
 * MISSING ID!!
 */
	@Test
	public void testCreateValidListing() {
		listing.add(500.00 , "576 Greene St" , 2 , 4 , 3 , 5.2 , "apartment" , "yes availible" , "beautiful upper apartment close to campus" , "Jacob Brown");
		listing = new Listing();
		assertEquals("success - 576 Greene St listing created" , );
	}
	
/*
 * tests for writeListings and readListings
 */
	
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	
	@Test
	public void testWriteAndReadListings() {
		File file = folder.newFile("testListingFile.txt");
		FileUtils.writeStringToFile(testListingFile, "111 Tree Ln ID 7 - new listing");
		final String str = FileUtils.readFileToString(testListingFile);
		assertEquals("111 Tree Ln ID 7 - new listing" , str);
	

/*
 * tests for getListing
 */
	@Test
	public void testIdIsValid_ReturnListing() {
		int id = 5;
		assertEquals("success - listing id 5 exists" , 5, listing.getListingId());
	}
	
	@Test
	public void testIdIsInvalid_ReturnNull() {
		int id = 10;
		assertEquals("success - listing id 10 doesn't exist, returns null" , null,  listing.getListingId());
	}
/*
 * tests for display(2)
 */
	@Test
	public void testArrayListAddition() {
		assertArrayEquals(intsPreviousSize + 1, ints.size());
	}
	

/*
 * tests for pageBackward
 */
	@Test
	public void testPageGoesBackwards(int count) {
		int count = 10;
		assertEquals("success count++" , 5, count++);
	}
	
	@Test
	public void testPageStays(int count) {
		int count = 7;
		assertEquals("success count now = 2", 2, count);
	}
}

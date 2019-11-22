package tests;
import org.testng.annotations.Test;

import pageObjects.HotelBookingPage;
import utilities.DriverUtilities;

public class HotelBookingTest extends MasterTest {

	@Test (description = "Validate that the user is able to search for hotels")
	public void shouldBeAbleToSearchForHotels() {

		HotelBookingPage hotelBookingPage = null;
		String url = "https://www.cleartrip.com/";
		
		DriverUtilities.openUrl(driver, url);
		hotelBookingPage = new HotelBookingPage(driver);
		hotelBookingPage.clickOnHotelLink();
		hotelBookingPage.enterLocality("Indiranagar, Bangalore");
		hotelBookingPage.selectTravellerSelectionDropdown("1 room, 2 adults");
		hotelBookingPage.clickOnSearchButton();
	}
}

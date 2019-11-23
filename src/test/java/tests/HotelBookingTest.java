package tests;
import org.testng.annotations.Test;

import pageObjects.HotelBookingPage;

public class HotelBookingTest extends MasterTest {

	@Test (description = "Validate that the user is able to search for hotels")
	public void shouldBeAbleToSearchForHotels() {

		HotelBookingPage hotelBookingPage = null;
		hotelBookingPage = new HotelBookingPage(driver);
		hotelBookingPage.clickOnHotelLink();
		hotelBookingPage.enterLocality(inputProperties.getProperty("locality"));
		hotelBookingPage.selectTravellerSelectionDropdown(inputProperties.getProperty("travellerSelection"));
		hotelBookingPage.clickOnSearchButton();
	}
}

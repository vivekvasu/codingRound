package tests;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.FlightBookingPage;

public class FlightBookingTest extends MasterTest {

	@Test (description = "Validate that the results are appearing for one way journey")
	public void testThatResultsAppearForAOneWayJourney() {

		FlightBookingPage flightBookingPage = null;
		flightBookingPage = new FlightBookingPage(driver);
		flightBookingPage.clickOneWayRadioButton();
		flightBookingPage.enterFromLocation(inputProperties.getProperty("fromLocation"));

		//wait for the auto complete options to appear for the origin
		flightBookingPage.isFromSuggestionBoxLoaded();
		List<WebElement> originOptions = flightBookingPage.getSuggestionListFromOriginDropdown();
		originOptions.get(0).click();
		
		flightBookingPage.enterToLocation(inputProperties.getProperty("toLocation"));
		
		//wait for the auto complete options to appear for the destination
		flightBookingPage.isToSuggestionBoxLoaded();
		//select the first item from the destination auto complete list
		List<WebElement> destinationOptions = flightBookingPage.getSuggestionListfromDestinationDropdown();
		destinationOptions.get(0).click();
		flightBookingPage.clickOnActiveDate();

		//all fields filled in. Now click on search
		flightBookingPage.clickOnSearchButton();

		//verify that result appears for the provided journey search
		Assert.assertTrue(flightBookingPage.isSearchSummaryDisplayed());
	}
}

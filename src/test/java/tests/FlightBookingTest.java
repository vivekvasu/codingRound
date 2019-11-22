package tests;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.FlightBookingPage;
import utilities.DriverUtilities;

public class FlightBookingTest extends MasterTest {

	@Test (description = "Validate that the results are appearing for one way journey")
	public void testThatResultsAppearForAOneWayJourney() {

		String url = "https://www.cleartrip.com/";
		DriverUtilities.openUrl(driver, url);
		FlightBookingPage flightBookingPage = null;
		flightBookingPage = new FlightBookingPage(driver);
		flightBookingPage.clickOneWayRadioButton();
		flightBookingPage.enterFromLocation("Bangalore");

		//wait for the auto complete options to appear for the origin

		DriverUtilities.waitFor(5000);
		List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
		originOptions.get(0).click();
		
		flightBookingPage.enterToLocation("Delhi");
		//wait for the auto complete options to appear for the destination
		DriverUtilities.waitFor(5000);
		//select the first item from the destination auto complete list
		List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
		destinationOptions.get(0).click();

		flightBookingPage.clickOnActiveDate();

		//all fields filled in. Now click on search
		flightBookingPage.clickOnSearchButton();

		//verify that result appears for the provided journey search
		Assert.assertTrue(flightBookingPage.isSearchSummaryDisplayed());
	}
}

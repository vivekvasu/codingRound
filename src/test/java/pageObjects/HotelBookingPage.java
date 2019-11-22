package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.DriverUtilities;
import utilities.Report;

public class HotelBookingPage extends MasterPageObject {

	public HotelBookingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;

	@FindBy(id = "Tags")
	private WebElement localityTextBox;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;
	
	/**
	 * This method is to click on Hotel link
	 * 
	 * @return True if the click is success, else false
	 */
	public boolean clickOnHotelLink()
	{
		Report.info("Entering method::clickOnHotelLink()");
		boolean isClicked = false;
		isClicked = DriverUtilities.clickOnElement(hotelLink);
		Report.info("Exiting method::clickOnHotelLink() with '" + isClicked + '"');
		return isClicked;
	}
	
	/**
	 * This method is to enter the locality
	 * 
	 * @return - the entered text
	 */
	public String enterLocality(String locality)
	{
		Report.info("Entering method::enterLocality()");
		String enteredText = "";
		enteredText = DriverUtilities.enterText(localityTextBox, locality);
		Report.info("Exiting method::clickOnHotelLink() with '" + enteredText + '"');
		return enteredText;
	}
	
	/**
	 * This method is to select the TravellerSelectionDropdown
	 * @param dropdownValue - value to select
	 * @return - True if the selection is success, else false
	 */
	public boolean selectTravellerSelectionDropdown(String dropdownValue)
	{
		Report.info("Entering method::selectTravellerSelectionDropdown()");
		boolean isSuccess = false;
		isSuccess = DriverUtilities.selectDropdown(travellerSelection, dropdownValue);
		Report.info("Exiting method::selectTravellerSelectionDropdown() with '" + isSuccess + '"');
		return false;
	}
	
	/**
	 * This method is to click on search button
	 * 
	 * @return True if the click is success, else false
	 */
	public boolean clickOnSearchButton()
	{
		Report.info("Entering method::clickOnSearchButton()");
		boolean isClicked = false;
		isClicked = DriverUtilities.clickOnElement(searchButton);
		Report.info("Exiting method::clickOnSearchButton() with '" + isClicked + '"');
		return isClicked;
	}
}

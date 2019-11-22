package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MasterPageObject {

	public WebDriver driver;

	public MasterPageObject(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}

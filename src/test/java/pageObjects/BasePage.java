package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver;

	BasePage(WebDriver driver) {
		this.driver = driver; // this.driver is instance variable we can't access it
		PageFactory.initElements(driver, this); // This is mandatory field when we are using Page factory approach
	}
}

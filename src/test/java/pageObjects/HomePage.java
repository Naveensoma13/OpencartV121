package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Locators

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement MyAccountLink;

	@FindBy(xpath = "//a[normalize-space()=\"Register\"]")
	WebElement RegisterLink;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement LoginLink;
	
	
	// Action Method

	public void MyAccount() {
		MyAccountLink.click();
	}

	public void RegisterP() {
		RegisterLink.click();
	}
	
	public void LoginP()
	{
		LoginLink.click();
	}

}

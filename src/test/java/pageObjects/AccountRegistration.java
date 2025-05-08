package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends BasePage {

	// Constructors

	public AccountRegistration(WebDriver driver) {
		super(driver);
	}

	// Locators

	@FindBy(xpath = "//input[@id=\"input-firstname\"]")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtInPassword;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chPolicyCheck;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmMessage;

//Action method for each locators
	
	public void setFirstName(String name)
	{
		txtFirstName.sendKeys(name);
	}
	
	public void setLastName(String Lname)
	{
		txtLastName.sendKeys(Lname);
	}
	
	public void setEmail(String Mail)
	{
		txtEmail.sendKeys(Mail);
	}
	
	public void setTelephone(String Tphone)
	{
		txtTelephone.sendKeys(Tphone);
	}
	
	public void setInputPassword(String SamePassword)
	{
		txtInPassword.sendKeys(SamePassword);
	}
	
	public void setConfirmPassword(String SamePassword)
	{
		txtConfPassword.sendKeys(SamePassword);
	}
	
	public void policyClick()
	{
		chPolicyCheck.click();
	}
	
	public void ButtonClick()
	{
		btContinue.click();
	}
	
	public String MessageInfo()
	{
		try {
			return(msgConfirmMessage.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
}

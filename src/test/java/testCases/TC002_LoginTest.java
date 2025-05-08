package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass {
	//(groups={"Sanity","Master"})
	@Test
	public void verify_login() {
		logger.info("*********Starting TC002_LoginTest************");
		
		
		try 
		{
			// HomePage
			HomePage hp = new HomePage(driver);
			hp.MyAccount();
			hp.LoginP();

			// LoginPage
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("emailid")); // capturing properties file.
			lp.setPassword(p.getProperty("password1"));
			lp.clickLogin();

			// MyAccountPage
			MyAccountPage mp = new MyAccountPage(driver);
			boolean targetPage = mp.isMyAccountPageExists();

			Assert.assertTrue(targetPage); // Assert.assertEquals(targetPage, true, "Login failed");
		}

		catch (Exception e) 
		{
			Assert.fail();		
		}
         logger.info("*********Finished TC002_LoginTest************");
	}

}

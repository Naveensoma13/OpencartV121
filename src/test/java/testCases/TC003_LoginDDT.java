package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="DataDriven") //Getting data provider provided from different class
	public void loginDDT(String email, String pwd, String expVal)
	{
		
		logger.info("**** Stated TC003_LoginDDT ****************");
		
		
		try
		{
		
		
		// HomePage
					HomePage hp = new HomePage(driver);
					hp.MyAccount();
					hp.LoginP();

					// LoginPage
					LoginPage lp = new LoginPage(driver);
					lp.setEmail(email); // capturing properties file.
					lp.setPassword(pwd);
					lp.clickLogin();

					// MyAccountPage
					MyAccountPage mp = new MyAccountPage(driver);
					boolean targetPage = mp.isMyAccountPageExists();
					
					
					//Data is Valid - login success - testpass - logout
					//Data is valid -  login failed- testfail
					
					//Data is invalid - login success -testfailed - logout
					//Data is invalid - login failed - testpass
					
					if(expVal.equalsIgnoreCase("Valid"))
					{
						if(targetPage==true)
						{
							mp.logoutBtn();
							Assert.assertTrue(true);
							
						}
						else
						{
							Assert.assertTrue(false);
						}
					}
					
					if(expVal.equalsIgnoreCase("Invalid"))
					{
						if(targetPage==true)
						{
							mp.logoutBtn();
							Assert.assertTrue(false);
							
						}	
						else
						{
							Assert.assertTrue(true);
						}
					}
					
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
		logger.info("**** Finished TC003_LoginDDT ****************");
		
	}
}

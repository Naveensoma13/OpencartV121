package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import pageObjects.AccountRegistration;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {
//(groups={"Regression","Master"})
	@Test
	public void verify_account_registration() {

		logger.info("******Strating  TC001_AccountRegistrationTest********");

		try {

			HomePage homeP = new HomePage(driver);
			homeP.MyAccount();
			logger.info("****** Clicked on My Account Link ********");

			homeP.RegisterP();
			logger.info("****** Clicked on Register Link ********");

			AccountRegistration ar = new AccountRegistration(driver);

			logger.info("****** Providing Customer Details ********");

			ar.setFirstName(randomString().toUpperCase());
			ar.setLastName(randomString().toUpperCase());
			ar.setEmail(randomString() + "@gmail.com");
			ar.setTelephone(randomNumber());

			String password = randomAlphaNumeric(); // Same random if we put it will generate different rather storing
													// it in vari and using same in generate password
			ar.setInputPassword(password);
			ar.setConfirmPassword(password);
			ar.policyClick();
			ar.ButtonClick();

			logger.info("****** Validating Expected Message ********");

			String confirmText = ar.MessageInfo();

			
			//When we fail the tc with invalid test
//			if (confirmText.equals("Your Account Has Been Created!!!!")) 
//			{
//				Assert.assertTrue(true);
//			}
//
//			else 
//			{
//				logger.error("*****************Test Failed!!***************");
//				logger.debug("Debug logs");
//				Assert.assertTrue(false);
//			}
//			
			Assert.assertEquals(confirmText, "Your Account Has Been Created!");
			// //Failing test

		} catch (Exception e) {

			Assert.fail();
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}

		logger.info("****** Finished  TC001_AccountRegistrationTest   ********");

	}

}

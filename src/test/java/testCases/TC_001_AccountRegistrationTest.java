package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("***** Satrting TC_001_AccountRegistrationTest *****");
		logger.debug("This is a Debug log message");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link");
		
		hp.clickRegister();
		logger.info("Clicked on Register link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details");
		regpage.setFirstname(randomString().toUpperCase());
		regpage.setLastname(randomString().toUpperCase());
		regpage.setEmail(randomString().toLowerCase()+"@gmail.com");   //randomly generated the email
		regpage.setTelephone(randomNumber());
		
		String password=randomAlphanumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.clickPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating Expected message");
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		logger.info("Test Passed");
		}
		catch (Exception e)
		{
			logger.error("Test Failed :"+e.getMessage());
			Assert.fail("Test Failed :"+e.getMessage());
		}
		finally
		{
			logger.info("***** Finished TC_001_AccountRegistrationTest *****");
		}  
	
	}

}



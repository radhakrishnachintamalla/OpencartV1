package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	@Test(groups= {"Sanity","Master"})
	public void verify_Login()
	{
		logger.info("****Starting TC_002_LoginTest****");
		logger.debug("capturing application debug logs....");
		
		try
		{
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on myaccount link on the home page..");
		hp.clickLogin();
		logger.info("Clicked on Login link on the home page..");
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		logger.info("Entering valid email and password");
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("Clicked on Login button");
		
		//MyAccountPage
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExist();
		
		Assert.assertEquals(targetPage, true);
		}
		catch (Exception e)
		{
			Assert.fail();
		}
		
		logger.info("****Finished TC_002_LoginTest****");
	}

}

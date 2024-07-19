package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
	@Test(groups= {"Sanity","Master"})
	public void test_Login()
	{
		logger.info("Starting TC_002_LoginTest");
		
		try
		{				
			HomePage hp=new HomePage(driver);
			
			hp.clickLogin();
			Thread.sleep(1000);
			
			LoginPage lp=new LoginPage(driver);
			
			lp.setEmail(rb.getString("email")); // valid email, get it from properties file
			Thread.sleep(1000);
			boolean Emailerror=lp.isEmailErrorExists();
			Assert.assertEquals(Emailerror,false);
			
			lp.setPassword(rb.getString("password")); // valid password, get it from properties file
			Thread.sleep(1000);
			
			lp.clickLogin();
			Thread.sleep(1000);
			boolean Loginerror=lp.isLoginErrorExists();
			Assert.assertEquals(Loginerror,false);
			
			boolean targetpage=hp.isMyAccountExists();
						
			Assert.assertEquals(targetpage, true);
			
		}	
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info(" Finished TC_002_LoginTest");
		
	}
	
	
}




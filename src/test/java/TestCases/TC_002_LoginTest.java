package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MainPage;
import TestBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
	@Test(groups= {"Sanity","Master"})
	public void test_Login()
	{
		log.info("Starting TC_002_LoginTest");
		
		try
		{				
			HomePage hp=new HomePage(driver);
			
			hp.ClickLogin();
			
			LoginPage lp=new LoginPage(driver);
			
			lp.setEmail(rb.getString("email")); // valid email, get it from properties file
			
			lp.setPassword(rb.getString("password")); // valid password, get it from properties file
			
			lp.clickLogin();
			
			MainPage macc=new MainPage(driver);
			
			boolean targetpage=macc.isMyAccountPageExists();
						
			Assert.assertEquals(targetpage, true);
			
		}	
		catch(Exception e)
		{
			Assert.fail();
		}
		log.info(" Finished TC_002_LoginTest");
		
	}
	
	
}




package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_007_LogoutTest extends BaseClass
{
	@Test(dependsOnMethods = {"test_Login"})

	public void test_Logout () 
	{
		// TODO Auto-generated method stub
		logger.info("starting TC_007_LogoutTest");
		try
		{
			HomePage hp=new HomePage(driver);
			hp.clickLogin();
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(rb.getString("email"));
			lp.setPassword(rb.getString("password"));
			lp.clickLogin();
			hp.clickLogout();
			Assert.assertEquals(hp.isLogindisplayed(), true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}

	}

}

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.*;
import testBase.BaseClass;

public class TC_008_ForgotPassword extends BaseClass{
	@Test
	public void Test_forgotpassword()
	{
		logger.info("Starting TC_008_ForgorPassword");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickLogin();
		
		LoginPage lp= new LoginPage(driver);
		lp.ClickForgotPassword();
		
		ForgotPasswordPage fp=new ForgotPasswordPage(driver);
		fp.setEmail("sdc@xyz.com");
		fp.ClickRecover();
		Thread.sleep(10000);
		//Assert.assertEquals(fp.isEmailsentDisplayed(),true);
		Assert.assertEquals(fp.isEmailNotFoundDisplayed(), true);
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}

}

 package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.AccountRegistrationPage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass
{
	@Test(groups= {"Regression","Master"})
	public void Test_Register() throws InterruptedException
	{
		logger.debug("Debugging register page");
		logger.info("** starting first log in first test case **");
		try
		{
			logger.info("opening Home page");
		HomePage hp= new HomePage(driver);
		Thread.sleep(1000);
		hp.clickRegister();
		logger.info(" Opening Registration page");
		AccountRegistrationPage regp= new AccountRegistrationPage(driver);
		regp.FemaleGender();
		Thread.sleep(1000);
		regp.setFirstName(RandString().toUpperCase());
		Thread.sleep(1000);
		regp.setLastName(RandString().toUpperCase());
		Thread.sleep(1000);
		regp.DateOfBirth("21", "August", "2000");
		Thread.sleep(1000);
		regp.setEmail(RandString()+"@gamil.com");
		Thread.sleep(1000);
		String Psw=RandAlphaNum();
		Thread.sleep(1000);
		regp.setPassword(Psw);
		Thread.sleep(1000);
		regp.confirmPassword(Psw);
		Thread.sleep(1000);
		regp.clickRegister();
		Thread.sleep(1000);
		String confmsg=regp.getConfirmationMsg();
		Thread.sleep(1000);
		Assert.assertEquals(confmsg, "Your registration completed");
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			Assert.fail();
		}
		logger.info(" registration completed!...");
		AccountRegistrationPage regp= new AccountRegistrationPage(driver);
		String confmsg=regp.getConfirmationMsg();
		if(confmsg.equals("Your registration completed"))
		{
		System.out.println("test Passed");
		}
		else
		{
			System.out.println("test failed");
		}
		
	}
}

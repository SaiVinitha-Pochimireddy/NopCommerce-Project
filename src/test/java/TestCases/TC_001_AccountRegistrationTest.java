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
		hp.clickRegister();
		logger.info(" Opening Registration page");
		AccountRegistrationPage regp= new AccountRegistrationPage(driver);
		regp.FemaleGender();
		regp.setFirstName(RandString().toUpperCase());
		regp.setLastName(RandString().toUpperCase());
		regp.DateOfBirth("21", "August", "2000");
		regp.setEmail(RandString()+"@gamil.com");
		String Psw=RandAlphaNum();
		regp.setPassword(Psw);
		regp.confirmPassword(Psw);
		regp.clickRegister();
		String confmsg=regp.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your registration completed");
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			Assert.fail();
		}
		logger.info(" registration completed!...");
	}
}

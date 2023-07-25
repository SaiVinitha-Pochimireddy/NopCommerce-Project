package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import TestBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass
{
	@Test(groups= {"Regression","Master"})
	public void Test_Register() throws InterruptedException
	{
		log.debug("Debugging register page");
		log.info("** starting first log in first test case **");
		try
		{
		log.info("opening Home page");
		HomePage hp= new HomePage(driver);
		hp.ClickRegister();
		log.info(" Opening Registration page");
		RegistrationPage regp= new RegistrationPage(driver);
		regp.FemaleGender();
		regp.FirstName(RandString().toUpperCase());
		regp.LastName(RandString().toUpperCase());
		regp.DateOfBirth("21", "August", "2000");
		regp.Email(RandString()+"@gamil.com");
		String Psw=RandAlphaNum();
		regp.Password(Psw);
		regp.ConfirmPassword(Psw);
		regp.Register();
		String confmsg=regp.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your registration completed");
		}
		catch(Exception e)
		{
			log.error("Test Failed");
			Assert.fail();
		}
		log.info(" registration completed!...");
	}
}

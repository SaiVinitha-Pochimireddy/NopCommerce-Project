package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MainPage;
import TestBase.BaseClass;
import Utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void test_LoginDDT(String email, String pwd, String exp) {
		log.info(" Starting TC_003_LoginDataDrivenTest ");

		try {
			HomePage hp = new HomePage(driver);
			hp.ClickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			MainPage macc=new MainPage(driver);
			boolean targetpage = macc.isMyAccountPageExists();// this method is created MyAccountPage

			if (exp.equals("Valid")) {
				if (targetpage == true) {
					macc.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equals("Invalid")) {
				if (targetpage == true) {
					MainPage myaccpage = new MainPage(driver);
					myaccpage.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			Assert.fail();
		}

		log.info(" Finished TC_003_LoginDataDrivenTest");

	}

}


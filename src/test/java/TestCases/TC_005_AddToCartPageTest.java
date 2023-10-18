package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_005_AddToCartPageTest extends BaseClass {
	
	@Test
	public void test_addToCart() throws InterruptedException {
		logger.info(" Starting TC_005_AddToCartPageTest ");

		try {
			
			HomePage hp=new HomePage(driver);
			
			hp.enterProductName("Books");
			hp.clickSearch();
			
			SearchPage sp=new SearchPage(driver);
			
			if(sp.isProductExist("MacBook"))
			{
				sp.selectProduct("MacBook");
				sp.setQuantity("3");
				sp.addToCart();
				
			}
			//Assert.assertEquals(sp.checkConfMsg(),true);

		} catch (Exception e) {
			//Assert.fail();
		}

		logger.info(" Finished TC_004_SearchProductTest ");

	}
}

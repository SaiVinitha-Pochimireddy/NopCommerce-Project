package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage
	{
	public ShoppingCartPage(WebDriver driver)
	{
		super(driver);
	}
	
	//@FindBy(xpath="//button[@aria-expanded='false']")
	@FindBy(xpath="//span[@class='cart-label']")
	WebElement lnkShoppingcart;
	
	@FindBy(xpath="//input[@id='termsofservice']")
	WebElement chkboxTermsofservice;
	
	@FindBy(xpath="//label[text()='Total:']//following::td//child::strong")
	WebElement lblTotalPrice;  //$3,600.00
	
	@FindBy(xpath="//button[@id='checkout']")
	WebElement btnCheckout;
	
	
	public void clickShoppingcart()
	{
		lnkShoppingcart.click();
	}
	public void selectTermsofservice()
	{
		chkboxTermsofservice.click();
	}
	public String getTotalPrice()
	{
		return lblTotalPrice.getText();
	}
	
	public void clickOnCheckout()
	{
		btnCheckout.click();
	}
}

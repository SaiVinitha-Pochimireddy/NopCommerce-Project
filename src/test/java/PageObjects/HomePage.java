package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//locators
	@FindBy(xpath ="//a[normalize-space()='Register']") 
	WebElement RegisterLink;
	
	@FindBy(xpath ="//a[normalize-space()='Log in']") 
	WebElement LoginLink;
	
	@FindBy(xpath = "//input[@id='small-searchterms']")
	WebElement txtSearchbox;
	
	@FindBy(xpath="//button[normalize-space()='Search']") //For Search Product Test
	WebElement btnSearch;
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	WebElement lnkLogout;
	
	@FindBy(xpath = "//img[@alt='nopCommerce demo store']")//checking heading after login
	WebElement imgHeading;
	
	//Action Methods
	public void clickRegister()
	{
		RegisterLink.click();
	}
	
	public void clickLogin()
	{
		LoginLink.click();
	}
	
	public void enterProductName(String pName)   //For Search Product Test
	{
		txtSearchbox.sendKeys(pName);
	}
	
	public void clickSearch()  //For Search Product Test
	{
		btnSearch.click();
	}
	
	public void clickLogout() {
		lnkLogout.click();

	}
	
	public boolean isMyAccountExists()   // MyAccount Page heading display status
	{
		try {
			return (imgHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}

}

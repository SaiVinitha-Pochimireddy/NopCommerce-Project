package PageObjects;

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
	
	//Action Methods
	public void ClickRegister()
	{
		RegisterLink.click();
	}
	
	public void ClickLogin()
	{
		LoginLink.click();
	}

}

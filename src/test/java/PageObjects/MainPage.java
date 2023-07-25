package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

	public MainPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@class='ico-account']") // MyAccount heading in Main Page
	WebElement msgHeading;
	
	@FindBy(xpath = "//a[normalize-space()='Log out']")
	WebElement lnkLogout;
	

	public boolean isMyAccountPageExists()   // MyAccount Page heading display status
	{
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}

	public void clickLogout() {
		lnkLogout.click();

	}
	
}


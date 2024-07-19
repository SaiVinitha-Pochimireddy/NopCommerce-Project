package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='Email']")
	WebElement txtEmailAddress;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement txtPassword;

	@FindBy(xpath = "//button[normalize-space()='Log in']")
	WebElement btnLogin;
	
	@FindBy(xpath="//span[@id='Email-error']") WebElement errorEmail;
	
	@FindBy(xpath="//div[@class='message-error validation-summary-errors']")
	WebElement errorLogin; 


	public void setEmail(String email) {
		txtEmailAddress.sendKeys(email);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}

	public boolean isEmailErrorExists()
	{
		try
		{
			return (errorEmail.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean isLoginErrorExists()
	{
		try
		{
			return(errorLogin.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}

}


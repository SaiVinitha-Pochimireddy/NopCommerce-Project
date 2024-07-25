package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage{

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement  emailtxtbox;
	
	@FindBy(xpath="//button[@name='send-email']")
	WebElement Recoverbtn;
	
	@FindBy(xpath="//p[@class='content']")
	WebElement Emailnotfoundmsg;
	
	@FindBy(xpath="//div[@class='bar-notification success']")
	WebElement EmailsentSuccessmsg;
	
	public void setEmail(String str)
	{
		emailtxtbox.sendKeys(str);
	}
	public void ClickRecover()
	{
		Recoverbtn.click();
	}
	
	public boolean isEmailNotFoundDisplayed()
	{
		try
		{
			return( Emailnotfoundmsg.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean isEmailsentDisplayed()
	{
		try
		{
			return( EmailsentSuccessmsg.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}

}

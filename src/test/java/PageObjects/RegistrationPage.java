package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	@FindBy(xpath="//input[@id='gender-female']")
	WebElement FGender;
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement LastName;
	
	@FindBy(xpath="//select[@name='DateOfBirthDay']")
	WebElement DayDrp;
	Select DayOfBirth = new Select(DayDrp);
	
	@FindBy(xpath="//select[@name='DateOfBirthMonth']")
	WebElement MonthDrp;
	Select MonthOfBirth = new Select(MonthDrp);
	
	@FindBy(xpath="//select[@name='DateOfBirthYear']")
	WebElement YearDrp;
	Select YearOfBirth = new Select(YearDrp);
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@id='ConfirmPassword']")
	WebElement ConfirmPassword;
	
	@FindBy(xpath="//button[@id='register-button']")
	WebElement RegisterBtn;
	
	@FindBy(xpath = "//div[@class='result']")
	WebElement msgConfirmation;
	
	//Action Methods
	
	public void FemaleGender()
	{
		FGender.click();
	}
	
	public void FirstName(String FName)
	{
		FirstName.sendKeys(FName);
	}
	
	public void LastName(String LName)
	{
		LastName.sendKeys(LName);
	}
	
	public void DateOfBirth(String Day,String Month, String Year)
	{
		DayOfBirth.selectByVisibleText(Day);
		MonthOfBirth.selectByVisibleText(Month);
		YearOfBirth.selectByVisibleText(Year);
	}
	
	public void Email(String mail)
	{
		Email.sendKeys(mail);
	}
	
	public void Password(String psw)
	{
		Password.sendKeys(psw);
	}
	
	public void ConfirmPassword(String cpsw)
	{
		ConfirmPassword.sendKeys(cpsw);
	}
	
	public void Register()
	{
		RegisterBtn.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}

	}

}

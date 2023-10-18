package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage{

	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
	}	
	
	@FindBy(xpath="//input[@id='BillingNewAddress_FirstName']")
	WebElement txtfirstName;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_LastName']")
	WebElement txtlastName;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_Email']")
	WebElement txtEmail;

	@FindBy(xpath="//input[@id='BillingNewAddress_Address1']")
	WebElement txtaddress1;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_Address2']")
	WebElement txtaddress2;
	
	
	@FindBy(xpath="//input[@id='BillingNewAddress_City']")
	WebElement txtcity;
	
	
	@FindBy(xpath="//input[@id='BillingNewAddress_ZipPostalCode']")
	WebElement txtpin;
	
	
	@FindBy(xpath="//select[@id='BillingNewAddress_CountryId']")
	WebElement drpCountry;
	
	
	@FindBy(xpath="//select[@id='BillingNewAddress_StateProvinceId']")
	WebElement drpState;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_PhoneNumber']")
	WebElement txtPhone;

	@FindBy(xpath="//button[@onclick='Billing.save()']")
	WebElement btncontinueBillingAddress;
	/*
	@FindBy(xpath="//input[@id='button-shipping-address']")
	WebElement btncontinueDeliveryAddress;
	
	@FindBy(xpath="//textarea[@name='comment']")
	WebElement txtDeliveryMethod;
	
	@FindBy(xpath="//input[@id='button-shipping-method']")
	WebElement btncontinueShippingAddress;
	
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkboxTerms;
	*/
	@FindBy(xpath="//button[@class='button-1 shipping-method-next-step-button']")
	WebElement btncontinueShippingMethod;
	
	@FindBy(xpath="//button[@class='button-1 payment-method-next-step-button']")
	WebElement btncontinuePaymentMethod;
	
	@FindBy(xpath="//button[@class='button-1 payment-info-next-step-button']")
	WebElement btncontinuePaymentInformation;
	
	@FindBy(xpath="//label[text()='Total:']//following::td//child::strong")
	WebElement lblTotalPrice;
	
	
	@FindBy(xpath="//button[normalize-space()='Confirm']")
	WebElement btnConfOrder;
	
	
	@FindBy(xpath="//strong[normalize-space()='Your order has been successfully processed!']")
	WebElement lblOrderConMsg;
	
	

	public void setfirstName(String firstName) {
		txtfirstName.clear();
		txtfirstName.sendKeys(firstName);
	}


	public void setlastName(String lastName) {
		txtlastName.clear();
		txtlastName.sendKeys(lastName);
	}
	
	public void setEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}


	public void setaddress1(String address1) {
		txtaddress1.sendKeys(address1);
	}


	public void setaddress2(String address2) {
		txtaddress2.sendKeys(address2);
	}


	public void setcity(String city) {
		txtcity.sendKeys(city);
	}


	public void setpin(String pin) {
		txtpin.sendKeys(pin);
	}


	public void setCountry(String Country) {
		new Select(drpCountry).selectByVisibleText(Country);
	}


	public void setState(String State) {
		new Select(drpState).selectByVisibleText(State);
	}
	
	public void setPhoneno(String phone) {
		txtPhone.sendKeys(phone);
	}
	
	public void clickOnContinueAfterBillingAddress()
	{
		btncontinueBillingAddress.click();
	}
	/*
	public void clickOnContinueAfterDeliveryAddress()
	{
		btncontinueDeliveryAddress.click();
	}
	
	
	public void setDeliveryMethodComment(String deliverymsg)
	{
		txtDeliveryMethod.sendKeys(deliverymsg);
		
	}
	
	public void clickOnContinueAfterDeliveryMethod()
	{
		btncontinueShippingAddress.click();
	}
	
	public void selectTermsAndConditions()
	{
		chkboxTerms.click();
	}
	*/
	public void clickOnContinueAfterShippingMethod()
	{
		btncontinueShippingMethod.click();
	}
	
	public void clickOnContinueAfterPaymentMethod()
	{
		btncontinuePaymentMethod.click();
	}
	
	public void clickOnContinueAfterPaymentInformation()
	{
		btncontinuePaymentInformation.click();
	}
	
	public String  getTotalPriceBeforeConfOrder()
	{
		return lblTotalPrice.getText(); //$207.00
		
	}
	
	public void clickOnConfirmOrder() {
		btnConfOrder.click();
	}
	
	public boolean isOrderPlaced() throws InterruptedException
	{
		try
		{
		/*driver.switchTo().alert().accept();
		Thread.sleep(2000);
		btnConfOrder.click();
		Thread.sleep(3000);*/
		if(lblOrderConMsg.getText().equals("Your order has been successfully processed!"))
			return true;
		else
			return false;
		}catch(Exception e)
		{
			return false;
		}
		
	}
	
}

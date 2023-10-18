package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage
{   
	WebDriver driver;
	
	public SearchPage(WebDriver driver)
	{
		super(driver);
	}	
	
		@FindBy(xpath="//div[@class='search-results']//div[@class='item-grid']//h2/a")
		List<WebElement> searchProducts;
				
		@FindBy(xpath="//input[@id='product_enteredQuantity_4']")
		WebElement txtquantity;
		
		@FindBy(xpath="//button[@id='add-to-cart-button-4']")
		WebElement btnaddToCart;
		
		@FindBy(xpath="//p[@class='content']")
		WebElement cnfMsg;
		
		public boolean isProductExist(String productName)
		{
			boolean flag=false;
			for(WebElement product:searchProducts)
			{				
				if(product.getText().contains(productName))
				{
				flag=true;
				break;
				}
			}
			
			return flag;
		
		}
		
		public void selectProduct(String productName)
		{
			for(WebElement product:searchProducts)
			{				
				if(product.getText().contains(productName))
				{
					product.click();
				}
			}
		
		}
		
		public void setQuantity(String qty)
		{
			txtquantity.clear();
			txtquantity.sendKeys(qty);
		}
		
		public void addToCart()
		{
			btnaddToCart.click();
		}
		
		public boolean checkConfMsg()
		{
			try
			{
			return cnfMsg.isDisplayed();
			}
			catch(Exception e)
			{
				return false;
			}
		}
		
}


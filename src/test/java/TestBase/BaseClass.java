package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	
	public Logger logger;
	
	public ResourceBundle rb;
	
	@BeforeClass(groups = { "Master", "Sanity", "Regression" })
	//@Parameters("browser")
	public void SetUp()
	{
		logger= LogManager.getLogger(this.getClass());
		
		rb= ResourceBundle.getBundle("Config");
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
		/*if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}*/
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	}
	
	public String RandNum()
	{
		String rnum= RandomStringUtils.randomNumeric(10);
		return rnum;
	}
	
	public String RandString()
	{
		String ralpha= RandomStringUtils.randomAlphabetic(5);
		return ralpha;
	}
	
	public String RandAlphaNum()
	{
		String rnum= RandomStringUtils.randomNumeric(8);
		String ralpha= RandomStringUtils.randomAlphabetic(5);
		return rnum+"@"+ralpha;
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

	@AfterClass(groups = { "Master", "Sanity", "Regression" }) 
	public void close()
	{
		driver.quit();
	} 

}

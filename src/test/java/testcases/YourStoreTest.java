package testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.YourStore;
import resources.Base;

public class YourStoreTest extends Base{

	public  WebDriver driver;
	public  Properties prop;
	@BeforeMethod
	public void getDriverInstance()
	{
		driver=getDriverObject();
		prop=getPropertiesObject();
	}
	
	@Test
	public void verifyTitle()
	{
		driver.get("http://tutorialsninja.com/demo/");
		YourStore yourStorePage=new YourStore(driver);
		String actualPageTitle=yourStorePage.returnTitle();
		String expectedPageTitle=driver.getTitle();
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
	}
	
	@AfterMethod
	public void closure()
	{
		driver.close();
	}
}

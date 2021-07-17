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
	YourStore yourStorePage;
	@BeforeMethod
	public void getDriverInstance()
	{
		driver=getDriverObject();
		prop=getPropertiesObject();
		yourStorePage=new YourStore(driver);
	}
	
	/**
	 * 
	 * 
	 */
	@Test
	public void verifyTitle()
	{
		driver.get("http://tutorialsninja.com/demo/");
		
		String actualPageTitle=yourStorePage.returnTitle();
		String expectedPageTitle=driver.getTitle();
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
	}
	
	/**
	 * This test is used to verify if the product added to card is successfully added or not 
	 *  
	 * @throws InterruptedException
	 */
	@Test
	public void verifyShoppingCart() throws InterruptedException
	{
		driver.get("http://tutorialsninja.com/demo/");
		String actualProductName=yourStorePage.retrunFirstProductName();
		String productNameInShoppingCart=yourStorePage.clickOnAddToCart().clickOnShoppingCart().retrunFirstProductInShoppingCart();
		//yourStorePage.clickOnAddToCart().clickOnShoppingCart().retrunFirstProductInShoppingCart();
		Assert.assertEquals(actualProductName,productNameInShoppingCart);
	}
	
	@AfterMethod
	public void closure()
	{
		driver.close();
	}
}

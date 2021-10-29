package testcases;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.Login;
import pageObjects.MyAccount;
import pageObjects.MyWishList;
import pageObjects.YourStore;
import resources.Base;

public class WishListTest extends Base {

	public WebDriver driver;
	public Properties prop;
	YourStore yourStorePage;
	Login loginPage;
	MyAccount myAccount;
	MyWishList wishList;
	Logger log;

	@BeforeMethod
	public void getDriverInstance() {
		driver = getDriverObject();
		prop = getPropertiesObject();
		yourStorePage = new YourStore(driver);
		myAccount = new MyAccount(driver);
		wishList = new MyWishList(driver);
		log = LogManager.getLogger(LoginTest.class.getName());

		log.info("loaded url");
		driver.get(prop.getProperty("url"));
		log.info("Oepning login popup");
		loginPage = yourStorePage.clickOnMyAccount().clickOnLogin();
		log.info("Entering username and password");
		loginPage.getEmailField().sendKeys(prop.getProperty("username"));
		loginPage.getPwdField().sendKeys(prop.getProperty("password"));
		try {
			log.info("clicking on login");
			myAccount = loginPage.clickOnLogin();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void verifyUserIsOnWishList()
	{
		wishList=myAccount.clickOnWishList();
		Assert.assertTrue(wishList.verifyTitle());
		//System.out.println("The title test of : " + wishList.verifyTitle());
	}
	
	@Test(dependsOnMethods= {"verifyUserIsOnWishList"})
	public void printWishListTable()
	{	
		wishList=myAccount.clickOnWishList();
		wishList.printWishTable();
	}
	
	@Test
	public void ClickOnContinue()
	{
		wishList=myAccount.clickOnWishList();
		myAccount =wishList.clickOnContinue();
		Assert.assertTrue(myAccount.verifyTitle("My Account"));
	}
	
	@AfterMethod
	public void closure() {
		driver.close();
	}
	
}

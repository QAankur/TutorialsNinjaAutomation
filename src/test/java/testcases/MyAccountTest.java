package testcases;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.Login;
import pageObjects.MyAccount;
import pageObjects.YourStore;
import resources.Base;

public class MyAccountTest extends Base{

	public WebDriver driver;
	public Properties prop;
	YourStore yourStorePage;
	Login loginPage;
	MyAccount myAccount;
	Logger log;

	@BeforeMethod
	public void getDriverInstance() {
		driver = getDriverObject();
		prop = getPropertiesObject();
		yourStorePage=new YourStore(driver);
		myAccount=new MyAccount(driver);
		log=LogManager.getLogger(LoginTest.class.getName());
	}
	
	@Test
	public void clickDesktopOptions()
	{
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
		try {
			myAccount.moveToDesktopAndSelectAllDesktop().verifyTitle(driver.getTitle());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void closure() {
		driver.close();
	}
}

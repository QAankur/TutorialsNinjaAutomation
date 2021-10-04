package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Login;
import pageObjects.MyAccount;
import pageObjects.YourStore;
import resources.Base;

public class LoginTest extends Base {
	public WebDriver driver;
	public Properties prop;
	YourStore yourStorePage;
	Login loginPage;
	MyAccount myAccount;

	@BeforeMethod
	public void getDriverInstance() {
		driver = getDriverObject();
		prop = getPropertiesObject();
		yourStorePage = new YourStore(driver);
	}

	@Test
	public void login() throws InterruptedException {

		
		driver.get(prop.getProperty("url"));
		loginPage = yourStorePage.clickOnMyAccount().clickOnLogin();
		loginPage.getEmailField().sendKeys(prop.getProperty("username"));
		loginPage.getPwdField().sendKeys(prop.getProperty("password"));
		myAccount = loginPage.clickOnLogin();
		Assert.assertTrue(myAccount.verifyTitle(driver.getTitle()));
		Assert.assertTrue(myAccount.getAccountElement().isDisplayed());

	}

	@AfterMethod
	public void closure() {
		driver.close();
	}
}

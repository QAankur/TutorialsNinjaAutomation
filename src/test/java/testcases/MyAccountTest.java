package testcases;

import java.util.Properties;

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

	@BeforeMethod
	public void getDriverInstance() {
		driver = getDriverObject();
		prop = getPropertiesObject();
		yourStorePage=new YourStore(driver);
		myAccount=new MyAccount(driver);
	}
	
	@Test
	public void clickDesktopOptions()
	{
		driver.get("http://tutorialsninja.com/demo/");
		loginPage = yourStorePage.clickOnMyAccount().clickOnLogin();
		loginPage.getEmailField().sendKeys("mishra.ankur671@gmail.com");
		loginPage.getPwdField().sendKeys("Adipo@123");
		try {
			myAccount = loginPage.clickOnLogin();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			myAccount.moveToDesktopAndSelectAllDesktop().verifyTitle(driver.getTitle());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void closure() {
		driver.close();
	}
}

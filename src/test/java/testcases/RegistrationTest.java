package testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.MyAccount;
import pageObjects.UserRegistration;
import pageObjects.YourStore;
import resources.Base;

public class RegistrationTest extends Base {

	WebDriver driver;
	Properties prop;
	YourStore yourStorePage;
	UserRegistration registration;
	@BeforeMethod
	public void getDriverInstance() {
		driver = getDriverObject();
		prop = getPropertiesObject();
		yourStorePage=new YourStore(driver);
		
	}
	
	@Test
	public void doUserRegistration() throws InterruptedException
	{
		driver.get("http://tutorialsninja.com/demo/");
		registration=yourStorePage.clickOnMyAccount().clickOnRegister();
		registration.getFirstName().sendKeys("aman");
		registration.getlastName().sendKeys("sharma");
		registration.getEmail().sendKeys("am45425@gmail.com");
		registration.getTelephone().sendKeys("312234");
		registration.getPassword().sendKeys("asdf123");
		registration.getConfirmPassword().sendKeys("asdf1234");
		registration.getPrivacyBtn().click();
		Thread.sleep(5000);
		registration.clickOnContinue();
	}
	@AfterMethod
	public void closure() {
		driver.close();
	}
}

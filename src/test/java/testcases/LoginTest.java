package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class LoginTest extends Base {

	@Test
	public void login()
	{
		WebDriver driver=Base.setUpDriver();
		driver.get("http://tutorialsninja.com/demo/");
	}
}

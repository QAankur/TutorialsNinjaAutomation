package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Desktops {

	private WebDriver driver;
	private String Title="Desktops";
	public Desktops(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyTitle(String title)
	{
		return Title.equals(title);
	}
}

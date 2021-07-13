package pageObjects;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class YourStore{

	private WebDriver driver;
	private String pageTitle="Your Store";
	
	public YourStore(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="")
	WebElement title;
	
	public String returnTitle()
	{
		return pageTitle;
	}
}

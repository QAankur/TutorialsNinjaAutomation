package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWishList {

	private String title="My Wish List";
	WebDriver driver;
	public MyWishList(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Continue')]")
	private WebElement continueBtn;
	
	
	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public Boolean verifyTitle()
	{
		return driver.getTitle().equals(title);
		
	}
	
	public void printWishTable()
	{
		List<WebElement> rowNum=driver.findElements(By.xpath("//*[@id='content']/div[1]/table/tbody/tr"));
		List<WebElement> colNum=driver.findElements(By.xpath("//*[@id='content']/div[1]/table/tbody/tr[1]/td"));
		for(int i=1; i<=rowNum.size(); i++)
		{
			for(int j=2; j<=5; j++)
			{
				String xpath="//*[@id='content']/div[1]/table/tbody/tr["+ i +"]/td["+ j +"]";
				String s=driver.findElement(By.xpath(xpath)).getText();
				System.out.print(s);
			}
			System.out.println("");
		}
		
	}
	
	public MyAccount clickOnContinue()
	{
		getContinueBtn().click();
		return new MyAccount(driver);
	}
}

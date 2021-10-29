package pageObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {

	WebDriver driver;
	private String title="My Account";
	public MyAccount(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='breadcrumb']//child::li[2]/a[text()='Account']")
	private WebElement accountElement;
	
	@FindBy(xpath="//a[normalize-space()='Desktops']")
	private WebElement desktopButton;
	
	@FindBy(xpath="//a[contains(text(),'Wish List')]")
	private WebElement wishListFButton;
	
	public WebElement getWishListFButton() {
		return wishListFButton;
	}

	public WebElement getAccountElement()
	{
		return accountElement;
	}
	
	public boolean verifyTitle(String title)
	{
		boolean b=this.title.equals(title);
		//System.out.println(b);
		return b;
	}
	
	public WebElement getDesktopButton()
	{
		return desktopButton;
	}
	public Desktops moveToDesktopAndSelectAllDesktop() throws InterruptedException
	{
		
		Actions action=new Actions(driver);
		action.moveToElement(getDesktopButton());
		getDesktopButton().click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='Show All Desktops']")).click();
		return new Desktops(driver);
	}
	
	public Boolean verifyValueIsDisplayedInTable(String expectedValue)
	{
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='list-group']/a"));
		Iterator<WebElement> ele=list.iterator();
		List<String> list1=new ArrayList<String>();
		int i=0;
		Boolean flag=false;
		while(ele.hasNext())
		{
			if(ele.next().getText().equals(expectedValue))
			{
				i=1;
				break;
			}
			
		}
		if(i==1)
		{
			flag=true;
		}
		
		return flag;
	}
	
	public MyWishList clickOnWishList()
	{
		wishListFButton.click();
		
		return new MyWishList(driver);
	}
}

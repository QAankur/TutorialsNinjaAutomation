package pageObjects;

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
	
}

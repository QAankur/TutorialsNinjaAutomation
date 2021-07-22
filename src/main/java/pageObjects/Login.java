package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	WebDriver driver;
	public Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement pwdField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginBtn;
	
	public WebElement getEmailField()
	{
		return  emailField;
	}
	public WebElement getPwdField()
	{
		return pwdField;
	}
	public WebElement getLoginBtn()
	{
		return loginBtn;
	}
	public MyAccount clickOnLogin() throws InterruptedException
	{
		
		loginBtn.click();
		return new MyAccount(driver);
	}
}

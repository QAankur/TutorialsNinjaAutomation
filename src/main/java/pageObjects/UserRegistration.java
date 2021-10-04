package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserRegistration {

	WebDriver driver;
	public UserRegistration(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']") 
	private WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-email']") 
	private WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']") 
	private WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement confirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement privacyBtn;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueBtn;
	
	
	public WebElement getFirstName()
	{
		return firstName;
	}
	
	public WebElement getlastName()
	{
		return lastName;
	}
	
	public WebElement getEmail()
	{
		return email;
	}
	
	public WebElement getTelephone()
	{
		return telephone;
	}
	
	public WebElement getPassword()
	{
		return password;
	}
	
	public WebElement getConfirmPassword()
	{
		return confirmPassword;
	}
	
	public WebElement getPrivacyBtn()
	{
		return privacyBtn;
	}
	
	public void clickOnContinue()
	{
		continueBtn.click();
	}
}

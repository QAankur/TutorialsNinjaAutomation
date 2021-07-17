package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {

	private WebDriver driver;
	public ShoppingCart(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='content']/form/div/table/tbody/tr[1]/td[2]/a")
	private WebElement shopCart;
	
	public WebElement getShopCart()
	{
		return shopCart;
		
	}
	
	public String retrunFirstProductInShoppingCart() throws InterruptedException
	{
		return getShopCart().getText();
		
	}
	
	
}

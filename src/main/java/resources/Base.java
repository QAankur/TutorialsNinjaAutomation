package resources;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public void setUpProperties() {
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\Data.properties";
		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			prop = new Properties();
			if (fileInputStream != null) {
				prop.load(fileInputStream);
			} else {
				System.out.println("Properties file object is null");
			}
		} catch (Exception e) {

		}

	}

	public void setUpDriver() {
		String browserName = getPropertiesObject().getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public Properties getPropertiesObject() {
		setUpProperties();
		return prop;

	}

	public WebDriver getDriverObject() {
		setUpDriver();
		return driver;

	}
	/*
	 * public WebDriver getDriver() { return driver;
	 * 
	 * }
	 * 
	 * public Properties getPropertiesObject() { return prop;
	 * 
	 * }
	 */
}

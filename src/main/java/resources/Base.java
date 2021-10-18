package resources;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	private WebDriver driver;
	private Properties prop;
	
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
	
	public ExtentReports getExtentReport()
	{
		String path=System.getProperty("user.dir")+"\\reports\\extentReport.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Automation report");
		reporter.config().setReportName("TutorialsNinja.com");
		reporter.config().setTheme(Theme.DARK);
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Operating System", path);
		extent.setSystemInfo("Automation Script Developer", "Ankur Mishra");
		return extent;
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

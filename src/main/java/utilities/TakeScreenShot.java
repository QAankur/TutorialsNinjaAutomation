package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import resources.Base;

public class TakeScreenShot extends Base {

	public static String getScreenShot(String testName, WebDriver driver)
	{
		TakesScreenshot t=(TakesScreenshot)driver;
		File file=t.getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		String fileDestination=System.getProperty("user.dir")+"\\screenshot\\" + testName + timestamp + ".png";
		try {
			FileUtils.copyFile(file,new File(fileDestination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fileDestination;
	}
}

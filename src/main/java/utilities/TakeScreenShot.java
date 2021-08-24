package utilities;

import java.io.File;
import java.io.IOException;

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
		String fileDestination=System.getProperty("user.dir")+"\\screenshot\\" + testName + ".png";
		try {
			FileUtils.copyFile(file,new File(fileDestination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fileDestination;
	}
}

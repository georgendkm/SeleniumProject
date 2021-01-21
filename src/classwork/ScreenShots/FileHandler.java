package classwork.ScreenShots;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import classwork.BaseDriver;

public class FileHandlers extends BaseDriver {

	public static void main(String[] args) throws Exception {
		FileHandlers screen= new FileHandlers();
		launchbrowser("chrome", "https://www.expedia.com/");
		
	}

	public void captureScreen(String filename){
		
		TakesScreenshot obj=(TakesScreenshot) driver;
		File ss= obj.getScreenshotAs(OutputType.FILE);
		FileHandlers.copy(ss, new File(filename));
	}
}


package classwork.profileSettings;

import java.util.Collections;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
/**
setting chrome profile  for uploading and downloading files
 * @author binds
 *
 */

public class FilLoadingProfileChrome {
	
	public WebDriver driver;
	
	@Test
	public void launch() throws Exception {
		
			System.setProperty("webdriver.chrome.driver", ".\\browsers\\chromedriver.exe");
			  // Setting new download directory path
	        Map<String, Object> prefs = new HashMap<String, Object>();
	         
	        // Use File.separator as it will work on any OS
	        prefs.put("download.default_directory", "C:\\Users\\binds\\eclipse-workspace\\SeleniumProject\\downloads\\");

	         
	        // Adding capabilities to ChromeOptions
	        ChromeOptions options = new ChromeOptions();
	        options.setExperimentalOption("prefs", prefs);
	        //disabling that browser is controlled by automated software popups
	        options.setExperimentalOption("useAutomationExtension", false);
	        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

	        // Launching browser with desired capabilities
	        driver= new ChromeDriver(options);
			
	    	driver.get("file:///C:/Users/binds/eclipse-workspace/HTML/FileUpLoad.html");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//a[text()='Download Me']")).click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//input[@id='fileToUpload']")).sendKeys("C:\\Users\\binds\\eclipse-workspace\\HTML\\SampleDownloadFile.zip");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@name='uploadfile']")).click();
			Thread.sleep(5000);
		}
	}


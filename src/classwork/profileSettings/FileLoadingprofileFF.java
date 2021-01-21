package classwork.profileSettings;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

/**
 * creating the firefox browser profile for custom made download location and skipping the "ok"popups from the download menu.
 * @author binds
 *
 */
public class FileLoadingprofileFF {
	
	public WebDriver driver;
	
	@Test
	public void launchBrowser() throws Exception {

		System.setProperty("webdriver.gecko.driver", ".\\browsers\\geckodriver.exe");
		
		//creating firefox profile
		FirefoxProfile  profile= new FirefoxProfile();
		
		profile.setPreference("browser.download.folderList", 2); // setting the folder to create the download file. 2 represents the detaul profile and userprofile.
		
		//profile.setPreference("browser.download.dir", "C:\\Users\\binds\\eclipse-workspace\\SeleniumProject\\downloads");  // giving the path to download the file.
		profile.setPreference("browser.download.dir", System.getProperty("user.dir") + File.separator + "eclipse_workspace"
	            + File.separator + "downloads" + File.separator);
		
		// skipping the pop ups coming for the download options - adding all varieties of file types to skip the popups.
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "multipart/x-zip,application/zip,application/x-zip-compressed,application/x-compressed,text/csv,application/java-archive, application/x-msexcel,application/excel,application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/vnd.microsoft.portable-executable");
	
		FirefoxOptions options= new FirefoxOptions(); // creating the new firefox options.
		options.setProfile(profile); // setting the profile in options.
		
		driver= new FirefoxDriver(options);
		driver.get("file:///C:/Users/binds/eclipse-workspace/HTML/FileUpLoad.html");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Download Me']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='fileToUpload']")).sendKeys("C:\\Users\\binds\\eclipse-workspace\\HTML\\SampleDownloadFile.zip");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[text()='Upload File']")).click();
		driver.close();
	

}
}

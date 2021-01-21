package myexercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseDriver {
	
	public static WebDriver driver;
			
	public  static void launchbrowser(String broname, String url) throws InterruptedException{
			
		System.setProperty("webdriver.chrome.driver", ".\\Browsers\\chromedriver.exe");
		System.setProperty("webdriver.edge.driver", ".\\Browsers/edgedriver.exe");
		System.setProperty("webdriver.gecko.driver", ".\\Browsers\\geckodriver.exe");
			
				
		if(broname.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
			
		driver.get(url);
		//driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
		//driver.manage().timeouts().setScriptTimeout(20,  TimeUnit.SECONDS);
			
	}

}
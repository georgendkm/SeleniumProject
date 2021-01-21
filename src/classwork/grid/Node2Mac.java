package classwork.grid;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import classwork.jdbc.JdbcDataProvider;

public class Node2Mac {
	public WebDriver driver;
	public String bname = "Chrome";
	public String url = "http://automationpractice.com/";
	public String nodeUrl= "http://192.168.1.84:4444/wd/hub";
	public String runMode="remote";
	
	@BeforeClass
	public void launchBrowser() throws Exception {
		if(runMode.equalsIgnoreCase("remote")) {
			if(bname.equalsIgnoreCase("Firefox")) {
				FirefoxOptions options= new FirefoxOptions();
				driver = new RemoteWebDriver(new URL(nodeUrl), options) ;
						
			} else {
				ChromeOptions options= new ChromeOptions();
				driver = new RemoteWebDriver(new URL(nodeUrl), options);
			}
			} else {
				System.setProperty("webdriver.gecko.driver", ".\\browsers\\geckodriver.exe");
				System.setProperty("webdriver.chrome.driver", ".\\browsers\\chromedriver.exe");
					
				if(bname.equalsIgnoreCase("Chrome")) {
					driver = new ChromeDriver();   
				} else {
					driver = new FirefoxDriver();
			}
			
			
			
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
	}
	

	@Test(priority=1, dataProvider="jdbcData", dataProviderClass=JdbcDataProvider.class)
	public void searchDress(String sreach) throws Exception {
		String searchXpath = "//input[@name='search_query']";
		String submitXpath = "//button[@class='btn btn-default button-search'][@name='submit_search']";
		
		driver.findElement(By.xpath(searchXpath)).click();
		driver.findElement(By.xpath(searchXpath)).clear();
		driver.findElement(By.xpath(searchXpath)).sendKeys(sreach);
		Thread.sleep(3000);
		driver.findElement(By.xpath(submitXpath)).click();
		Thread.sleep(3000);
	}
	@Test(priority=3)
	public void close() throws Exception {
		Thread.sleep(5000);
		System.out.println("closing browser");
		driver.quit();
	}

}

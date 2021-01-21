package classwork.grid;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.pages.SearchPage;

//import pom.pages.SearchPage;
/**
 * using pom model of search result for ebay and running it as node1 for windows machine using runMode as "remote" session.
 * @author binds
 * date:01/14/21
 *
 */

public class Node1Windows {
	public WebDriver driver;
	public String browname="Firefox";
	public String url="https://www.ebay.com/";
	public String hubUrl= "http://localhost:4442/wd/hub";
	public String runMode="remote";  //using remote for grid and node purpose and local for regular testNg run.
	SearchPage searchpage;
	
	@BeforeClass
	public void launchBrowser() throws Exception {
		
		if(runMode.equalsIgnoreCase("remote")) {
			if(browname.equalsIgnoreCase("Firefox")) {
				FirefoxOptions options= new FirefoxOptions();
				driver = new RemoteWebDriver(new URL(hubUrl), options) ;
				
			}  else {
					 ChromeOptions options= new ChromeOptions();
					 driver = new RemoteWebDriver(new URL(hubUrl), options);
					}
						
			}else {
				System.setProperty("webdriver.chrome.driver", ".\\Browsers\\chromedriver.exe");
				System.setProperty("webdriver.edge.driver", ".\\Browsers/edgedriver.exe");
				System.setProperty("webdriver.gecko.driver", ".\\Browsers\\geckodriver.exe");
						
				if(browname.equalsIgnoreCase("Firefox")) {
					driver = new FirefoxDriver();  
				} else {
					driver = new ChromeDriver();  
				}
			}
		
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
		//driver.manage().timeouts().setScriptTimeout(20,  TimeUnit.SECONDS);
		//SearchPage searchpage = PageFactory.initElements(driver, SearchPage.class);  // Initializing the pages in before class method to get access to all the test in this class
	}	

	/*@AfterClass
	public void closeBrowser() {
		driver.quit();
	}*/
	
	@Test(priority=1)
	public void searchItems() throws Exception {
		SearchPage searchpage = PageFactory.initElements(driver, SearchPage.class);
		Thread.sleep(2000);
		boolean rFlag=searchpage.verifySearch("vareigated monstera adansonii");
		Assert.assertTrue(rFlag, "Search Item not displayed");
		
		String reFlag=searchpage.verifySearchResults();
		//Assert.assertEquals(reFlag, reFlag);
		Assert.assertTrue(reFlag.isEmpty(), reFlag);
		
	}
	
	@Test(priority=4)
	public void close() {
		driver.close();
	}
	
	/*public void selectItems() {
	searchResults.
	}
	*/
}




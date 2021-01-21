package classwork.pom.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.pages.SearchPage;

public class SearchEbayTest {

	public WebDriver driver;
	public String browname="Chrome";
	public String url="https://www.ebay.com/";
	SearchPage searchpage;
	
	@BeforeClass
	public void launchBrowser() throws Exception {
		System.setProperty("webdriver.chrome.driver", ".\\Browsers\\chromedriver.exe");
		System.setProperty("webdriver.edge.driver", ".\\Browsers/edgedriver.exe");
		System.setProperty("webdriver.gecko.driver", ".\\Browsers\\geckodriver.exe");
			
				
		if(browname.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
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
	
	@Test
	public void searchItems() throws Exception {
		SearchPage searchpage = PageFactory.initElements(driver, SearchPage.class);
		Thread.sleep(2000);
		boolean rFlag=searchpage.verifySearch("vareigated monstera adansonii");
		Assert.assertTrue(rFlag, "Search Item not displayed");
		
		String reFlag=searchpage.verifySearchResults();
		//Assert.assertEquals(reFlag, reFlag);
		Assert.assertTrue(reFlag.isEmpty(), reFlag);
		
	}
	
	
	
	/*public void selectItems() {
	searchResults.
	}
	*/
}

package classwork.jdbc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * search using JDBC data provider
 * @author binds
 *
 */

public class SearchUsingJDBC {
	public WebDriver driver;
	public String bname = "Firefox";
	public String url = "http://automationpractice.com/";
	
	@BeforeClass
	public void launchBrowser() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", ".\\browsers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", ".\\browsers\\chromedriver.exe");
			
		if(bname.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
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

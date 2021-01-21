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


/**running search items using jdbc data and included into grid-node run.
 * error - locally its running but in remote the chromedriver exe is not picking.
 * error message: org.openqa.selenium.SessionNotCreatedException: Unable to create new service: ChromeDriverService // dele this after the fix.
 * no error with Firefox in remote mode too.
 * @author binds
 *
 */
public class Node1aWindows {
	
		public WebDriver driver;
		public String bname="chrome";
		//public String bname = "Firefox";
		public String url = "http://automationpractice.com/";
		public String hubUrl= "http://localhost:4442/wd/hub";
		public String runMode="remote";
		
		@BeforeClass
		public void launchBrowser() throws Exception {
			if(runMode.equalsIgnoreCase("remote")) {
				
				if(bname.equalsIgnoreCase("chrome")) {
					//FirefoxOptions options= new FirefoxOptions();
					//driver = new RemoteWebDriver(new URL(hubUrl), options) ;
					ChromeOptions options= new ChromeOptions();
					driver = new RemoteWebDriver(new URL(hubUrl), options);
							
				} else {
					
					FirefoxOptions options= new FirefoxOptions();
					driver = new RemoteWebDriver(new URL(hubUrl), options) ;
					//ChromeOptions options= new ChromeOptions();
					//driver = new RemoteWebDriver(new URL(hubUrl), options);
							
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
			//Thread.sleep(5000);
			System.out.println("closing browser");
			driver.quit();
		}

	}




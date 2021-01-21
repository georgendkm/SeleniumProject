package classwork.logger;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Creating logger for search items in method level.
 * @author binds
 *
 */


public class SearchLogger {

	
		public WebDriver driver;
		public String bname = "Chrome";
		public String url = "http://automationpractice.com/";
		Logger log;
		
		@BeforeClass
		public void launchBrowser() throws Exception {
			
			System.setProperty("webdriver.gecko.driver", ".\\browsers\\geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", ".\\browsers\\chromedriver.exe");
				
			if(bname.equalsIgnoreCase("Chrome")) {
				driver = new   ChromeDriver();
			} else {
				driver = new FirefoxDriver();
			}
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
		}
		
/*		
		@BeforeMethod()
		public void initLog(Method m) throws Exception, IOException {
			
			SimpleDateFormat formater = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
			String dateTime = formater.format(new Date());
			//String logfile= ".\\logs" + m.getName() + ".txt";
			String logfile="\\logs"+File.separator + m.getName()+dateTime+".txt";
			System.out.println(logfile);
			log = Logger.getLogger(logfile);   //giving the file name based on your particular method and here we are parameterizing the method name.
			log.setLevel(Level.ALL);
			FileHandler handler= new FileHandler(logfile);
			log.addHandler(handler);
			handler.setFormatter(new SimpleFormatter()); // this is a class level formatter and creating the setter and setting its in same time for text files.
			//handler.setFormatter(new XMLFormatter());
		
		}
			
		
		// closing the opened log handler using for each method
		
		@AfterMethod()
		public void releaseLog() {
			for(Handler handler:log.getHandlers()) {
				handler.close();
				System.out.println("closed the logger");
			
			}
			
		}

*/
		
		@BeforeMethod
		public void initLog(Method m) throws Exception {
			SimpleDateFormat formater = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
			String dateTime = formater.format(new Date());
			String logfile="logs"+File.separator + m.getName()+dateTime+".xml";
			System.out.println(logfile);
			log = Logger.getLogger(logfile);
			log.setLevel(Level.ALL);
			FileHandler handler = new FileHandler(logfile);
			log.addHandler(handler);
			handler.setFormatter(new SimpleFormatter());
			//handler.setFormatter(new XMLFormatter());
		}
		
		@AfterMethod
		public void relLog() {
			for(Handler h: log.getHandlers()){
				h.close();   
			}
		}

		@Test(priority=1)
		public void searchDress() throws Exception {
			String searchXpath = "//input[@name='search_query']";
			String submitXpath = "//button[@class='btn btn-default button-search'][@name='submit_search']";
			driver.findElement(By.xpath(searchXpath)).click();
			log.info("clicked the search");
			driver.findElement(By.xpath(searchXpath)).clear();
			driver.findElement(By.xpath(searchXpath)).sendKeys("summer dresses");
			log.info("entered the search item");
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

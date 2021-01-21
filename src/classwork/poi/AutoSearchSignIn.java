package classwork.poi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutoSearchSignIn {

	public WebDriver driver;
	public String bname = "Firefox";
	public String url = "http://automationpractice.com/";
	
	@BeforeClass
	public void launchBrowser() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", ".\\browsers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", ".browsers\\chromedriver.exe");
			
		if(bname.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.get(url);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
	}
	

	@Test(priority=1, dataProvider="autodata", dataProviderClass=ReadAutoData.class)
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
	
/*	@Test(priority=2, dataProvider="autodata", dataProviderClass=ReadAutoData.class)
	public void createUser(String email, String pwd) throws Exception {

		String signinXpath = "//a[normalize-space(text())='Sign in']";
		String emailinputXpath= "//input[@id='email_create']";
		String emailbtnxpath="//button[@name='SubmitCreate']";
	
		driver.findElement(By.xpath(signinXpath)).click();
		Thread.sleep(5000);
		System.out.println("Clicked on sign in link");
		driver.findElement(By.xpath(emailinputXpath)).clear();
		driver.findElement(By.xpath(emailinputXpath)).sendKeys(email);
		driver.findElement(By.xpath(emailbtnxpath)).click();
		Thread.sleep(5000);
		System.out.println("Entered mail id and clicked on create user button");
		System.out.println(pwd);
	}*/
	
	@Test(priority=3)
	public void close() throws Exception {
		Thread.sleep(5000);
		System.out.println("closing browser");
		driver.quit();
	}
	

}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverBase {
	public WebDriver driver;
		
	public  void launchbrowser(String broname, String url){
		
		System.setProperty("webdriver.chrome.driver", ".\\Browsers\\chromedriver.exe");
		System.setProperty("webdriver.edge.driver", ".\\Browsers/edgedriver.exe");
		System.setProperty("webdriver.gecko.driver", ".\\Browsers\\geckodriver.exe");
			
		if (broname.equalsIgnoreCase("Firefox"))		
				driver= new FirefoxDriver();
			else {
				driver= new ChromeDriver();
				
			}
			
			driver.get(url);
	
		}

}

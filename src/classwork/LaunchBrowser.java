package classwork;


	import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

	public class LaunchBrowser {

		
		public static void main(String[] args) throws IOException {
			WebDriver driver;
			String browser= "chrome";
			//String browser= "gecko";
			
			
					
			System.setProperty("webdriver.chrome.driver", ".\\Browsers\\chromedriver.exe");
			System.setProperty("webdriver.edge.driver", ".\\Browsers/edgedriver.exe");
			System.setProperty("webdriver.gecko.driver", ".\\Browsers\\geckodriver.exe");
			
			
			if (browser.equalsIgnoreCase("Chrome")){
			
				driver = new ChromeDriver();
			
			}else 
			
				driver = new  FirefoxDriver();
		
			
			driver.get("https://www.google.com/");
			String url=driver.getCurrentUrl();
			
			String title=driver.getTitle();
			int obj=driver.hashCode();
			System.out.println(url);
			
			System.out.println(title);
			System.out.println(obj);
			
			String source=driver.getPageSource();
			FileWriter outstream=null;
			try{
			
			 outstream = new FileWriter("pagesource.html");
			 outstream.write(source);
			} finally
			{
				
				if(outstream != null){
					outstream.close();
					
				
			}
				
			System.out.println("page source file creaated"); 
			
			driver.close();
	}

			
	
		}
	}


			
			//System.setProperty("webdriver.Chrome.driver", "C:\\Software\\DriverExe\\chromedriver.exe");
			//System.setProperty("webdriver.edge.driver", "C:\\Software\\DriverExe\\msedgedriver.exe");
			//System.setProperty("webdriver.gecko.driver","C:\\Software\\DriverExe\\geckodriver.exe");
			
			
			//System.setProperty("webdriver.edge.driver", "C:\\srinivas\\driverexe\\msedgedriver.exe");
			
			// driver = new ChromeDriver();

			// driver = new  FirefoxDriver();
			//WebDriver driver = new  EdgeDriver();
		
			//driver.get("https://www.google.com/");
			
			
			
			

package myexercise.captureimage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class CaptureLogoImage {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",".\\Browsers\\chromedriver.exe" );
		WebDriver driver= new ChromeDriver();
		
		//WebDriver driver= new ChromeDriver();
		//System.setProperty("webdriver.chrome.driver","C:\\srinivas\\DriverExe\\chromedriver.exe" );
		driver.get("https://www.ebay.com/");
		Thread.sleep(2000);
		WebElement logoImage = driver.findElement(By.xpath("//a[@id='gh-la']"));
		Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, logoImage);
		ImageIO.write(logoImageScreenshot.getImage(),"png",new File("C://srinivas//logoImageEbay.png"));
		File f= new File("C://srinivas//SeleniumJava//logoImageEbay.png");
		if (f.exists()){
			System.out.println("File existed");
			}
			else
			{
				System.out.println("File not existed");
			}
			
				driver.close();
			}
				
			
	}



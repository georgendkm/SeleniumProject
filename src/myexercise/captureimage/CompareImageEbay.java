package myexercise.captureimage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class CompareImageEbay {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",".\\Browsers\\chromedriver.exe" );
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.ebay.com/");
		
		
		BufferedImage expectedImage = ImageIO.read(new File("C://srinivas//logoImageEbay.png")); // reading the captured image in web element
		
		WebElement logoImageElment = driver.findElement(By.xpath("//a[@id='gh-la']"));// getting xpath of actual Image 
		
		Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, logoImageElment);// from webelement to screenshot
		BufferedImage actualImage = logoImageScreenshot.getImage();		//from screenshot to actual image
		
		
		ImageDiffer imgDiff= new ImageDiffer();
		ImageDiff diff= imgDiff.makeDiff(expectedImage, actualImage );
		
		if(diff.hasDiff() == true){
			System.out.println("images are not same");
		}
		else
		{
			System.out.println("images are same");
			
		}
		
		driver.quit();
	}
	

}

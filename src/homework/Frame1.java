package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import myexercise.BaseDriver;

public class Frame1 extends BaseDriver{

	public static void main(String[] args) throws Exception {
		Frame1 frame= new Frame1();
		launchbrowser("chrome", "https://jqueryui.com/");
		
		boolean rflag= frame.launchIframe();
		  
		if(rflag){
			System.out.println("Found the frame");
		}else
		{
			System.out.println("Frame not found");
		}
		
		
		/*driver.findElement(By.xpath("//a[text()='Button']")).click();
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='ui-button ui-corner-all ui-widget'][@type='submit']")).click();
		Thread.sleep(2000);
		System.out.println("switched to iframe");
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.close()*/;
		
	}


	public boolean launchIframe() throws Exception{
		
		driver.findElement(By.xpath("//a[text()='Button']")).click();
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		//String fpath="//body/div[@id='container']/div[@id='content-wrapper']/div[1]/div[1]/iframe[1]";
		//String framepath= "//h1[text()='Widget Buttons']";
		if(driver.findElement( By.xpath("//h1[text()='Widget Buttons']")).isDisplayed()) {

			driver.findElement(By.xpath("//input[@class='ui-button ui-corner-all ui-widget'][@type='submit']")).click();
			Thread.sleep(2000);
		}else{
			
				System.out.println("Failed to switch to frame");
				return false;
				
			}
		driver.switchTo().defaultContent(); // Switch to page
		return true;		
		
	}
}

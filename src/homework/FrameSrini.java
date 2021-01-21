package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import myexercise.BaseDriver;

public class FrameSrini extends BaseDriver {

	public static void main(String[] args) throws Exception {
	
		FrameSrini srini=new FrameSrini();
		launchbrowser("chrome", "file:///C:/Users/binds/OneDrive/Documents/srinivas%20selenium20materials/Html_link_srini/HTML/Frames.html");
		boolean rflag= srini.launchFrame();
		if(rflag){
			System.out.println("switch to frame is successful");
		}else{
			System.out.println("swithc to frame is not successful");
		}
		}
	
		
		public boolean launchFrame() throws Exception{
		
			int size= driver.findElements(By.xpath("//frame")).size();
			System.out.println("no. of frames in main:"+size);
			
			driver.switchTo().frame(0);
			String frame1="//input[@id='Frame1txt']";
			if(driver.findElement(By.xpath(frame1)).isDisplayed())
			{
				System.out.println("I am in frame 1");
				driver.findElement( By.xpath(frame1)).clear();
				driver.findElement(By.xpath(frame1)).sendKeys(" Frame1 Text ");
				Thread.sleep(2000);
			} else  {
				System.out.println("switch to frame 1 failed");
				return false;
			}
			driver.switchTo().defaultContent();
			driver.switchTo().frame("frame_b");
			String frame2="//input[@id='Frame2txt']";
			if(driver.findElement(By.xpath(frame2)).isDisplayed()){
			
				System.out.println("I am in frame 2");
				driver.findElement( By.xpath(frame2)).clear();
				driver.findElement(By.xpath(frame2)).sendKeys(" Frame2 Text ");
				Thread.sleep(2000);
			} else{
				System.out.println("switch to frame 2 failed");
				return false;
			}
		
			driver.switchTo().defaultContent();
			WebElement frame3= driver.findElement(By.xpath("//frame[@src='frame_c.html']"));
			driver.switchTo().frame(frame3);
			String f3text="//input[@id='Frame3txt']";
			if(driver.findElement(By.xpath(f3text)).isDisplayed())
			{
				System.out.println("I am in frame 3");
				driver.findElement(By.xpath(f3text)).clear();
				driver.findElement(By.xpath(f3text)).sendKeys("Frame3 Text");
				Thread.sleep(2000);
			}else{
				System.out.println("switch to frame 3 failed");
				return false;
				
			}
			driver.switchTo().defaultContent();
			return true;
		}
}

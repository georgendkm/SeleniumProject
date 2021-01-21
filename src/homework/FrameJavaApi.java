package homework;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import myexercise.BaseDriver;
/*Framset cols
 * rows
 * 
 * 
 */
public class FrameJavaApi extends BaseDriver 
{

		public static void main(String[] args) throws Exception 
		{
			FrameJavaApi frame= new FrameJavaApi();
			launchbrowser("chrome", "https://docs.oracle.com/javase/7/docs/api/");
			frame.moveToframe();
		}
		
		public void moveToframe()throws Exception{
			
		
			String f1="//frame[@name='packageListFrame']";
			String f2 = "//frame[@name='packageFrame']";
			String f3 = "//frame[@name='classFrame']";
			
			WebElement frame1= driver.findElement(By.xpath(f1));
			WebElement frame2= driver.findElement(By.xpath(f2));
			WebElement frame3= driver.findElement(By.xpath(f3));
			
			//switching to frame1
			driver.switchTo().frame(frame1);
			System.out.println("switched to frame 1");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//li/a[text()='java.applet']")).click();;
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			System.out.println("switched to main");
			
			//switching to frame 2
			driver.switchTo().frame(frame2);
			System.out.println("switched to frame 2");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//li/a[text()='Applet']")).click();;
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			System.out.println("switched to main");
			
			//switching to frame 3
			driver.switchTo().frame(frame3);
			System.out.println("switched to frame 3");
			Thread.sleep(2000);
			
			boolean tFlag=driver.findElement(By.xpath("//h2[@title='Class Applet']")).isDisplayed();
			System.out.println("expected page display status:"+tFlag);
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			System.out.println("switched to main");
			
			driver.quit();
		}
	
}			


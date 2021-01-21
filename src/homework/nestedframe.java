package homework;

import org.openqa.selenium.By;

import myexercise.BaseDriver;

public class nestedframe extends BaseDriver {

	public static void main(String[] args) throws Exception {
		
		nestedframe nestframe=new nestedframe();
		launchbrowser("chrome","file:///C:/Users/binds/OneDrive/Documents/srinivas%20selenium20materials/Html_link_srini/HTML/FramesNested.html");
		

	}
	
		public void launchNest() throws InterruptedException{
			int size=driver.findElements(By.xpath("iframe")).size();
			System.out.println("No.of frames in the main:"+size);
			Thread.sleep(2000);
			
			//switching to 1st frame
			driver.switchTo().frame(0);
			int size1=driver.findElements(By.xpath("iframe")).size();
			System.out.println("No.of frames in the main:"+size1);
			Thread.sleep(2000);
			
			//switching to 2st frame
			driver.switchTo().frame(0);
			int size2=driver.findElements(By.xpath("iframe")).size();
			System.out.println("No.of frames in the main:"+size2);
			
			//switching to 3rd frame
			driver.switchTo().frame(0);
			int size3=driver.findElements(By.xpath("iframe")).size();
			System.out.println("No.of frames in the main:"+size3);
			driver.findElement(By.xpath("//input[@name='userName']")).click();
			driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("admin");
			driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("password");
			System.out.println("entered username and password");
			Thread.sleep(2000);
			
			//switch to frame2
			driver.switchTo().frame(0);
			int size4=driver.findElements(By.xpath("iframe")).size();
			System.out.println("No.of frames in the main:"+size4);
			driver.findElement(By.xpath("//button[@name='Login']")).click();
			Thread.sleep(2000);
			
			
			//switch to main
			
			driver.switchTo().defaultContent();
			driver.close();
		
		
	}
	
	
}

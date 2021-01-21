package classwork.alerts;

import java.util.Set;

import org.openqa.selenium.By;

import myexercise.BaseDriver;

public class WindowHandling extends BaseDriver {

	public static void main(String[] args) throws Exception {
		
		WindowHandling wh= new WindowHandling();
		launchbrowser("chrome", "file:///C:/srinivas/MultiWindows.html");
		wh.handleMulti();
	}

	public void handleMulti() throws Exception{
		
		//getting window handle id
		
		String winid= driver.getWindowHandle();
		System.out.println("main window handle:"+winid);
		Thread.sleep(2000);

		String w1="//button[@id='nwindow1']";//first window
		driver.findElement(By.xpath(w1)).click();//first window
		System.out.println("clicked on first window");
		Thread.sleep(2000);
		
		Set<String> winids = driver.getWindowHandles(); //finding the no. of windows opened using Set collections
		System.out.println("windows size:"+winids.size()); 
		
		//switching to the second window
		for(String wid: winids){
			
			if(!wid.equalsIgnoreCase(winid)){
				System.out.println(wid);
				System.out.println("switching to second window");
				driver.switchTo().window(wid);
				break;
			}
			
		}
		Thread.sleep(2000);
		
		//second Window
		
		String  fd= "//button[@class='btn btn-danger']";  ////button[.='FREE DEMO']";
		String submit= "//button[@id='simpleContactSubmitButton']";
		
		driver.findElement(By.xpath(fd)).click();
		if (driver.findElement(By.xpath(submit)).isDisplayed()){
			System.out.println("found the dialog");
		}
		Thread.sleep(2000);
		driver.close();
	
		//String w2="//body/button[2][@id='nwindow1']";
		//String tab="//button[@id='nTab']";
		
		if(driver.findElement(By.xpath("//body/button[2][@id='nwindow1']")).isDisplayed()){
			System.out.println("I am in the main window");
		}
		Thread.sleep(2000);
		driver.quit();
		//String w2="//button[@id='nwindow1']";
		//String tab="//button[@id='nTab']";
	}
}

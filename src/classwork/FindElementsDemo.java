package classwork;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class FindElementsDemo extends BaseDriver{

	public static void main(String[] args) throws Exception {
		FindElementsDemo elements=new FindElementsDemo();
		launchbrowser("chrome","http://automationpractice.com/index.php"); 
		elements.getTagIn();
	}	
		
	public void  getTagIn() throws Exception {
			
			List<WebElement> inputs= driver.findElements(By.tagName("input"));
			//System.out.println("no of inputs:"+inputs.size());
			System.out.println(driver.findElements(By.tagName("input")).size());
			inputs.get(3).click();
			inputs.get(3).sendKeys("dresses");
			Thread.sleep(2000);
			driver.close();
			
		}

	}




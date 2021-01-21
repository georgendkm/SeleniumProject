package classwork.actionapi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import myexercise.BaseDriver;

public class DragDrop extends BaseDriver{

	public static void main(String[] args) throws Exception {
		DragDrop jquery= new DragDrop();
		launchbrowser("chrome", "https://jqueryui.com/droppable/");
		jquery.dragAndDrop();
	}
	
	
	public void dragAndDrop() throws Exception{
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		WebElement drag= driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop= driver.findElement(By.xpath("//div[@id='droppable']"));
		
		new Actions(driver).dragAndDrop(drag, drop).build().perform();
		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
		driver.quit();
		
	}
}

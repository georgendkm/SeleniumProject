package classwork.actionapi;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import myexercise.BaseDriver;

public class ActionsMouse extends BaseDriver {
/*
 * if you use action interface we can do multiple actions in one shot. like context click, double click etc.
 * and after the build you have to stop the line and do the perform() in next line wiht action interface method.
 * 
 * if you call the actions with new actions driver then also you can do all the actions together with perform.
 * 
 */
	public static void main(String[] args) throws Exception {
		ActionsMouse jquery= new ActionsMouse();
		launchbrowser("chrome", "https://jqueryui.com/");
		jquery.performActions();
	}

	public void performActions() throws Exception{
		Actions builder= new Actions(driver);
		
		WebElement drag=driver.findElement(By.xpath("//li/a[text()='Draggable']"));
		WebElement drop=driver.findElement(By.xpath("//li/a[text()='Droppable']"));
		WebElement resize=driver.findElement(By.xpath("//li/a[text()='Resizable']"));
		//WebElement select=driver.findElement(By.xpath("//li/a[text()='Selectable']"));
		WebElement sortableag=driver.findElement(By.xpath("//li/a[text()='Sortable']"));
		
		
		WebElement accord=driver.findElement(By.xpath("//li/a[text()='Accordion']"));
		WebElement auto=driver.findElement(By.xpath("//li/a[text()='Autocomplete']"));
		WebElement button=driver.findElement(By.xpath("//li/a[text()='Button']"));
		WebElement checkbox=driver.findElement(By.xpath("//li/a[text()='Checkboxradio']"));
		WebElement controlg=driver.findElement(By.xpath("//li/a[text()='Controlgroup']"));
		WebElement datepic=driver.findElement(By.xpath("//li/a[text()='Datepicker']"));
		WebElement dialog=driver.findElement(By.xpath("//li/a[text()='Dialog']"));
		WebElement menu=driver.findElement(By.xpath("//li/a[text()='Menu']"));
		WebElement progress=driver.findElement(By.xpath("//li/a[text()='Progressbar']"));
		WebElement selectmenu=driver.findElement(By.xpath("//li/a[text()='Selectmenu']"));
		//WebElement silder=driver.findElement(By.xpath("//li/a[text()='Slider']"));
		WebElement spinner=driver.findElement(By.xpath("//li/a[text()='Spinner']"));
		WebElement tabs=driver.findElement(By.xpath("//li/a[text()='Tabs']"));
		//WebElement tooltip=driver.findElement(By.xpath("//li/a[text()='Tooltip']"));
		
		
		Action build= builder.click(drag).build();// using action interface for draggable.
		build.perform();
		
		
		
		//new Actions(driver).click(drop).build().perform();//short cut way of doing without using action interface. directly calling the actions class here.
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		WebElement select=driver.findElement(By.xpath("//li/a[text()='Selectable']"));
		Action build2= builder.click(select).build();
		build2.perform();
		Thread.sleep(2000);
		
		driver.switchTo().frame(0);
		WebElement we2=driver.findElement(By.xpath("//li[contains(text(),'Item 1')]"));
		Action buildselect= builder.click(we2).pause(2000).contextClick().pause(2000). doubleClick().build();// contextclick, double click and pause action
		buildselect.perform();
		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
		WebElement tooltip=driver.findElement(By.xpath("//a[contains(text(),'Tooltip')]"));
		Action buildtool= builder.click(tooltip).build();
		buildtool.perform();
		Thread.sleep(2000);
		
		driver.switchTo().frame(0);
		WebElement tooltip1=driver.findElement(By.xpath("//a[contains(text(),'Tooltips')]"));
		Action buildtool1 = builder.moveToElement(tooltip1).build();
		buildtool1.perform();
		
		Action buildtool2 = builder.sendKeys(Keys.ENTER).build();// using sendkeys and keys
		buildtool2.perform();
		
		Action buildtool3 = builder.sendKeys(Keys.ENTER).sendKeys(Keys.chord(Keys.SHIFT,"b")).build();//using sendkeys with multiple using "Keys.chord".
		buildtool3.perform();
		
		Actions buildtool4 = builder.keyDown(Keys.SHIFT).sendKeys("b").keyUp(Keys.SHIFT);//using keys up and down using with shift. when you use keydown make sure to use key up alwasy
		buildtool4.perform();
		
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		
		/*********************************  Slider *************************/
		
		WebElement silder=driver.findElement(By.xpath("//li/a[text()='Slider']"));
		new Actions(driver).click(silder).build().perform();
		driver.switchTo().frame(0);
		WebElement slide= driver.findElement(By.xpath("//div/span"));
		new Actions(driver).dragAndDropBy(slide, 35, 60).build().perform();
		Thread.sleep(2000);
		driver.quit();
		
	}
		
	
}

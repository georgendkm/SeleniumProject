package myexercise.datepicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import classwork.BaseDriver;

public class JqueryDatepicker extends BaseDriver {
	
	public static void main(String [] args) throws Exception{
		JqueryDatepicker datepick= new JqueryDatepicker();
		launchbrowser("chrome", "https://jqueryui.com/datepicker/");
		datepick.pickDate();
	}
	
	public void pickDate() throws Exception{
		
		String month= "September 2021";
		String day="15";
		driver.switchTo().frame(0);
		WebElement indate=driver.findElement(By.xpath("//input[@class='hasDatepicker']"));
		indate.click();	
		Thread.sleep(2000);
		
		//  //div[@class='uitk-new-date-picker-month']/h2[.='January 2021']/following-sibling::table//button[@data-day=4]
		while(true)
		{
			String monthtext= driver.findElement(By.xpath("//body/div[@id='ui-datepicker-div']/div[1]/div[1]")).getText();
			
			if(monthtext.equals(month)){
				break;
			}else {
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
		}
		
		driver.findElement(By.xpath("//a[contains(text(),"+day+")]")).click();// parameterizing the day " +day+  "
		
		if(driver.findElement(By.xpath("//input[@class='hasDatepicker']")).isDisplayed());
		System.out.println("date displayed");
		WebElement pickdate=driver.findElement(By.xpath("//input[@class='hasDatepicker']"));
		pickdate.getText();
		System.out.println(pickdate);
		driver.close();
	}
}


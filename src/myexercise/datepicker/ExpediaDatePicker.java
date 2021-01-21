package myexercise.datepicker;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import classwork.BaseDriver;
import classwork.jsexecutor.KillProcess;

public class ExpediaDatePicker extends BaseDriver {

	public static void main(String[] args) throws Throwable {
		ExpediaDatePicker datepick=new ExpediaDatePicker();
		launchbrowser("chrome","https://www.expedia.com/");
		datepick.pickDate();
	}

	public void pickDate() throws Throwable{
		
		driver.findElement(By.xpath("//button[@id='d1-btn']")).click();  
		//"//span[@class='uitk-new-date-picker-selection-date']")).click();
		String month= "January 2021";
		String expdate="15";
		
		
		//String monthdate=driver.findElement(By.xpath("//h2[@class='uitk-new-date-picker-month-name uitk-type-medium']")).getText();
		//String mondate=driver.findElement(By.xpath("//div[@class='uitk-flex uitk-flex-justify-content-space-between uitk-new-date-picker-menu-pagination-container'][1]"));
		//System.out.println(mondate);
		//System.out.println(monthdate);
		//  -- for jan 4    //button[@data-day='4']
		
		//   //div[@class='uitk-new-date-picker-month']
		//String  caption1=driver.findElement(By.xpath("//div[@class='uitk-new-date-picker-month']")).getText();
		//System.out.println(caption1);
		
		List<WebElement>months=driver.findElements(By.xpath("//div[@class='uitk-new-date-picker-month']")); 
		System.out.println(months);	
	
		while(true){
			//div[@class='uitk-new-date-picker-month']
			//String  caption=driver.findElement(By.xpath("//caption")).getText();//expected month
			
			WebElement  caption=driver.findElement(By.xpath("//div[@class='uitk-new-date-picker-month']"));
			if(caption.equals(month)){
				break;
			}else{
				driver.findElement(By.xpath("//button[@class='uitk-button uitk-button-small uitk-flex-item uitk-button-paging'][2]")).click();
			}
		}
		
		//div[@class=datepicker-cal']//div[2]//table[1]//tbody[1]//tr//td//button[1]"));//customize the xpath for whole month
		//div[@class='uitk-new-date-picker-month']/h2[.='January 2021']/following-sibling::table//button[@data-day=4]
		//customize the xpath for whole month
		
		List<WebElement>allDates=driver.findElements(By.xpath("//div[@class='uitk-new-date-picker-month']/h2[.='January 2021']/following-sibling::table//button[@class='uitk-new-date-picker-day']"));
		System.out.println(allDates);	
	
		for (WebElement element : allDates) {
			System.out.println(element.getText());// this will give month and date
			String date_text=element.getText();
			String date[]=date_text.split("\n"); //splitting into two elements
			
			if(date[1].equals(expdate)){
				element.click();//from the date array getting the second element like date using date[1]
				break;
			}
			
		}
		
		KillProcess.killDrivers();
		
	}
}

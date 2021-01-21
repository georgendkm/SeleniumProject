package classwork.actionapi;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import classwork.BaseDriver;

public class CheckboxRadioJquery extends BaseDriver{

	public static void main(String[] args) throws Exception {
		CheckboxRadioJquery checkradio= new CheckboxRadioJquery();
		launchbrowser("chrome", "https://jqueryui.com/checkboxradio/");
		checkradio.selectRadio();
	}

	public void selectRadio() throws Exception 
	{
		
		Actions act= new Actions(driver);
		
		//String location="//legend[text()='Select a Location: ']";
		
		String ny="//input[@id='radio-1']";
		String pa="//input[@id='radio-2']";
		String lo="//input[@id='radio-3']";
		
		String rating="//legend[contains(text(),'Hotel Ratings:')]";
		
		String star2="//input[@id='checkbox-1']";
		String star3="//input[@id='checkbox-2']";
		String star4="//input[@id='checkbox-3']";
		String star5="//input[@id='checkbox-4']";
		
		String bedtype="//legend[contains(text(),'Bed Type:')]";
		
		String dub2="//input[@id='checkbox-nested-1']";  
		String que2="//input[@id='checkbox-nested-2']";
		String que1="//input[@id='checkbox-nested-3']";
		String kng1="//input[@id='checkbox-nested-4']";
		
		driver.switchTo().frame(0);
		System.out.println("i am inside the frame");
		Thread.sleep(3000);
		
		//WebElement loc=driver.findElement(By.xpath(location));
		WebElement nyc=driver.findElement(By.xpath("//body/div[1]/fieldset[1]/label[1]/span[1]"));
		nyc.click();
		String nyc1=driver.findElement(By.xpath("//body/div[1]/fieldset[1]/label[1]/span[1]")).getText();
		System.out.println(nyc1);
		System.out.println("Radiobuttion New York is selected:"+ nyc.isSelected());
		
		WebElement pas=driver.findElement(By.xpath("//body[1]/div[1]/fieldset[1]/label[2]/span[1]"));
		pas.click();
		System.out.println("Radiobutton Paris is selected:"+ pas.isSelected());
		
		WebElement lon=driver.findElement(By.xpath("//body/div[1]/fieldset[1]/label[2]/span[2]"));
		lon.click();
		System.out.println("Radiobutton London is selected:"+ lon.isSelected());
		
		
		List list = driver.findElements(By.name("radioButton"));

		List<WebElement> location = driver.findElements(By.xpath("//input[@type='radio']"));
		System.out.println("Number of check boxes presents are: " +location.size());
		
		String loc="New York";
		//String par="paris";
		//String lonn="London";
		

		for(int i=0; i< location.size(); i++)   {
		   if(location.get(i).getAttribute("text").equalsIgnoreCase(loc)) {
			   location.get(i).click();
			   System.out.println("New York is selected");
			   Thread.sleep(2000);
		   }
		   } 
		   Thread.sleep(2000);
		  driver.close();
		  }
	}

		
		
/*		if(location.equals(loc)){
			location.get(0).click();
			System.out.println("Location New York is selected");
					  
			}else if(location.equals(par)){
						
				location.get(1).click();
			  System.out.println("Paris is selected");	
					
			 }else if(location.equals(lonn)){
				 location.get(2).click();
				System.out.println("London is selected");
				Thread.sleep(3000);
			}
			
	
		driver.close();
	
	}

}
	


	
	
	
		//List list = driver.findElements(By.name("radioButton"));

/*		List<WebElement> location = driver.findElements(By.xpath("//input[@type='radio']"));
		System.out.println("Number of check boxes presents are: " +location.size());
	 
		if(location.equals(loc)){
			  location.get(0).click();
			  System.out.println("Location New York is selected");
			  
		 }else if(location.equals(pas)){
				
			  location.get(1).click();
			  System.out.println("Paris is selected");	
			
		 }else if(location.equals(lon)){
				
				  location.get(2).click();
				  System.out.println("London is selected");
				  Thread.sleep(3000);
			}
	}
}
		for(int i=0; i< location.size(); i++)   {
		   if(location.get(i).getAttribute("text").equalsIgnoreCase(loc)) {
			   location.get(i).click();
			   System.out.println("New York is selected");
			   Thread.sleep(2000);
		   }
		   } 
		   Thread.sleep(2000);
		  driver.close();
		  }
	}

*/	  

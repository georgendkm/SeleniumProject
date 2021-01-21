package classwork;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MultiSelect {

	public static void main(String[] args) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", ".\\browsers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/binds/OneDrive/Documents/srinivas%20selenium20materials/SelectDropdowns.html");
		
		MultiSelect multi = new MultiSelect();
		//multi.launchbrowser("chrome", "file:///C:/Users/binds/OneDrive/Documents/srinivas%20selenium20materials/SelectDropdowns.html");
		
		String multiXpath = "//select[@name='cars']";
		
		Select multiselect= new Select(driver.findElement(By.xpath(multiXpath)));
		
		multiselect.selectByIndex(0);
		Thread.sleep(2000);
		multiselect.selectByValue("Audi");
		Thread.sleep(2000);
		multiselect.selectByVisibleText("Honda");
		Thread.sleep(2000);
		
		List<WebElement> options= multiselect.getAllSelectedOptions();
		for (WebElement  element : options) {
			System.out.println(element.getAttribute("value"));
			
		}
		
		/*String hMyWindow = driver.getWindowHandle();
		WebDriver popup = null;
		Iterator<String> hWindows = driver.getWindowHandles();
		while(hWindows.hasNext()) { 
		 String hWindow = hWindows.next(); 
		 popup = driver.switchTo().window(hWindow);
		 if (popup.getTitle().equals("HandlingMultipleWindows") {
		 break;
		 }
		}*/
		
		/*String multiXpath = "select[@name='cars']";		
				//"//ol[@id='selectable']";
		
		MultiSelect multi = new MultiSelect();
		multi.launchbrowser("chrome", "https://jqueryui.com/selectable/");
		
		
		Select multiple = new Select(driver.findElement(By.xpath(multiXpath)));
		
		multiple.selectByVisibleText("Item 1");
		Thread.sleep(2000);
		multiple.selectByIndex(2);
		Thread.sleep(2000);
		//multi.selectByValue("Audi");
		//Thread.sleep(2000);*/
		
		
	
		
	}
}


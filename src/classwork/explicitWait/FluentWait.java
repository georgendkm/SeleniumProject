package classwork.explicitWait;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import classwork.BaseDriver;

public class FluentWait extends BaseDriver {
public FluentWait(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}

	//here you are waiting for the particular elemnt to visible and here you can give the control time to do the polling. 
//giving your own polling time. here  you can ignore the exceptions before the timeout. here it comes timeout exception
//because we are ignoring the other exceptions.
	public static void main(String[] args) throws Exception {
		FluentWait obj= new FluentWait(driver);
		launchbrowser("chrome", "http://automationpractice.com/index.php");
		obj.fluentWait(xpath, timeout, polltime);
		
	}

	public WebElement fluentWait(String xpath, int timeout, int polltime){
		Wait wait= ((Object) new FluentWait(driver))
					.withTimeOut(Duration.ofSeconds(timeout))
					.pollingEvery(Duration.ofMillis(polltime)
					.ignoring(Exception.class));
		
		//WebElement webele= driver.findElement(By.xpath(xpath));
		 //here wait is an interface with one method of function so its called functional interface
		// and using two paraments like driver and webelment.
		// in Functional interface we can create the method inside the interface itself using new Function with parameters
		// its return type is web element.
		// only one method "apply" so no need for other class to implement the method.
		//its java 8 lambda conepts.
		
		WebElement ele= (WebElement)wait.until(new Function<WebDriver, WebElement>(){
				public WebElement apply(WebDriver,driver){
				WebElment elemnt= driver.findElement(By.xpath(xpath));
				return element;
			}
		});
				
	
		return ele;
	}
}

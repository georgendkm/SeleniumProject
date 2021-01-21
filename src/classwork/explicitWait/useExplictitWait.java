package classwork.explicitWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import classwork.BaseDriver;

public class useExplictitWait extends BaseDriver {

	public static void main(String[] args) throws Exception {
		useExplictitWait obj= new useExplictitWait();
		launchbrowser("chrome", "http://automationpractice.com/index.php");
		obj.webWait();
		
	}
	
	
	public void webWait(){
		String logo= "//img[@class='logo img-responsive']";
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(logo))));
		myWebWaitClick(logo, 45);
		
		String cart= "//a/b[.='Cart']/following-sibling::span[.='1']";
		WebDriverWait wait1= new WebDriverWait(driver,45);//using different type units then you need to create one more wiat conditions
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(cart)));//here this clickable is looking for locator not 
			//webelment so we can give the locators without driver.findelsments
		
	}
	
	
	 //this method is for reusable for all classes. you just need to pass the parameters based on the requirements.
	public void myWebWaitClick(String xpath, int timeout){
		WebDriverWait wait= new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
	
	}

}

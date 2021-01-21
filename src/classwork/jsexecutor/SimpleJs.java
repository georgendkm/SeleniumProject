package classwork.jsexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import classwork.BaseDriver;

public class SimpleJs extends BaseDriver{

	public static void main(String[] args) throws Exception {
		SimpleJs js= new SimpleJs();
		launchbrowser("chrome","http://automationpractice.com/index.php");
		js.launchJS();
		
	}

	public void launchJS() throws Exception{
		JavascriptExecutor js=(JavascriptExecutor)driver;// creating an object for javascriptexecutor. here driver is an interface so we are typecasting the driver to javascript.
		WebElement search= driver.findElement(By.xpath("//input[@name='search_query']"));
		js.executeScript("arguments[0].value ='T-Shirts';", search);  //***giving inuput values "arguments[0].value= value
		Thread.sleep(2000);
		
		WebElement searchbtn= driver.findElement(By.xpath("//button[@name='submit_search']"));
		js.executeScript("arguments[0].click();", searchbtn);//click
		Thread.sleep(2000);
		
		WebElement gettxt= driver.findElement(By.xpath("//h1/span"));
		js.executeScript("return arguments[0].text;", gettxt);  //***for getting text entered--"return arugments[0].text"
		Thread.sleep(2000);
		
		String purl= (String) js.executeScript("return document.URL;"); // getting  url and converting to string format
		System.out.println("page title is:	"+purl);
		Thread.sleep(2000);
		
		String ptitle= (String) js.executeScript("return document.title;"); //**** getting title
		System.out.println("Page title:	"+ptitle);
		Thread.sleep(2000);
	
		
		
		//navigationt to different site
		
		js.executeScript("window.location ='https://www.selenium.dev/'");
		
		js.executeScript("window.scrollBy(0,700)");    //***8 scrolling to particular point
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");  //scrolling to all the way down
		Thread.sleep(2000);
		
		WebElement header= driver.findElement(By.xpath("//a[@class='headerLink']"));//scrolling back to the headerimage view
		js.executeScript("arguments[0].scrollIntoView();", header);
		Thread.sleep(2000);
		
		
		driver.close();
	
	}
}

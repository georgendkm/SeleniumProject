package classwork.alerts;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import classwork.BaseDriver;


public class MonikaCode extends BaseDriver {

	public static void main(String[] args) throws Exception {
		MonikaCode winodws = new MonikaCode();
		launchbrowser("chrome", "https://www.h2kinfosys.com/");
		
		winodws.WindowHandle();
	}
	public void WindowHandle() throws InterruptedException{

	String winid=driver.getWindowHandle();
	//System.out.println("window handle:"+ winid);

	String bt1= "button#nwindow1:nth-of-type(1)";
	driver.findElement(By.cssSelector(bt1)).click();
	System.out.println("New win1 got opened");
	Thread.sleep(2000);

	Set<String> winids = driver.getWindowHandles();// display how many windows are opened in the session
	System.out.println("Total windows opened"+winids.size());

	for(String wid : winids)
	{

	if (!winid.equalsIgnoreCase(winid))
	{
	System.out.println("swithing to 2 window ");
	driver.switchTo().window(wid);
	break;
	}

	String about ="//a[contains(text(),'About US')]";
	driver.findElement(By.xpath(about)).click();

	Thread.sleep(5000);
	    String bt2= "button#nwindow1:nth-of-type(2)";
	    driver.findElement(By.cssSelector(bt2)).click();
	System.out.println("Window 2 opened");

	Thread.sleep(3000);   
	String tab=  "#nTab";
	driver.findElement(By.cssSelector(tab)).click();
	System.out.println("Thrid tab opened");


	driver.quit();

	}
	}
	}

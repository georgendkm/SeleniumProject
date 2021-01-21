package classwork.alerts;


import org.openqa.selenium.By;

import myexercise.BaseDriver;
/* alert.dimiss()
 * alert.cancel
 * alert.accept
 * getText()
 *sendkeys(string "bindu")
 */
public class HandleAlerts extends BaseDriver {
	
	public static void main(String[] args) throws Exception {

	HandleAlerts obj= new HandleAlerts();
	launchbrowser("chrome", "file:///C:/Users/binds/OneDrive/Documents/srinivas%20selenium20materials/Alert.html");
	obj.handleAlert();
}

	public void handleAlert() throws Exception  {
		
	String b1="//button[@name='btnAlert']";
	String b2="//button[@name='btnConfirm']";
	String b3="//button[@name='btnPrompt']";
		
	//handling first simple alert
	driver.findElement(By.xpath(b1)).click();
	Thread.sleep(2000);
	String mssg1=driver.switchTo().alert().getText();
	System.out.println("Message Displayed:"+mssg1);
	driver.switchTo().alert().accept();
	Thread.sleep(2000);
	System.out.println("accepted the alert");
	
	//handling first confirmation alert
	driver.findElement(By.xpath(b2)).click();
	Thread.sleep(2000);
	String mssg2=driver.switchTo().alert().getText();
	System.out.println("Message Displayed:"+mssg2);
	driver.switchTo().alert().accept();
	Thread.sleep(2000);
	System.out.println("accepted the confirmation alert");
	

	//handling first confirmation dismiss alert
	driver.findElement(By.xpath(b2)).click();
	Thread.sleep(2000);
	driver.switchTo().alert().dismiss();
	Thread.sleep(2000);
	System.out.println("Dismissed  the confirmation alert");
	
	
	//handling prompt alert accepted
	driver.findElement(By.xpath(b3)).click();
	Thread.sleep(2000);
	String mssg3=driver.switchTo().alert().getText();
	System.out.println("Message Displayed:"+mssg3);
	driver.switchTo().alert().sendKeys("Make Heaven");
	driver.switchTo().alert().accept();
	String msg5="//p[contains(text(), 'Srinivas')]";
	if(msg5.equalsIgnoreCase("make Heaven")){ 
			
		System.out.println("Correct prompt displayed");
	} else {
		System.out.println("prompt didnt change");
	}
	Thread.sleep(2000);
	System.out.println("Accepted the prompt alerts");
	
	//prompt alert dismissed
	driver.findElement(By.xpath(b3)).click();
	Thread.sleep(2000);
	String mssg4=driver.switchTo().alert().getText();
	System.out.println("Message Displayed:"+mssg4);
	
	driver.switchTo().alert().dismiss();
	Thread.sleep(2000);
	System.out.println("dismissed the prompt alerts");

	
	driver.quit();
}
}
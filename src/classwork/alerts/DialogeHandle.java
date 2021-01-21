package classwork.alerts;

import org.openqa.selenium.By;

import myexercise.BaseDriver;

public class DialogeHandle extends BaseDriver {

	public static void main(String[] args) throws Exception {

		DialogeHandle obj= new DialogeHandle();
		launchbrowser("chrome", "file:///C:/srinivas/Dialog.html");
		obj.handleDialoge();
	}

	public void handleDialoge() throws Exception {
		String login="//button[@id='myBtn']";
		String usname="//input[@id='username']";
		String pwd="//input[@id='pwd']";
		String logIn="//button[@name='Login']";
		
		driver.findElement(By.xpath(login)).click();
		Thread.sleep(2000);
		
		if(driver.findElement(By.xpath(usname)).isEnabled()){
			System.out.println("Dialog found");
		} else {
			throw new Exception("dialog not found");
		}
		driver.findElement(By.xpath(usname)).sendKeys("admin");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(pwd)).sendKeys("admin");
		Thread.sleep(2000);
		driver.findElement(By.xpath(logIn)).click();
		Thread.sleep(2000);
		
		driver.quit();
		
		
		
	}
}

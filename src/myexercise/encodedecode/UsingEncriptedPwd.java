package myexercise.encodedecode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingEncriptedPwd {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Browers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.findElement(By.xpath("//button[@id='gh-shop-a']")).click();
		
	}

}

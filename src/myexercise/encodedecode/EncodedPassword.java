package myexercise.encodedecode;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;

public class EncodedPassword extends BaseDriver {

	public static void main(String[] args) throws Exception {
		EncodedPassword encode= new EncodedPassword();
		launchbrowser("chrome", "http://demo.guru99.com/test/newtours/login.php");
		encode.usingEncode();
	}

	public void usingEncode(){
		driver.findElement(By.xpath("//input[@name='userName']")).click();
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("bing20");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(decodeString("Zm9ydGVzdDIw"));//calling the decoded method
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.close();
	}
	static String decodeString(String password){
		
		byte[] decodedPwd= Base64.decodeBase64(password);
		return(new String(decodedPwd));
		
	}
}

	

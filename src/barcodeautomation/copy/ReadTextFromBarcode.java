package barcodeautomation.copy;

import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;



public class ReadTextFromBarcode {

	public static void main(String[] args) {
		System.setProperty("driver.gecko.driver","C:\\srinivas\\DriverExe\\geckodriver.exe" );
		WebDriver driver= new ChromeDriver();
		//WebDriver driver= new FirefoxDriver();
		
		driver.get("https://www.codereadr.com/demo/");
		//finding the xpath for barcode
		String barcodeURL= driver.findElement(By.).getAttribute("src");
		System.out.println("print url");
		
		//pass it to new url in url mode
	
		URL url=new URL(barcodeURL); //pass it to new url in url mode
		
		BufferedImage bufferedimage=ImageIO.read(url); //zxing api 
		
		
		LuminanceSource luminanceSource= new BufferedImageLuminanceSource(bufferedimage); //import from zxing package
		
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
		
		Result result=new MultiFormatReader().decode(binaryBitmap);//decode the binarybitmap import form com.google.zxing, reult is an object
		
		System.out.println(result.getText());
		
	
		
	}
}

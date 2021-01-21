package classwork.jsexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;

import classwork.BaseDriver;

public class PointRectDim extends BaseDriver {

	public static void main(String[] args) throws Throwable {
		PointRectDim prd= new PointRectDim();
		launchbrowser("chrome", "http://automationpractice.com/index.php");
		prd.pointDemo();
	}

	public void pointDemo() throws Throwable{
		WebElement logo= driver.findElement(By.xpath("//img[@class='logo img-responsive']"));
		Point obj= logo.getLocation(); //getting the current location of this object in the particular page. and point is a class
		System.out.println("point X:"+ obj.getX());
		System.out.println("point Y:"+ obj.getY());
		System.out.println(obj);
		
		Dimension dim=logo.getSize();
		System.out.println("Dimentsion of Height:"+dim.height); //dimenson(size of the webelment
		System.out.println("Dimentsion of Width:"+dim.width);
		System.out.println(dim);
		
		Rectangle rect= logo.getRect(); //if you use rectangle will get point and dimension values together.
		System.out.println("Rectangle of Height:"+rect.height); // the whole size of the web element
		System.out.println("Rectangle of Width:"+rect.width);
		
		System.out.println("Rectangle of Height:"+rect.x);
		System.out.println("Rectangle of Height:"+rect.y);
		
		System.out.println("Rectangle of Height:"+rect.getX());
		System.out.println("Rectangle of Height:"+rect.getY());
		System.out.println(rect);
		KillProcess.killDrivers(); // killing all the drivers and browsers open in the system.
	}
}

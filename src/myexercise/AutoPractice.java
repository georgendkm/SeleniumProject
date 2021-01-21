package myexercise;

import org.openqa.selenium.By;

public class AutoPractice extends BaseDriver{

	public static void main(String[] args) throws Exception {
		
		AutoPractice esc = new AutoPractice();
		esc.launchbrowser("chrome", "http://automationpractice.com/index.php");
		
		esc.signIn();
}
	public void signIn() throws Exception{
		driver.findElement(By.cssSelector("a.login")).click(); //using class
		driver.findElement(By.cssSelector("input#email_create")).click();  //using id
		driver.findElement(By.cssSelector("input#email_create")).sendKeys("test@test2020.com");
		Thread.sleep(3000);

		//driver.findElement(By.cssSelector("div>button>span")).click();//using inheritance
				
		driver.findElement(By.cssSelector("i.icon-user")).click();   //using class name
		Thread.sleep(1000);
		//driver.findElement(By.cssSelector("input[value='Create an account'][name='SubmitCreate']")).click();  //using attribute
		//Thread.sleep(1000);
		//driver.findElement(By.cssSelector("button#SubmitCreate[type='submit']").click();  //using id and attribute
		//driver.findElement(By.cssSelector("input#id_gender1")).click();
		
		driver.findElement(By.cssSelector("input#customer_firstname")).click();
		driver.findElement(By.cssSelector("input#customer_firstname")).sendKeys("Donald");   
		driver.findElement(By.cssSelector("input[name$=lastname]")).sendKeys("Duck");  //using sufix attribute by "$"
		driver.findElement(By.cssSelector("input[type=password]")).sendKeys("amAtoy");
		driver.findElement(By.cssSelector("select#days[value= 6")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("select#months[value=11]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("select#years[value=2020]")).click();
		Thread.sleep(1000);
		
		
		
		
		
		
		
		driver.close();
	}
}

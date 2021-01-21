package classwork;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


/* getting values from mouse hover class and printing*/

public class ActiMindSelect {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", ".\\browsers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.actimind.com/");
		//driver.get("https://jqueryui.com/");
		
		ActiMindSelect acti=new ActiMindSelect();
		acti.jquiery();
	
		
		Actions hoover= new Actions(driver);
		WebElement mouse= driver.findElement(By.xpath("//a[@class='c-link dropdown-toggle']"));
		hoover.moveToElement(mouse).build().perform();
		
		WebElement drop= driver.findElement(By.xpath("//ul[@class='dropdown-menu c-menu-type-inline']"));

		Set<String> dropdown = new HashSet<String>();
		Iterator<String> it = dropdown.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + "\t");
		}
		System.out.println();
		
		//hs.clear();	
		System.out.println(dropdown);
	}
	
		public void jquiery() throws Exception{
			System.setProperty("webdrive.chrome.driver", ".\\browsers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			

			//WebElement mouse= driver.findElement(By.xpath("//li[@class='dropdown']"));
			WebElement mouse= driver.findElement(By.xpath("//li[@class='dropdown']"));
			Thread.sleep(3000);
			Actions hoover= new Actions(driver);
			hoover.moveToElement(mouse).build().perform();

			

			Set<String> mouse1= new HashSet<String>();
			Iterator<String> it = dropdown.iterator();
			while(it.hasNext()) {
				System.out.print(it.next() + "\t");
			}
			System.out.println();

			//hs.clear();	
			System.out.println(dropdown);
			
			}

			

		}
	



		/*public List<String> getAllValues() throws InterruptedException
		 {
			WebElement mouse= driver.
			Action action = new Action(driver.findelement(byxpath"));
			action
			by.
			WebElement element = driver.findElement(By.linkText("Forgot account?"));
			Actions act = new Actions(driver);
			act.contextClick(element).build().perform();
			Thread.sleep(3000);
			driver.close();
			
			//ul[@class='dropdown-menu c-menu-type-inline']
			
		    Select sel = new Select(driver.findElement(By.xpath("Your xpath here"));
		    List<WebElement> we = sel.getOptions();
		    List<String> ls = new ArrayList<String>();
		    for(WebElement a : we)
		    {
		        if(!a.getText().equals("Select")){
		            ls.add(a.getText());
		        }
		    }
		    return ls;
		 }

}*/

package classwork.actionapi;



	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	 
	public class CheckBoxOperations {
	 
	 public static void main(String[] args) throws Exception {
	 
	 String exePath = ".\\browsers\\chromedriver.exe";
	 System.setProperty("webdriver.chrome.driver", exePath);
	 WebDriver driver = new ChromeDriver();
	 driver.get("https://www.demoqa.com/automation-practice-form");
	 driver.manage().window().maximize();
	 
	 
	 /**
	 * Validate isSelected and click
	 */
	 
	 WebElement checkBoxSelected = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
	 boolean isSelected = checkBoxSelected.isSelected();
	 
	 // performing click operation if element is not selected 
	 if(isSelected == false) {
	 checkBoxSelected.click();
	 }
	 Thread.sleep(2000);
	 /**
	 * Validate isDisplayed and click
	 */
	 WebElement checkBoxDisplayed = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
	 boolean isDisplayed = checkBoxDisplayed.isDisplayed();
	 
	 // performing click operation if element is displayed
	 if (isDisplayed == true) {
	 checkBoxDisplayed.click();
	 }
	 Thread.sleep(2000);
	 /**
	 * Validate isEnabled and click
	 */
	 WebElement checkBoxEnabled = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
	 boolean isEnabled = checkBoxEnabled.isDisplayed();
	 
	 // performing click operation if element is enabled
	 if (isEnabled == true) {
	 checkBoxEnabled.click();
	 }
	 Thread.sleep(2000);
	 }
	 
	}
package classwork;

import org.openqa.selenium.By;

public class CSSLocators extends BaseDriver{

	public static void main(String[] args) throws InterruptedException {
		CSSLocators css= new CSSLocators();
		launchbrowser("msedge", "http://automationpractice.com/index.php");
		css.cssLocators();

	}

	public void cssLocators() throws InterruptedException{
		//syntax tagname#id, 
		//tagname.class, 
		//tagname#id.class, 
		//tagname.class[attribute name=attributevalue]
		//tagname[atna=atvale][atna=atv],
		//tagname#id[attna=attva][atna=atva]
		//for attribute you have to give-[](squre bracket)
		//attribut value will work with single quotes or without quotes.
		//acessing via its parents- form>input
		
		//prefix- tagname[attirbutename^=prefix of string-input[name^='search']+++++++prefix
		//suffix- tagname[attributneme$=suffix of string- input[name$=query]++++++++++suffix
		//substsring- anywhere in the string- tagname[attrribute*=substring]++++++++++substring---dynamic attribute
		// using substring and prefix and sufix too
		// no attribut only tagname====== then use the parent or child===      parent>child----immediate parent-- div>form>button-grand>parant>child
		//siblings----form>input+input+input+input-----finding the 4th input going through the siblings--navigating between siblings.
		//form>input:nth child[4]=====finding the 4th child directly from the parent.
		
		
		// you cannot find teh css using "TEXT"
		
		
		
		driver.findElement(By.cssSelector("input#search_query_top")).sendKeys("casual dresses");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.btn")).click();
		Thread.sleep(2000);
		driver.close();
	}
}

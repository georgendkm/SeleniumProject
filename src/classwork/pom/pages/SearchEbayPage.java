package classwork.pom.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchEbayPage {
	private static final String InvocationTargetException = null;

	public WebDriver driver;
	
	public SearchPage(WebDriver d) {
		driver=d;  
	} // here in constructor driver as a parameter. this will called by the test to run the tests
	
	
	//************************************************* 	 WebElements           **************************************************************//
	
	// By search= by xpath (")   //--using By class method too.
	
	@FindBy(xpath="//input[@id='gh-ac']") // @FindBy annotation is using instead of findelments to find each elements in the page
	WebElement searchInput;
	
	@FindBy(xpath="//select[@id='gh-cat']") 
	List<WebElement> searchCategory;
	
	@FindBy(xpath="//input[@id='gh-btn']") WebElement searchSubmit;
	@FindBy(xpath="//ul//div[@class='s-item__wrapper clearfix']") List<WebElement> searchResults;
	@FindBy(xpath="//ul//div[@class='s-item__wrapper clearfix']//div//img[@alt='Agave victoria regineae variegated (white Rhino)']") WebElement whiteRhino1;
	@FindBy(xpath="//a[@id='binBtn_btn']") WebElement buyItNow;
	@FindBy(xpath="//a[@id='atcRedesignId_btn']") WebElement addToCart;
	@FindBy(xpath="//a[@id='vi-viewInCartBtn']") WebElement viewCart;
	@FindBy(xpath="//span[text()='Add to Watchlist']") WebElement addToWishList;
	
//***************************************************     page actions as methods     ******************************************************//	
	
	/**
	 * searching items
	 * @param searchinput
	 * @return true if successful
	 */
	public boolean verifySearch(String searchinput) {
		if(!searchInput.isEnabled()) {
			System.out.println("Search box is not enabled");
			return false;
		}
		searchInput.sendKeys(searchinput);
		searchSubmit.click();
		System.out.println("Search items entered:");
		return true;
			
		}
	
	/**
	 * method to verify search results
	 * @return verufied if successful otherwise false message return
	 */
	public String verifySearchResults() {
		
		int rsize= searchResults.size();
		if(rsize>0) {
			System.out.println("search items displayed");
		} else {
			//System.out.println("No matching items displayed");
			return "results not displayed";
		}
		return "";
	}
	//before method name was searchitems
	public boolean searchResults() {
		if(!searchResults.isEmpty()) {
			for (WebElement items : searchResults) {
				System.out.println(items);
				return true;
			} 
			
			searchResults.get(1).click();
			searchResults.get(2).click();
		//searchResults.add(1, searchInput);
		//searchResults.add(2, searchInput);
		
		
		} else {
			

			System.out.println("No items added");
			return false;
		}
		return false;
	}
	
	public void addToCart() {
		addToCart.click();
		
	}
}



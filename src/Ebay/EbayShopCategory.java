package Ebay;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import myexercise.BaseDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class EbayShopCategory extends BaseDriver {

	public static void main(String[] args) throws Exception {
		
		EbayShopCategory esc = new EbayShopCategory();
		esc.launchbrowser("chrome", "https://www.ebay.com/");

	}
	
	public void selectcategory() throws IOException{
		
	String shopbycat= "//button[@id='gh-shop-a']";
	
	//first columns in shopby caterfory
	String colletctablesandart="//a[text()='Collectibles & art']";// collectables category
	
	
	//String collecttables= "//tbody/tr[1]/td[1]/h3[1]/a[1]";
	
	//1. coulmns collectables and art
	
	String collectibles="//a[(text()= 'Collectibles')]";
	
	// dynamic way of writing xpath for  text
	String dynamicforCollectandart ="//a[(text()= 'dyntext')]";
	String coll= dynamicforCollectandart.replace("dyntext", "collectibles");
	String coins= dynamicforCollectandart.replace("dyntext", "Coins & paper money");
	String antiques= dynamicforCollectandart.replace("dyntext", "Antiques");
	String sports= dynamicforCollectandart.replace("dyntext", "Sports memorabilia");
	
	
	
	
	
	
	
	
	
	String Electronics= "//tbody/tr[1]/td[1]/h3[1]/a[2]";
	//2. Elcectroins dynamic way
	String computantab="//a[contains(text(),'Computers & tablets')]";
	
	String dynamicelectronic= "//a[contains(text(),'dynelec')]";
	String comtab= dynamicelectronic.replace("dynelec", "Computers & tablets");
	String comeras= dynamicelectronic.replace("dynelec", "Cameras & photo");
	String tvsurveil= dynamicelectronic.replace("dynelec", "TV, audio & surveillance");
	String cellph= dynamicelectronic.replace("dynelec", "Cell phones & accessories");
	
	
	
	String Entertainments= "//tbody/tr[1]/td[1]/h3[1]/a[3]";
	
	String dynenter="//a[contains(text(),'dynenter']";
	String vidgame=dynenter.replace("dynenter", "Video games & consoles");
	String music=dynenter.replace("dynenter", "Music");
	String dvd=dynenter.replace("dynenter", "DVDs & movies");
	String tickets=dynenter.replace("dynenter", "Tickets & experiences");
	
	
	//search button
	String search="//input[@class='gh-tb ui-autocomplete-input']";
	String allcategory="//select[@id='gh-cat']";
	
	String String;
	String dynsearch= "//option[contains(text(),'dynitems')]";
	String antiques1=dynsearch.replace("dynitems", "Antiques");	
	String art=dynsearch.replace("dynitems", "Art");	
	String baby=dynsearch.replace("dynitems", "Baby");	
	String books=dynsearch.replace("dynitems", " Books");	
	String busindu=dynsearch.replace("dynitems", " Business & Industrial");	
	String camphoto=dynsearch.replace("dynitems", " Cameras & Photo");	
	String cellphoacc=dynsearch.replace("dynitems", " Cell Phones & Accessories");	
	String closhoacc=dynsearch.replace("dynitems", "  Clothing, Shoes & Accessories");	
	String collect=dynsearch.replace("dynitems", "Collectibles"); 
	String comtabnet=dynsearch.replace("dynitems", "  Computers/Tablets & Networking");	
	String conelec=dynsearch.replace("dynitems", " Consumer Electronics");	
	String  Crafts=dynsearch.replace("dynitems", "  Crafts");	
	String  DollBears=dynsearch.replace("dynitems", "  Dolls & Bears");	
	String  DVDMovies=dynsearch.replace("dynitems", "  DVDs & Movies");	
	String  HomeGarden=dynsearch.replace("dynitems", "   Home & Garden");	


	
	
	
	
	
	
	//second column in shopby caterory
	String Fashion="//tbody/tr[1]/td[2]/h3[1]/a[1]";
	
	String HomeGarden1 ="//tbody/tr[1]/td[2]/h3[2]/a[1]";
	String motors="//tbody/tr[1]/td[2]/h3[3]/a[1]";
	
	//third column in shopby category
	String shoppinggoods="//tbody/tr[1]/td[3]/h3[1]/a[1]";
	String Toyshobbies="//tbody/tr[1]/td[3]/h3[2]/a[1]";
	String Othercategories="//tbody/tr[1]/td[3]/h3[3]/a[1]";
			
			
	
	
}
}

package myexercise.brokencode;

import org.openqa.selenium.By;

import com.sun.xml.bind.v2.model.core.Element;

public class BrokenCode {
//from pavan interview questions viedo 6
	public static void main(String[] args) {
		
		List<WebElement>links= driver.findelemts(By.tagName("a");
		for(int i=0; i<links.size();i++){
		
			WebElement elemnet=links.get(i);
			
		}
		
		//by using "href"attribute we could get hte url of the required link
		Strin url=Element.getAttribute("href");
		
		System.out.println(url);
		URL link= new URL(url);
		
		//create a connection using URL object (i.e,'link')
		HttpURLConnectionhttpConn=(HttpURLConnection)link openConenction();
		
		//set the timeout for 2 seconds
		httpConn.setConnectTimeout(2000);
		
		//connect using connect method
		httpConn.connect();
		
		//use getResponseCode() to get the response code
		if(httpConn.getResponseCode()>=400){
			System.out.println(url+"-"+"is BrokenLink");
		} else {
			System.out.println(url + "_"+"is validLink");
		}
		}
		
	}

}

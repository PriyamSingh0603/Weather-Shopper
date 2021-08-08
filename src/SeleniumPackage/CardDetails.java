package SeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CardDetails
{
	WebDriver drivernew  = TestDriver.getNewDiver();
	
	public String getCardDetails() 
	{
		try 
		{
			String url = "https://stripe.com/docs/testing#cards";
			drivernew.get(url);
			String cardNumber = drivernew.findElement(By.xpath("//span[@class='CardNumber']")).getText();
			drivernew.quit();
			return cardNumber;
		}
		catch (Exception e) 
		{
			System.out.println("Error Occured" + e);
			drivernew.quit();
			return "4242424242424242";
		}
	
	}
	

}

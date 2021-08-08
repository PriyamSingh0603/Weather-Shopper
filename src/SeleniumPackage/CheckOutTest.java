package SeleniumPackage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class CheckOutTest 
{
	WebDriver driver  = TestDriver.getDriver();
	CardDetails cardObj = new CardDetails();
	String cardNumberDetails = cardObj.getCardDetails();
	
	public void cartPageHandle() throws InterruptedException 
	{
		if(driver.getTitle().equals("Cart Items"))
		{
			WebElement payButton = driver.findElement(By.xpath("//button[@class = 'stripe-button-el']"));
			payButton.click();
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			WebElement iframe = driver.findElement(By.xpath("//iframe[contains(@name,'stripe_checkout_app')]"));
			driver.switchTo().frame(iframe);			
			Thread.sleep(1000);
			makePayment();	
			Thread.sleep(5000);
			boolean response = statusCheck();
			if(response)
			{
				Thread.sleep(5000);
				driver.quit();
			}
			else
			{
				driver.navigate().back();
				cartPageHandle();
			}
		}
	}
	public void makePayment() 
	{
		System.out.println("Method to make payment");
		WebElement email  = driver.findElement(By.xpath("//input[@type='email']"));
		email.sendKeys("priyamsingh@gmail.com");
		WebElement card = driver.findElement(By.xpath("//input[@placeholder='Card number']"));
		card.sendKeys(cardNumberDetails);
		WebElement expDate = driver.findElement(By.xpath("//input[@placeholder='MM / YY']"));
		expDate.sendKeys("1234");
		WebElement cvc = driver.findElement(By.xpath("//input[@placeholder='CVC']"));
		cvc.sendKeys("123");
		WebElement zipCode = driver.findElement(By.xpath("//input[@placeholder = 'ZIP Code']"));
		zipCode.sendKeys("500019");
		WebElement finalPay = driver.findElement(By.xpath("//div[@class='Section-button']/button"));
		finalPay.click();
		
	}
	public boolean statusCheck() 
	{
		WebElement status = driver.findElement(By.xpath("//h2"));
		if(status.getText().equals("PAYMENT SUCCESS"))
		{
			System.out.println("Payment is successfull");
			return true;
		}
		else
		{
			System.out.println("Payment is failed");
			return false;
		}
		
	}

	
}

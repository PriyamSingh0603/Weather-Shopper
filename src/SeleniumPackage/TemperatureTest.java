package SeleniumPackage;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.sql.Driver;

public class TemperatureTest {
	WebDriver driver =	TestDriver.getDriver();
	
	
	public  void temperatuteHandle() throws InterruptedException 
	{
			
		
				WebElement infoIcon  = driver.findElement(By.xpath("//span[@class='octicon octicon-info']"));
				infoIcon.click();
				Thread.sleep(1000);
				infoIcon.click();
				WebElement temp = driver.findElement(By.xpath("//*[@id='temperature']"));
				String[] temp1 = temp.getText().split(" ");
				int temperature = Integer.parseInt(temp1[0]);
				System.out.printf("temperature = ", temperature);
				System.out.println(driver.getTitle());
				if(temperature <19)
				{
					
					WebElement moisturizers = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/a/button"));
					moisturizers.click();
					Thread.sleep(1000);
					WebElement infoIconM = driver.findElement(By.xpath("/html/body/div[1]/div[1]/span"));
					infoIconM.click();
					Thread.sleep(1000);
					infoIconM.click();
					driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
					Thread.sleep(1000);
					driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);
//					
					
				}
				if(temperature > 34)
				{
				
					WebElement sunScreen = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/a/button"));
					sunScreen.click();
					Thread.sleep(1000);
					WebElement infoIconS = driver.findElement(By.xpath("/html/body/div[1]/div[1]/span"));
					infoIconS.click();
					Thread.sleep(1000);
					infoIconS.click();
					driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
					Thread.sleep(1000);
					driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);
					
					
							
				}
	}
}

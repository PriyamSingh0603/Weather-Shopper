package SeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Product 
{
	 String productName ;
	 int price ; 
	 WebElement button;
	public Product(String productName,int  price,WebElement button) {
		this.productName = productName;
		this.price = price;
		this.button = button;
		
	}
//	public void productList() {
//		productName = driver.findElement(By.xpath("div[contains(@class,'text-center col-4')]")).getText();
//		price  = Integer.parseInt(driver.findElement(By.xpath("//div[contains(@class,'text-center col-4')]//p[contains(text(), 'Price: ' )]")).getText().split(" ")[2]);
//		button = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
//		
//	}
}

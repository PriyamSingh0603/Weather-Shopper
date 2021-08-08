package SeleniumPackage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProductTest 
{
	WebDriver driver = TestDriver.getDriver() ;
	public void productPageHandle() throws InterruptedException 
	{
		if(driver.getTitle().equals("The Best Moisturizers in the World!"))
		{
			chooseMoiturizers();
		}
		if(driver.getTitle().equals("The Best Sunscreens in the World!"))
		{
			chooseSunscreen();
		}
		
		WebElement checkout = driver.findElement(By.xpath("//button[@onclick ='goToCart()']"));
		if(checkout != null)
		{
			checkout.click();
		}
		
	}
	private void chooseSunscreen() throws InterruptedException 
	{
		List<WebElement> proName = driver.findElements(By.xpath("//div[contains(@class,'text-center col-4')]"));
		List<WebElement> proPrice  = driver.findElements(By.xpath("//div[contains(@class,'text-center col-4')]//p[contains(text(), 'Price: ' )]"));
		List<WebElement> proButton = driver.findElements(By.xpath("//button[contains(text(),'Add')]"));
		ArrayList<String> prod_name = new ArrayList<>();
		ArrayList<Integer> prod_price = new ArrayList<>();
		ArrayList<WebElement> prod_button = new ArrayList<>();
		for (int i = 0; i<6;i++)
		{
			if(proName !=  null)
			{
				prod_name.add(proName.get(i).getText());
				String[] tempPrice = proPrice.get(i).getText().split(" ");
				prod_price.add(Integer.parseInt(tempPrice[tempPrice.length-1]));
				prod_button.add(proButton.get(i));
			}
		}
		
		ArrayList<Product> productArray = new ArrayList<>();
		for(int i = 0;i<6;i++)
		{
			productArray.add(new Product(prod_name.get(i), prod_price.get(i), prod_button.get(i)));
		}
		
		ArrayList<Product> spf30Product = new ArrayList<>();
		ArrayList<Product> spf50Product =  new ArrayList<>();
		Product spf30Min = null;
		Product spf50Min = null;
		for(int j = 0 ; j < productArray.size();j++)
		{
			if(productArray.get(j).productName.toLowerCase().contains("spf-30"))
			{
				spf30Product.add(productArray.get(j));
			}
			if(productArray.get(j).productName.toLowerCase().contains("spf-50"))
			{
				spf50Product.add(productArray.get(j));
			}
			
		}
		for (int i = 0; i<spf30Product.size(); i++)
		{
			 spf30Min = comparePrice(spf30Product.get(i), spf30Min);
		}
		for(int i =0 ; i<spf50Product.size(); i++)
		{
			 spf50Min = comparePrice(spf50Product.get(i), spf50Min);
		}
		
		Thread.sleep(1000);
		if(spf30Min != null && spf30Min.button != null )
		{
			spf30Min.button.click();
		}
		
		Thread.sleep(1000);
		spf50Min.button.click();
		
		
	}
	private void chooseMoiturizers() throws InterruptedException 
	{
		List<WebElement> proName = driver.findElements(By.xpath("//div[contains(@class,'text-center col-4')]"));
		List<WebElement> proPrice  = driver.findElements(By.xpath("//div[contains(@class,'text-center col-4')]//p[contains(text(), 'Price: ' )]"));
		List<WebElement> proButton = driver.findElements(By.xpath("//button[contains(text(),'Add')]"));
		ArrayList<String> prod_name = new ArrayList<>();
		ArrayList<Integer> prod_price = new ArrayList<>();
		ArrayList<WebElement> prod_button = new ArrayList<>();
		for (int i = 0; i<6;i++)
		{
			if(proName !=  null)
			{
				prod_name.add(proName.get(i).getText());
				String[] tempPrice = proPrice.get(i).getText().split(" ");
				prod_price.add(Integer.parseInt(tempPrice[tempPrice.length-1]));
				prod_button.add(proButton.get(i));
			}
		}
		
		ArrayList<Product> productArray = new ArrayList<>();
		for(int i = 0;i<6;i++)
		{
			productArray.add(new Product(prod_name.get(i), prod_price.get(i), prod_button.get(i)));
		}
		
		ArrayList<Product> aloeProduct = new ArrayList<>();
		ArrayList<Product> almondProduct =  new ArrayList<>();
		Product aloeMin = null;
		Product almondMin = null;
		for(int j = 0 ; j < productArray.size();j++)
		{
			if(productArray.get(j).productName.toLowerCase().contains("aloe"))
			{
				aloeProduct.add(productArray.get(j));
			}
			if(productArray.get(j).productName.toLowerCase().contains("almond"))
			{
				almondProduct.add(productArray.get(j));
			}
			
		}
		for (int i = 0; i<aloeProduct.size(); i++)
		{
			 aloeMin = comparePrice(aloeProduct.get(i), aloeMin);
		}
		for(int i =0 ; i<almondProduct.size(); i++)
		{
			 almondMin = comparePrice(almondProduct.get(i), almondMin);
		}
		
		Thread.sleep(1000);
		aloeMin.button.click();
		Thread.sleep(1000);
		almondMin.button.click();
		
		
	}

	public Product comparePrice(Product pro1, Product pro2)
	{
		if(pro1 ==  null)
		{
			return pro2;
		}
		if(pro2 == null)
		{
			return pro1;
		}
		if(pro1.price < pro2.price)
		{
			return pro1;
		}
		else
		{
			return pro2;
		}
		
	}
	
}

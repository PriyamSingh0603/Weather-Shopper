package SeleniumPackage;

import org.openqa.selenium.WebDriver;


public class AutomationMain {
	
	static WebDriver driver = TestDriver.getDriver();

	public static void main(String[] args) 
	{
		try {
			openPage();
			TemperatureTest temperatureObj = new TemperatureTest();
			temperatureObj.temperatuteHandle();
			ProductTest productObj = new ProductTest();
			productObj.productPageHandle();
			CheckOutTest cartobj = new CheckOutTest();
			cartobj.cartPageHandle();
		}
		catch (Exception e) {
			System.out.println("Error Occured" + e);
			driver.quit();
		}
		

	}
	
	public static  void openPage() throws InterruptedException 
	{
		
		String url = "https://weathershopper.pythonanywhere.com";
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(1000);
	}

	

}

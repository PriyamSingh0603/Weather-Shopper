package SeleniumPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDriver
{
	static WebDriver driver1 = null;
	private TestDriver(){};
	
	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\priya\\selenium driver\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.verboseLogging", "true");
		if(driver1 == null) {
			driver1 = new ChromeDriver();
		}
		
		return driver1;
	}
	
	public static WebDriver getNewDiver()
	{
		return new ChromeDriver();
	}
}

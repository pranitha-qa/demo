package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.base;

public class Miscellaneous{
	
	
	
	
	WebDriver driver;


	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

	
	@Test
	public void HTTPSCertifications()
	{
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("");
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
	
		
		
		
		
		
	}
}

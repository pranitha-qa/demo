package qa.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	WebDriver driver;
	
	
	
	public WebDriver openWebBrowserAndUrl(String browser)
	{
		
	if(browser.equalsIgnoreCase("chrome"))
	{
		 driver = new ChromeDriver();
		
	}
	else
		
	if(browser.equalsIgnoreCase("edge"))	
	{
		driver = new EdgeDriver();
	}
	
	else
		
    if(browser.equalsIgnoreCase("firefox"))
    {
    	driver = new FirefoxDriver();
    	
    }
	
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
	return driver;
	}
	

}

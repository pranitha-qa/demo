package testcases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.base;

public class LinksTest extends base {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = openWebBrowserAndUrl("chrome");

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

	@Test
	public void OpenLinksInNewTab() {

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		List<WebElement> links = footer.findElements(By.tagName("a"));
		System.out.println("Number of links in footer are : " + links.size()); // get no of the links in the footer
// open all links links in new tab	
		String openInNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

		for (WebElement lk : links) {
			lk.sendKeys(openInNewTab);

		}
		// check all the tabs
		Set<String> wh = driver.getWindowHandles();

		Iterator<String> it = wh.iterator();

		while (it.hasNext()) {

			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());

		}

	}

	@Test
	public void assignment() {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement checkbox = driver.findElement(By.cssSelector("label[for='benz']"));
		checkbox.click();
		String text = checkbox.getText();
		WebElement dd = driver.findElement(By.id("dropdown-class-example"));
		driver.findElement(By.id("dropdown-class-example")).click();
		Select select = new Select(dd);
		select.selectByVisibleText(text);
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("confirmbtn")).click();
		String alert = driver.switchTo().alert().getText();
		Assert.assertEquals(alert, "Hello " + text + ", Are you sure you want to confirm?");

	}
    @Test
	public void brokenLinks() throws IOException, InterruptedException {
    	// find the broken links in a page 
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		List<WebElement> links = footer.findElements(By.tagName("a"));
		System.out.println("Total no of links " + links.size());
		
		for(WebElement link: links)
		{
			String Url= link.getAttribute("href");
			
			URL lk = new URL(Url);
			
			HttpURLConnection httpcon = (HttpURLConnection) lk.openConnection();
			Thread.sleep(5000);
			httpcon.connect();
		int rescode=	httpcon.getResponseCode();
			
			if(rescode>=400)
			{
				
				System.out.println(Url + "- is a broken link");
			}
			
			else
			{
				
				System.out.println(Url + "- is not a broken link");
			}
				
		}
		
		
		
		
		
		
		
		
		

	}
}

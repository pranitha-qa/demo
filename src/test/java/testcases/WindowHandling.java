package testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.base;

public class WindowHandling extends base {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = openWebBrowserAndUrl("chrome");

	}

	// @AfterMethod
	public void tearDown() {

		driver.quit();

	}

	@Test
	public void WindowHandlingTest() {
		driver.get("https://www.maccosmetics.com/mac-lover");
		driver.findElement(By.xpath("//a[contains(text(),'PRIVACY POLICY')]")).click();

		Set<String> wh = driver.getWindowHandles();
		Iterator<String> it = wh.iterator();
		String ParentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.getTitle());
		driver.switchTo().window(ParentId);
		System.out.println(driver.getTitle());
	}
	
	

}

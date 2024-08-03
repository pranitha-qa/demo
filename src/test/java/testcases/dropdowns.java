package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.base;

public class dropdowns extends base {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = openWebBrowserAndUrl("chrome");

	}

	//@AfterMethod
	public void tearDown() {

		driver.quit();

	}

	@Test
	public void staticDropdown() throws InterruptedException {
		driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");

		WebElement address = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select dropdown = new Select(address);
		dropdown.selectByVisibleText("INR");
		Thread.sleep(2000);
		dropdown.selectByIndex(2);
		Thread.sleep(2000);
		dropdown.getFirstSelectedOption();
		driver.findElement(By.id("divpaxinfo")).click();
		List<WebElement> passengers = driver.findElements(By.className("guestlbl"));
		int count = 0;
		for (WebElement li : passengers) {
			String pass = li.getText();
			if (pass.equalsIgnoreCase("adult"))

			{
				List<WebElement> buttons = driver.findElements(By.xpath("//div[@class='ad-row-right']/span[3]"));
				for (int i = 0; i < buttons.size(); i++)
					while (count < 3) {

						buttons.get(i).click();
						count++;
					}
			}

		}

	}
	
	@Test(priority=2)
	public void AutoSuggestDropDown()
	{
	
		driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("in");
	List<WebElement> suggest =driver.findElements(By.xpath("//a[@class='ui-corner-all']"));
	
	for(int i=0; i<suggest.size(); i++)
	{
	String sug	= suggest.get(i).getText();
		if(sug.equalsIgnoreCase("india"))
		{
			suggest.get(i).click();
		}
		
	}
	System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
	}
	
	
	

}

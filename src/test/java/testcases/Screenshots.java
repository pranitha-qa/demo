package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.base;

public class Screenshots extends base {
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
	 public void takeScreenshot() throws IOException
	 {
		 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 TakesScreenshot ss = (TakesScreenshot)driver;
		 File src = ss.getScreenshotAs(OutputType.FILE);
		 File trg = new File(".\\screenshot\\homepage.png");
		
			FileUtils.copyFile(src, trg);
	 }

}

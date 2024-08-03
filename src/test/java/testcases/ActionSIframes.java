package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.base;

public class ActionSIframes extends base {

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
	public void ActionsTest() {
		driver.get("https://www.flipkart.com/");
		WebElement element = driver.findElement(By.xpath("//img[@alt='Login']"));

		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();
		a.moveToElement(driver.findElement(By.cssSelector("input[name='q']"))).click().keyDown(Keys.SHIFT)
				.sendKeys("toys").sendKeys(Keys.ENTER).perform();
		a.contextClick(driver.findElement(By.cssSelector("input[name='q']"))).build().perform();

	}

	@Test
	public void iframesDragAndDrop() {

		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		Actions act = new Actions(driver);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));

		act.dragAndDrop(drag, drop).build().perform();
		driver.switchTo().defaultContent();

	}

	@Test
	public void NestedframeExample() {
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		int size = driver.findElements(By.tagName("frame")).size();
		System.out.println("no of frames " + size);

		WebDriver dr = driver.switchTo().frame(0);
		int size2 = driver.findElements(By.tagName("frame")).size();
		System.out.println("no of frames in next frame " + size2);
		dr.switchTo().frame(1);

		String str = driver.findElement(By.id("content")).getText();
		System.out.println(str);

	}
	@Test
	public void alertsTest()
	{
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("name")).sendKeys("Ola");
		driver.findElement(By.id("alertbtn")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert().dismiss();
		driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert().dismiss();
		driver.findElement(By.id("confirmbtn")).click();
	String text	= driver.switchTo().alert().getText();
	System.out.println(text);
	}
	
}

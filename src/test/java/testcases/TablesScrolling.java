package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.base;

public class TablesScrolling extends base {

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
	public void windowScrolling() {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		// scroll the table to the top 
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		

	}
     @Test
     public void tableGrid()
     {
    	 // ADD all the values present in the 4th column of the table
     driver.get("https://rahulshettyacademy.com/AutomationPractice/");	
    List <WebElement> tab= driver.findElements(By.cssSelector("div[class='tableFixHead'] td:nth-child(4)"));
    	 int sum =0;
    	 for(WebElement tabrow: tab)
    	 {
    		int i = Integer.valueOf(tabrow.getText()); // Convert String to integer
    		 sum +=i;
    		 
    	 }
    	 System.out.println("the total of all rows in 4th col "+ sum);
    	 
    	String total= driver.findElement(By.cssSelector(".totalAmount")).getText();
    	
    	String str[] =total.split(":");
    	str[1] = str[1].trim();
    	int Expected= Integer.valueOf(str[1]);
    	
    	Assert.assertEquals(Expected, sum);
     }
     @Test
     public void tablesAssignment()
     {
    	 // print the no of rows & no of columns & contents of 3rd row in the table
    	 driver.get("https://rahulshettyacademy.com/AutomationPractice/");	
    	WebElement scope= driver.findElement(By.cssSelector("table[name='courses']"));
    int rows=scope.findElements(By.tagName("tr")).size();
    	 System.out.println("no of rows in table are: "+ rows);
   int col = scope.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size();
    	 
    	System.out.println("no of columns "+ col); 
    List<WebElement> content =scope.findElements(By.tagName("tr")).get(3).findElements(By.tagName("th"));
    for(WebElement cont : content)
    {
    	String res = cont.getText();
    	System.out.println(res);
    }
    
     }
     
     
}

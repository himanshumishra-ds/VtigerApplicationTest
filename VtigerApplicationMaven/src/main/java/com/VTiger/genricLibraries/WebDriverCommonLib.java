package com.VTiger.genricLibraries;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class WebDriverCommonLib extends BaseTest {

	public String getPageTitle()
	{
		
		String title = driver.getTitle();
		return title;
	}
	
	public void verify(String actual, String expected,String  value)
	{
		Assert.assertEquals(actual, expected );
		Reporter.log(value+" "+"'"+expected+"'"+" is verified Successfully ",true);
		
	}
	
	public void verifyWithcontains(String actual, String expectedContainsString,String  value)
	{
		if(actual.contains(expectedContainsString))
		{
			Reporter.log(value+" "+"'"+expectedContainsString+"'"+" is verified Successfully ",true);
		}
		else
		{
			
			Assert.fail(value+" "+"'"+expectedContainsString+"'"+" VERIFICATION is FAILED " );
		}
		
		
	}
	
	
	
	public void mouseHover(WebElement e)
	{
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();
		
	}
	
   public  void waitForPage(String title)
   {
	   WebDriverWait wait = new WebDriverWait(driver,10);
	   wait.until(ExpectedConditions.titleContains(title));
	   
	   
   }
   
   public void waitForElement(WebElement e)
   {
	   WebDriverWait wait = new WebDriverWait(driver,10);
	   wait.until(ExpectedConditions.visibilityOf(e));
	   
   }  

   
   public Alert switchToAlert()
   {
	   Alert a =driver.switchTo().alert();
	   return a;
   }
   public String switchToWindow(String s )
   {
	   driver.switchTo().window(s);
	   return s;
   }
   
   public  Set<String> getWindowHandles() {
	   
	   
   Set<String> windows =driver.getWindowHandles();
   return windows;
   }
   
   
	   public void selectOption(WebElement e,String visibleText)
	   {
		   Select s = new Select(e);
		   s.selectByVisibleText(visibleText);   
       }
	   
	   public void selectOption(String value,WebElement e)
	   {
		   Select s = new Select(e);
		   s.selectByValue(value);
       }
   
	   public void selectOption(WebElement e,int index)
	   {
		   Select s = new Select(e);
		   s.selectByIndex(index);
       }
   
	   
  
	
}

package com.VTiger.Invoice;

import java.util.List;

import org.testng.asserts.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.VTiger.Pages.InvoicePage;
import com.VTiger.genricLibraries.BaseTest;
import com.VTiger.genricLibraries.FileLib;
import com.VTiger.genricLibraries.WebDriverCommonLib;

@Listeners(com.VTiger.genricLibraries.MyListeners.class)
public class TC13SearchingTheInvoiceUsingSearchOptionTest extends BaseTest {
    
	@Test
	public void SearchingTheInvoiceUsingSearchOption() throws Throwable
	{
		
		 BaseTest bt = new BaseTest();
		   bt.gotoInvoicePage();
		   
		   InvoicePage ip = new InvoicePage();
		   FileLib fl = new FileLib();
			String subject=fl.getCelldata(EXCEL_FILE_PATH, "VTigerApplicationInvoiceModule", 1, 3);
		   ip.setSearchBox(subject);
		   

		   /*
		   Select s = new Select(ip.getSearchDropDown());			   
		   s.selectByVisibleText( fl.getCelldata(EXCEL_FILE_PATH, "VTigerApplicationInvoiceModule", 2, 3));
		   */		   
		   WebDriverCommonLib wcom = new WebDriverCommonLib();
		   wcom.selectOption(ip.getSearchDropDown(), fl.getCelldata(EXCEL_FILE_PATH, "VTigerApplicationInvoiceModule", 2, 3));
		
		   ip.getSearchButton().click();
		   
		  List<WebElement> list= ip.getSearchedTexts();
		  
		  //String expected=subject;
		  int count =0;
		  for(WebElement e:list )
		  {
			 
			  if(e.getText().equals(subject))
			  {
				  count++;
				  Reporter.log("Searched "+subject+" found in searched List successfully",true);
				  break;
			  }
			  
			  
		  }
		  if(count==0)
		  {
			 Assert.fail("Searched "+subject+" not found in searched List");
		  }
		  
		  
		  
		  
		  
		  ip.getSearchBox().clear();
		  
		  ip.getSearchButton().click();
		  if(ip.getNoInvoiceFoundText().isDisplayed())
		  {
			  Reporter.log("'No Invoice Found !' message found successfuly",true);
			   
		  }
		  else
		  {
			  Assert.assertTrue(ip.getNoInvoiceFoundText().isDisplayed(),"'No Invoice Found !' message not  found on page ");
				
		  }
		 
		  //logout code and verify logout
		  
		  bt.logOut();
		  bt.VerifylogOut();
		  
		 
		  
		  
		  
		  
		  
		   
		   
		   
		   
		   
		   
		   
		   
	
		   
		   
	}
	
	
}

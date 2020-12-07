package com.VTiger.Invoice;

import java.util.Set;

import org.openqa.selenium.remote.NewSessionPayload;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.VTiger.Pages.CreateInvoicePage;
import com.VTiger.Pages.InvoicePage;
import com.VTiger.Pages.SalesOrderWindow;
import com.VTiger.genricLibraries.BaseTest;
import com.VTiger.genricLibraries.FileLib;
import com.VTiger.genricLibraries.WebDriverCommonLib;

@Listeners(com.VTiger.genricLibraries.MyListeners.class)
public class TC6SelectSalesOrderfromSalesOrderfieldinCreateInvoicepageTest extends BaseTest{

	@Test
	public void selectSalesOrder() throws Throwable
	{
		   BaseTest bt = new BaseTest();
	 	   bt.gotoInvoicePage();
	 	   InvoicePage ip = new InvoicePage();	 	   
	 	   ip.getCreateInvoiceButton().click();
	 	   
	 	   
	 	   CreateInvoicePage cip = new CreateInvoicePage();
	 	
	 	    
	 	   cip.getSalesOrderIcon().click();
	 	   FileLib fl = new FileLib();
	 	   
	 	   WebDriverCommonLib wcom = new WebDriverCommonLib();
	 	   
	 	     String parentID = driver.getWindowHandle();
	 	      Set<String> windows=driver.getWindowHandles();
	 	    for(String s :windows)
	 	    {
	 	    	
	 	    	if(!s.equals(parentID))
	 	    	{
	 	    		driver.switchTo().window(s);
	 	    		
	 	    		SalesOrderWindow sow = new SalesOrderWindow();
	 	    		String salsodr=sow.getVerifyText().getText();
	 	    		wcom.verify(salsodr, fl.getCelldata(EXCEL_FILE_PATH, "CreateInvoicePage", 6, 1), "SalesOrderWindow");
	 	    	    sow.getSelectSalesOrder().click();
	 	    	    break;
	 	    	     	    
	 	    	}
	 	    }
	 	   driver.switchTo().window(parentID);
	 	    
	 	    
	 	     	    
	 	    wcom.waitForElement(cip.getSalesOrderNameField());
	 	   String selectedSalesOrder = cip.getSalesOrderNameField().getAttribute("value");
	 	   
	 	    wcom.verify(selectedSalesOrder, fl.getCelldata(EXCEL_FILE_PATH, "CreateInvoicePage", 3,1), "selectedSalesOrder");
	 	    
	 	    //Logout and verify logout
	 	    
	 	    Thread.sleep(5000);
	 	    bt.logOut();
	 	    bt.VerifylogOut();
	 	      
	 	      
	 	   
	}
}


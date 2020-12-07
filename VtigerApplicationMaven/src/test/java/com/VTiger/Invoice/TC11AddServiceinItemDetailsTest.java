package com.VTiger.Invoice;

import java.util.Set;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.VTiger.Pages.CreateInvoicePage;
import com.VTiger.Pages.InvoicePage;
import com.VTiger.Pages.ProductsPopUpWindow;
import com.VTiger.Pages.ServiceWindowPopUpPage;
import com.VTiger.genricLibraries.BaseTest;
import com.VTiger.genricLibraries.FileLib;
import com.VTiger.genricLibraries.IAutoConst;

import com.VTiger.genricLibraries.WebDriverCommonLib;


@Listeners(com.VTiger.genricLibraries.MyListeners.class)
public class TC11AddServiceinItemDetailsTest extends BaseTest implements IAutoConst{

	
	@Test
	public void AddServiceinItemDetails() throws Throwable
	{
		BaseTest bt = new BaseTest();
		bt.gotoInvoicePage();
		InvoicePage ip = new InvoicePage();
		ip.getCreateInvoiceButton().click();
		/*
		WebDriverCommonLib wcom = new WebDriverCommonLib();		
		FileLib flib = new FileLib();
		String expected =flib.getKeyValue(PROPERTY_FILE_PATH, "createNewInvoicePage");
		String actual = wcom.getPageTitle();
		wcom.verify(actual, expected, "createNewInvoicePage");		*/
		
		CreateInvoicePage cip = new CreateInvoicePage();
		cip.getVerifyTextCreateInvoicePage();
		
		
		//TC11 AddServiceinItemDetails
		
		cip.getAddServiceButton().click();
		WebDriverCommonLib wcom = new WebDriverCommonLib();
		wcom.waitForElement(cip.getServicesButton());
		cip.getServicesButton().click();
		
		
		////////
		
		 Set<String> windows = driver.getWindowHandles();
		   FileLib fl = new FileLib();
		   
		   ServiceWindowPopUpPage swp = new ServiceWindowPopUpPage();
		   
		 
		   String parentID= driver.getWindowHandle();
		   
		   
		   for(String s :windows)
		   {
			   
			   //System.out.println(driver.getTitle());
			   if(!s.equals(parentID))
			   {
				   driver.switchTo().window(s);
				   wcom.verify( swp.getServiceWindowPopUpPageVerifyText().getText(),wcom.getCelldata(EXCEL_FILE_PATH, "CreateInvoicePage", 7, 1),"ServiceWindowPopUpPage");
			       swp.getServiceName().click();
			       break;
			   }
			   
		   }
		      driver.switchTo().window(parentID);
		     
		      
		      
		      String selectedService=  cip.getProductNameField2().getAttribute("value");
			  
		      wcom.verify(selectedService, fl.getCelldata(EXCEL_FILE_PATH, "CreateInvoicePage", 8, 1), "selectedProduct");
			  
		      // logout and verifyLogOut
		      
              bt.logOut();
              bt.VerifylogOut();
		      
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
}

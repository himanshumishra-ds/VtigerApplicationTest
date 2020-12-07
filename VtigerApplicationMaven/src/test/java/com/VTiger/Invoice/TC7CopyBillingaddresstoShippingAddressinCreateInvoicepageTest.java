package com.VTiger.Invoice;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.VTiger.Pages.CreateInvoicePage;
import com.VTiger.Pages.InvoicePage;
import com.VTiger.genricLibraries.BaseTest;
import com.VTiger.genricLibraries.FileLib;
import com.VTiger.genricLibraries.WebDriverCommonLib;

@Listeners(com.VTiger.genricLibraries.MyListeners.class)
public class TC7CopyBillingaddresstoShippingAddressinCreateInvoicepageTest extends BaseTest {

	@Test
	public void copyAddress() throws Throwable
	{
		  BaseTest bt = new BaseTest();
	 	   bt.gotoInvoicePage();
	 	   InvoicePage ip = new InvoicePage();	 	   
	 	   ip.getCreateInvoiceButton().click();
	 	   
	 	//Copy Billing address to Shipping Address in Create Invoice page
			
	 		CreateInvoicePage cip = new CreateInvoicePage();
	 		FileLib fl = new FileLib();	 		
	 		String billAddress = fl.getCelldata(EXCEL_FILE_PATH, "CreateInvoicePage", 4, 1);
	 		
	 		cip.setBillingAddressBox(billAddress);
	 		cip.getCopyBillingAddressRadioBtn().click();
	 		String copiedText=cip.getShippingAddressBox().getAttribute("value");
			
			  WebDriverCommonLib wcom = new WebDriverCommonLib(); 
			  wcom.verify(copiedText, billAddress, "copiedText"); 

			//logout and  VerifyLogOut 
			   bt.logOut(); 
			  bt.VerifylogOut();
			
	 	   
	 	   
	 	   
	    	
		
	}
	
	
}

package com.VTiger.Invoice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.VTiger.Pages.CreateInvoicePage;
import com.VTiger.Pages.InvoicePage;
import com.VTiger.genricLibraries.BaseTest;
import com.VTiger.genricLibraries.FileLib;
import com.VTiger.genricLibraries.WebDriverCommonLib;

@Listeners(com.VTiger.genricLibraries.MyListeners.class)
public class TC8CopyShippingAddressToBillingAddressInCreateInvoicePageTest  extends BaseTest {
	
	@Test
	public void copyAddress() throws Throwable
	{
		BaseTest bt = new BaseTest();
	 	   bt.gotoInvoicePage();
	 	   InvoicePage ip = new InvoicePage();	 	   
	 	   ip.getCreateInvoiceButton().click();
	 	   
	 	//Copy Shipping address to Billining Address in Create Invoice page
			
	 		CreateInvoicePage cip = new CreateInvoicePage();
	 		FileLib fl = new FileLib();	 		
	 		String shippingAddress = fl.getCelldata(EXCEL_FILE_PATH, "CreateInvoicePage", 4, 1);
	 		
	 		cip.setShippingAddressBox(shippingAddress);
	 		cip.getCopyhippingAddressRadioBtn().click();
	 		String copiedAddress=cip.getBillingAddressBox().getAttribute("value");
	 		
			  WebDriverCommonLib wcom = new WebDriverCommonLib(); 
			  wcom.verify(copiedAddress, shippingAddress, "copiedText"); 

			//logout and  VerifyLogOut 
			   bt.logOut(); 
			   bt.VerifylogOut();
			
	 	   
	 	   
	 	   
		
		
		
		
	}

	
	
	
}

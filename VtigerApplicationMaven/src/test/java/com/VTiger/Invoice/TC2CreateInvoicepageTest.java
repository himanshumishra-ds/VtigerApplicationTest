package com.VTiger.Invoice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.VTiger.Pages.CreateInvoicePage;
import com.VTiger.Pages.InvoicePage;
import com.VTiger.genricLibraries.BaseTest;
import com.VTiger.genricLibraries.WebDriverCommonLib;

@Listeners(com.VTiger.genricLibraries.MyListeners.class)
public class TC2CreateInvoicepageTest extends BaseTest{
    
	/**
	 * @throws Throwable
	 */
	@Test
	public void createInvoice() throws Throwable
	{

		BaseTest bt = new BaseTest();
		bt.gotoInvoicePage();
		InvoicePage ip = new InvoicePage();
		ip.getCreateInvoiceButton().click();
		WebDriverCommonLib wcom = new WebDriverCommonLib();
		
		CreateInvoicePage cip = new CreateInvoicePage();
		cip.getVerifyTextCreateInvoicePage();
		bt.logOut();
		bt.VerifylogOut();
		
		
		
		
		
	}

}

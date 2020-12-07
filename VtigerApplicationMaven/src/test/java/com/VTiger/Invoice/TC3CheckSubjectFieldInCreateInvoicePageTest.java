package com.VTiger.Invoice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.VTiger.Pages.CreateInvoicePage;
import com.VTiger.Pages.InvoicePage;
import com.VTiger.genricLibraries.BaseTest;
import com.VTiger.genricLibraries.FileLib;
import com.VTiger.genricLibraries.WebDriverCommonLib;

@Listeners(com.VTiger.genricLibraries.MyListeners.class)
public class TC3CheckSubjectFieldInCreateInvoicePageTest extends BaseTest {

	@Test
	public void checkSubjectField() throws Throwable {
		
		BaseTest bt = new BaseTest();
		bt.gotoInvoicePage();
		InvoicePage ip = new InvoicePage();
		ip.getCreateInvoiceButton().click();
		CreateInvoicePage cip = new CreateInvoicePage();
		cip.getVerifyTextCreateInvoicePage();
		FileLib fl = new FileLib();
		String subject = fl.getCelldata(EXCEL_FILE_PATH, "CreateInvoicePage", 0,1 );
		cip.setSubjectTxtBox(subject);
		Thread.sleep(3000);
		cip.getSaveButton().click();
		WebDriverCommonLib wcom = new WebDriverCommonLib();
		String actualAlertText=wcom.switchToAlert().getText();
		String expectedText=fl.getKeyValue(PROPERTY_FILE_PATH, "createNewInvoicePagePopUp");	
		
		wcom.verify(actualAlertText, expectedText, "AlertPopUp");
		wcom.switchToAlert().accept();
		bt.logOut();
		bt.VerifylogOut();
		
		
		
		
	    
		
		
		
	}
	
	
	
}

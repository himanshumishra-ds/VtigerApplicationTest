package com.VTiger.Invoice;

import java.util.Set;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.VTiger.Pages.ContactsWindow;
import com.VTiger.Pages.CreateInvoicePage;
import com.VTiger.Pages.InvoicePage;
import com.VTiger.genricLibraries.BaseTest;
import com.VTiger.genricLibraries.FileLib;
import com.VTiger.genricLibraries.WebDriverCommonLib;

@Listeners(com.VTiger.genricLibraries.MyListeners.class)
public class TC4SelectContactFromContactNameFfieldInCreateInvoicePageTest extends BaseTest {

	@Test
	public void TC4SelectCntact() throws Throwable
	{
	   BaseTest bt = new BaseTest();
	   bt.gotoInvoicePage();
	   InvoicePage ip = new InvoicePage();
	   ip.getCreateInvoiceButton().click();
	   
	   CreateInvoicePage cip = new CreateInvoicePage();
	   
	   cip.getContactNameIcon().click();
	   
	  
	   WebDriverCommonLib wcom = new WebDriverCommonLib();
	   String parentTitle= wcom.getPageTitle();
	   String parentid=null;
	   FileLib fl= new FileLib();
	   
	   
	   
	    
	  Set<String> windows = wcom.getWindowHandles(); 
	  
	 
	  ContactsWindow cw = new ContactsWindow();
	   for(String s:windows)
	   {
		 
		   //String text=  wcom.switchToWindow(s);
		   String text= driver.switchTo().window(s).getTitle();
		   //System.out.println(text+"////"+s);
		   
		   
		   if(text.contains(fl.getKeyValue(PROPERTY_FILE_PATH,"windowTitleContains")))
		   {
			   parentid=s;
		   }
		   if(!text.contains(fl.getKeyValue(PROPERTY_FILE_PATH,"windowTitleContains")))
				   
		   {
			 wcom.switchToWindow(s); 
			
			
			if(cw.getVerifyText().getText().equals(fl.getKeyValue(PROPERTY_FILE_PATH, "windowsTitle")))
			 {
				wcom.verify(cw.getVerifyText().getText(), fl.getKeyValue(PROPERTY_FILE_PATH, "windowsTitle"), " Contacts Windows Page");
										
			 }	 
			 
			 
			 
			 
			 
		   }
		   
		   
	   }
	   
	   
	   cw.getSelectContact().click();;
	   wcom.switchToAlert().dismiss();;;
	   wcom.switchToWindow(parentid);
	  String selectedContactName  =  cip.getContactNameField().getAttribute("value");
	  wcom.verify(selectedContactName, fl.getCelldata(EXCEL_FILE_PATH, "CreateInvoicePage", 1, 1),"selectedContactName");
	  bt.logOut();
	  bt.VerifylogOut();
	  
	  
	   
	   
	   
	   
	}
	
	
}

package com.VTiger.Invoice;




import org.testng.Assert;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.VTiger.genricLibraries.BaseTest;


@Listeners(com.VTiger.genricLibraries.MyListeners.class)
public class TC1OpenInvoicePageTest extends BaseTest {

	
	 @Test
	 public void loginToApp() throws Throwable
	 {
		 
		 //open the browser // @BeforClass Annotation used
		BaseTest bt = new BaseTest();
		//bt.openBrowser();
		//going to Invoice Page and verifying all steps with method invoking
		bt.gotoInvoicePage();	
		
		//logout
		bt.logOut();
		
		//verify Logout
		bt.VerifylogOut();
		
		//closing browser // @BeforeClass annotation used 
		//bt.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
	 }
	 
		
		
		
        
      
		
		
	}



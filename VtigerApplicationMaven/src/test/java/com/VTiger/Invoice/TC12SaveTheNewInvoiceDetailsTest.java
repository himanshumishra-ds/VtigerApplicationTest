package com.VTiger.Invoice;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.VTiger.Pages.CreateInvoicePage;
import com.VTiger.Pages.HomePage;
import com.VTiger.Pages.InvoicePage;
import com.VTiger.Pages.OrganizationWindow;
import com.VTiger.Pages.ProductsPopUpWindow;
import com.VTiger.genricLibraries.BaseTest;
import com.VTiger.genricLibraries.FileLib;
import com.VTiger.genricLibraries.WebDriverCommonLib;

@Listeners(com.VTiger.genricLibraries.MyListeners.class)
public class TC12SaveTheNewInvoiceDetailsTest extends BaseTest {

	@Test
	public void saveNewInvoiceDetails() throws Throwable
	{
		
		 BaseTest bt = new BaseTest();
		   bt.gotoInvoicePage();
		   InvoicePage ip = new InvoicePage();	 	   
		   ip.getCreateInvoiceButton().click();
		   CreateInvoicePage cip = new CreateInvoicePage();
		   cip.getVerifyTextCreateInvoicePage();
		   
		   
		   //filling subjerct fieled
		   
		   FileLib fl = new FileLib();
			String subject = fl.getCelldata(EXCEL_FILE_PATH, "CreateInvoicePage", 0,1 );
			cip.setSubjectTxtBox(subject);
			
		
			
			
			
			//filling organization field
			cip.getOrganizationNameIcon().click();
			OrganizationWindow ow = new OrganizationWindow();
	 	    String parentID = driver.getWindowHandle();
	 	    Set<String> windows1=driver.getWindowHandles();
	 	    for(String s :windows1)
	 	    {
	 	    	if(!s.equals(parentID))
	 	    	{
	 	    		driver.switchTo().window(s);
	 	    		
	 	    		String org= ow.getVerifyText().getText();
	 	    		
	 	    		
	 	    	    if(org.equals(fl.getKeyValue(PROPERTY_FILE_PATH, "OtganizationWindowPopupPage")))
	 	    	    {
	 	    	    	Reporter.log("Organizations page successfully displayed ",true);
	 	    	        ow.getSelectOrganization().click(); 	    	    	
	 	    	    	driver.switchTo().alert().dismiss();
	 	    	    	driver.switchTo().window(parentID);
	 	    	    	
	 	    	    }
	 	    	    
	 	    	    
	 	    	    
	 	    	}
	 	    }
	 	    
	 	    String selectedOrganizationName = cip.getOrganizationNameField().getAttribute("value"); 	    
	 	    WebDriverCommonLib wcom = new WebDriverCommonLib();
	 	    
	 	    wcom.verify(selectedOrganizationName, fl.getCelldata(EXCEL_FILE_PATH, "CreateInvoicePage", 2, 1),"selectedOrganizationName" );
	 	   
			
		   // filling address field
	 	    
	 	  
	 	 		
	 		String billAddress = fl.getCelldata(EXCEL_FILE_PATH, "CreateInvoicePage", 4, 1);
	 		
	 		cip.setBillingAddressBox(billAddress);
	 		cip.getCopyBillingAddressRadioBtn().click();
	 		String copiedText=cip.getShippingAddressBox().getAttribute("value");
			
			  
			  wcom.verify(copiedText, billAddress, "copiedText"); 
			  
			  
			  
			  // filling item details 
			  
			  
			  
			   //System.out.println(parentID);
			   cip.getProductItemIcon1().click();
			   
			   Set<String> windows2 = driver.getWindowHandles();
			 
			   
			   ProductsPopUpWindow ppw = new ProductsPopUpWindow();
			  
			   
			   
			   
			   for(String s :windows2)
			   {
				   
				   //System.out.println(driver.getTitle());
				   if(!s.equals(parentID))
				   {
					   driver.switchTo().window(s);
					   wcom.verify( ppw.getVerifyText().getText(), fl.getKeyValue(PROPERTY_FILE_PATH, "ProductsPopUpWindowTitle"), "ProductsPopUpWindowPage");
				       ppw.getSelectProduct().click();
				       break;
				   }
				   
			   }
			   
			   
			      driver.switchTo().window(parentID);
			      String selectedProduct=  cip.getProductItemBox1().getAttribute("value");
				  wcom.verify(selectedProduct, fl.getCelldata(EXCEL_FILE_PATH, "CreateInvoicePage", 5, 1), "selectedProduct");
				  
				  
				 
				  
				  // clicking on save button 
				  cip.setQuantity();
				  cip.getSaveButton().click();
				  
				//verifying saved or not  
				    HomePage hp = new HomePage();
					wcom.mouseHover(hp.getMoreTab());
					//click on invoice 
					hp.getInvoiceTab().click();
					//verify invoice page 
					wcom.waitForPage(fl.getKeyValue(PROPERTY_FILE_PATH, "invoicePageTitle"));		
					wcom.verify(wcom.getPageTitle(), fl.getKeyValue(PROPERTY_FILE_PATH, "invoicePageTitle"), "InvoicePage");
		  
	            //now verifying that ,  new invoice should display in invoice records
					
				List<WebElement> l =driver.findElements(By.xpath("//table[@class='lvt small']//a[text()='spare parts']"));
				String   newXpath = "(//table[@class='lvt small']//a[text()='spare parts'])[" + (l.size())+ "]";
			  //String newXpath ="\"(//a[text()='spare parts'])"+"["+(l.size()-1)+"]\""; //  be care full ,  this is not right wayto concatinate , just above way is correct ,
							
				String expected=	fl.getCelldata(EXCEL_FILE_PATH, "CreateInvoicePage", 0, 1);				
				System.out.println("new xpath is :"+newXpath);//(//table[@class='lvt small']//a[text()='spare parts'])[6]	
				String actual = 	driver.findElement(By.xpath(newXpath)).getText();
				System.out.println("actual  is :"+actual);			
				wcom.verify(actual, expected, "InvoiceCreated");
								
			   //Log Out code and verify			  
				  bt.logOut();
				  bt.VerifylogOut();
		
// <a href="index.php?module=Invoice&amp;parenttab=Sales&amp;action=DetailView&amp;record=131" title="Invoice">spare parts</a>
// <a href="index.php?module=Invoice&amp;parenttab=Sales&amp;action=DetailView&amp;record=133" title="Invoice">spare parts</a>
	}
	
	
	
	
	
}

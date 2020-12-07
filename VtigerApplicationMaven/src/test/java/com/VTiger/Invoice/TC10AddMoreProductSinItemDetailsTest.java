package com.VTiger.Invoice;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.VTiger.Pages.CreateInvoicePage;
import com.VTiger.Pages.InvoicePage;
import com.VTiger.Pages.ProductsPopUpWindow;
import com.VTiger.genricLibraries.BaseTest;
import com.VTiger.genricLibraries.FileLib;
import com.VTiger.genricLibraries.WebDriverCommonLib;

@Listeners(com.VTiger.genricLibraries.MyListeners.class)
public class TC10AddMoreProductSinItemDetailsTest  extends BaseTest{
	@Test
	public void addMoreProducts() throws Throwable
	{
		
		   
		BaseTest bt = new BaseTest();
		bt.gotoInvoicePage();
		InvoicePage ip = new InvoicePage();
		ip.getCreateInvoiceButton().click();
		WebDriverCommonLib wcom = new 	WebDriverCommonLib();
		CreateInvoicePage cip = new CreateInvoicePage();
		cip.getVerifyTextCreateInvoicePage();
		
		
		
		
		//TC10AddMoreProductSinItemDetails starts
		
		
	
	cip.getAddProductButton().click();
	
    List<WebElement> boxes=	cip.getNewProductDetailBoxes();     
    Assert.assertTrue(boxes.size()>1);
    Reporter.log("New Products details fields display");
    
    
	   String parentID= driver.getWindowHandle();
	   //System.out.println(parentID);
	   cip.getProductItemIcon2().click();
	   
	   Set<String> windows = driver.getWindowHandles();
	   FileLib fl = new FileLib();
	   
	   ProductsPopUpWindow ppw = new ProductsPopUpWindow();
	   
	   
	   
	   
	   for(String s :windows)
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
	      String selectedProduct=  cip.getProductItemBox2().getAttribute("value");
		  wcom.verify(selectedProduct, fl.getCelldata(EXCEL_FILE_PATH, "CreateInvoicePage", 5, 1), "selectedProduct");
		  
		  //Logout code and verifyLogout code
		  bt.logOut();		 
		  bt.VerifylogOut();
    	  
      
	
		
		
		
		
		
	}

	
	
	
}

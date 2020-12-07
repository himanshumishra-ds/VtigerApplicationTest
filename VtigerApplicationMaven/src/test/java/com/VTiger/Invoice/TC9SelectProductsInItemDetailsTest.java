package com.VTiger.Invoice;

import java.util.Set;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.VTiger.Pages.CreateInvoicePage;
import com.VTiger.Pages.InvoicePage;
import com.VTiger.Pages.ProductsPopUpWindow;
import com.VTiger.genricLibraries.BaseTest;
import com.VTiger.genricLibraries.FileLib;
import com.VTiger.genricLibraries.WebDriverCommonLib;

	public class TC9SelectProductsInItemDetailsTest extends BaseTest {
		
	@Test
	public void selectProducts() throws Throwable
	{
		


	   BaseTest bt = new BaseTest();
	   bt.gotoInvoicePage();
	   InvoicePage ip = new InvoicePage();	 	   
	   ip.getCreateInvoiceButton().click();
	   
	   //TC9SelectProductsInItemDetails 
	   
	   CreateInvoicePage cip = new CreateInvoicePage();
	   String parentID= driver.getWindowHandle();
	   //System.out.println(parentID);
	   cip.getProductItemIcon1().click();
	   
	   Set<String> windows = driver.getWindowHandles();
	   FileLib fl = new FileLib();
	   
	   ProductsPopUpWindow ppw = new ProductsPopUpWindow();
	   WebDriverCommonLib wcom = new WebDriverCommonLib();
	   
	   
	   
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
	      String selectedProduct=  cip.getProductItemBox1().getAttribute("value");
		  wcom.verify(selectedProduct, fl.getCelldata(EXCEL_FILE_PATH, "CreateInvoicePage", 5, 1), "selectedProduct");
		  
		  //Logout code and verifyLogout code
		  bt.logOut();
		  bt.VerifylogOut();
		   
	   
	   
	   
	   
	   
	   
	   
	   
	}
	
}

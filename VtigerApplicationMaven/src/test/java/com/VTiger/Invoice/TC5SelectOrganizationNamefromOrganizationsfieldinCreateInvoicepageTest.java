package com.VTiger.Invoice;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.VTiger.Pages.CreateInvoicePage;
import com.VTiger.Pages.InvoicePage;
import com.VTiger.Pages.OrganizationWindow;
import com.VTiger.genricLibraries.BaseTest;
import com.VTiger.genricLibraries.FileLib;
import com.VTiger.genricLibraries.WebDriverCommonLib;


@Listeners(com.VTiger.genricLibraries.MyListeners.class)
public class TC5SelectOrganizationNamefromOrganizationsfieldinCreateInvoicepageTest extends BaseTest{

	
    @Test
	public void selectOrganizationName() throws Throwable
	{
    	BaseTest bt = new BaseTest();
 	   bt.gotoInvoicePage();
 	   InvoicePage ip = new InvoicePage();
 	   
 	   ip.getCreateInvoiceButton().click();
 	   
	   CreateInvoicePage cip = new CreateInvoicePage();
	   cip.getOrganizationNameIcon().click();
	   
 	  ///TC5SelectOrganizationNamefromOrganizationsfieldinCreateInvoicepage	   
 	   
 	//   driver.findElement(By.xpath("//input[@id='single_accountid']/following-sibling::img")).click();
	   OrganizationWindow ow = new OrganizationWindow();
 	    String parentID = driver.getWindowHandle();
 	    Set<String> windows=driver.getWindowHandles();
 	    for(String s :windows)
 	    {
 	    	if(!s.equals(parentID))
 	    	{
 	    		driver.switchTo().window(s);
 	    		
 	    		String org= ow.getVerifyText().getText();
 	    		FileLib fl = new FileLib();
 	    		
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
 	    FileLib fl = new FileLib();
 	    wcom.verify(selectedOrganizationName, fl.getCelldata(EXCEL_FILE_PATH, "CreateInvoicePage", 2, 1),"selectedOrganizationName" );
 	    bt.logOut();
 	    bt.VerifylogOut();	   
 	   
    	
    	
    	
	}
	
	
}

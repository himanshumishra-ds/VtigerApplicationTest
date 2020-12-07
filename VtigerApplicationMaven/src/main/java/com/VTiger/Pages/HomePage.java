package com.VTiger.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VTiger.genricLibraries.BaseTest;

public class HomePage extends BaseTest {
	
	
	@FindBy(xpath="//a[text()='More']") private WebElement moreTab;
	@FindBy(xpath="//a[@name='Invoice']") private WebElement invoiceTab;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	

	
	public WebElement getMoreTab() {
		return moreTab;
	}





	public WebElement getInvoiceTab() {
		return invoiceTab;
	}


	

	
	
}

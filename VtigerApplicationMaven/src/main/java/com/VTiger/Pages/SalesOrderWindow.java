package com.VTiger.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VTiger.genricLibraries.BaseTest;

public class SalesOrderWindow extends BaseTest {

	@FindBy(xpath="//td[text()='Sales Order']") private WebElement verifyText;
	@FindBy(xpath="//a[text()='Transport']")private WebElement SelectSalesOrder;
	
	public SalesOrderWindow()
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getVerifyText() {
		return verifyText;
	}

	public WebElement getSelectSalesOrder() {
		return SelectSalesOrder;
	}
	
	
}

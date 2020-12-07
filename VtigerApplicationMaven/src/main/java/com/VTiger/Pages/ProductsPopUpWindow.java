package com.VTiger.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VTiger.genricLibraries.BaseTest;

public class ProductsPopUpWindow extends BaseTest{

	@FindBy(xpath="//td[text()='Products']") private WebElement verifyText;
	@FindBy(xpath="//a[text()='abcd1234']") private WebElement selectProduct;
	
	public ProductsPopUpWindow()
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getVerifyText() {
		return verifyText;
	}

	public WebElement getSelectProduct() {
		return selectProduct;
	}

	
	
	
	
}

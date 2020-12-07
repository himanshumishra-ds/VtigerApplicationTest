package com.VTiger.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VTiger.genricLibraries.BaseTest;

public class ServiceWindowPopUpPage extends BaseTest {
	
	
	
	
	@FindBy(xpath="//td[text()='Services']") private WebElement ServiceWindowPopUpPageVerifyText;
	@FindBy(xpath="//a[contains(text(),'Automation')]") private WebElement serviceName;
	public WebElement getServiceName() {
		return serviceName;
	}

	public ServiceWindowPopUpPage()
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getServiceWindowPopUpPageVerifyText() {
		return ServiceWindowPopUpPageVerifyText;
	}
	
	
	
	
}

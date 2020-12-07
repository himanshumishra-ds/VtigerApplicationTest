package com.VTiger.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VTiger.genricLibraries.BaseTest;

public class ContactsWindow extends BaseTest {

	
	@FindBy(xpath="//td[text()='Contacts']") private WebElement verifyText;
	@FindBy(xpath="//a[text()='Manjunath R']")private WebElement SelectContact;
		
	public ContactsWindow()
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getVerifyText() {
		return verifyText;
	}

	public WebElement getSelectContact() {
		return SelectContact;
	}
	
	
	
	
	
	
}

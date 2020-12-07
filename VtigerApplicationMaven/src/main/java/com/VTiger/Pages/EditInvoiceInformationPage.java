package com.VTiger.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VTiger.genricLibraries.BaseTest;

public class EditInvoiceInformationPage extends BaseTest {

	@FindBy(xpath="//span[contains(text(),'Editing Invoice Information')]") private WebElement verifyEditInvoicePage;
	@FindBy(xpath="//input[@name='subject']") private WebElement subjectTextBox;
	@FindBy(xpath="(//input[@value='  Save  '])[1]") private WebElement saveButton;
	
	
	
	public WebElement getSubjectTextBox() {
		return subjectTextBox;
	}


	public WebElement getSaveButton() {
		return saveButton;
	}


	public EditInvoiceInformationPage()
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getVerifyEditInvoicePage() {
		return verifyEditInvoicePage;
	}
	
	
	
	
	
}

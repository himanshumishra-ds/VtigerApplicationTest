package com.VTiger.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VTiger.genricLibraries.BaseTest;
import com.VTiger.genricLibraries.FileLib;

public class InvoicePage extends BaseTest {

	
	@FindBy(xpath="//img[@alt='Create Invoice...']") private WebElement createInvoiceButton;
	@FindBy(xpath="(//a[text()='spare parts'])[2]") private WebElement verifyInvoiceCreated;
	@FindBy(xpath="//input[@name='search_text']") private WebElement searchBox;
    @FindBy(xpath="(//select[@id='bas_searchfield'])[1]") private WebElement searchDropDown;
    @FindBy(xpath="(//input[@class='crmbutton small create'])[1]") private WebElement searchButton;
    @FindBy(xpath="//a[text()='spare parts']") private List<WebElement> searchedTexts ;  
    @FindBy(xpath="//span[contains(text(),'No Invoice Found !')]") private WebElement noInvoiceFoundText;
    @FindBy(xpath="//a[text()='edit']") private List<WebElement> searchedSubjectLinks;
	@FindBy(xpath="//a[text()='spare parts Edited']") private WebElement verifyEditedInvoice;
	@FindBy(xpath="//a[text()='del']") private List<WebElement> searchedSubjectDeleteLinks;
    @FindBy(xpath="//table[@class='lvt small']//a[text()='spare parts']") private List<WebElement> newInvoiceCreatedWebElements;
    @FindBy(xpath=" //table[@class='lvt small']//a[text()='mouse']") private List<WebElement> newInvoiceCreatedWebElementForEdit;
    @FindBy(xpath="(//input[@value='Mass Edit'])[1]") private WebElement massEditButton;
 
    
    public List<WebElement> getNewInvoiceCreatedWebElementForEdit() {
		return newInvoiceCreatedWebElementForEdit;
	}

	
	
	public WebElement getMassEditButton() {
		return massEditButton;
	}

	public List<WebElement> getNewInvoiceCreatedWebElements() {
		return newInvoiceCreatedWebElements;
	}

	public List<WebElement> getSearchedSubjectDeleteLinks() {
		return searchedSubjectDeleteLinks;
	}

	public WebElement getVerifyEditedInvoice() {
		return verifyEditedInvoice;
	}

	public List<WebElement> getsearchedSubjectLinks() {
		return searchedSubjectLinks;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public void setSearchBox(String subject1) throws Throwable {
		
		searchBox.sendKeys(subject1);
	}

	public WebElement getSearchDropDown() {
		return searchDropDown;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public List<WebElement> getSearchedTexts() {
		return searchedTexts;
	}

	public WebElement getNoInvoiceFoundText() {
		return noInvoiceFoundText;
	}

	
	
	public WebElement getVerifyInvoiceCreated() {
		return verifyInvoiceCreated;
	}

	public InvoicePage()
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateInvoiceButton() {
		return createInvoiceButton;
	}

	
	
	
	
}

package com.VTiger.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VTiger.genricLibraries.BaseTest;
import com.VTiger.genricLibraries.FileLib;
import com.VTiger.genricLibraries.WebDriverCommonLib;

public class CreateInvoicePage extends BaseTest {
	
	
@FindBy(xpath="//span[text()='Creating New Invoice']") private WebElement verifyTextCreateInvoicePage;
@FindBy(name="subject") private WebElement subjectTxtBox ; 
@FindBy(xpath="(//input[@value='  Save  '])[1]") private WebElement saveButton; 
@FindBy(xpath="//input[@name='contact_id']/following-sibling::img") private WebElement contactNameIcon;
@FindBy(xpath="//input[@name='contact_name']") private WebElement contactNameField;
@FindBy(xpath="//input[@id='single_accountid']/following-sibling::img") private WebElement organizationNameIcon;
@FindBy(xpath="//input[@id='single_accountid']") private WebElement organizationNameField;
@FindBy(xpath="//input[@name='salesorder_id']/following-sibling::img") private WebElement salesOrderIcon;
@FindBy(xpath="//input[@name='salesorder_name']") private WebElement salesOrderNameField;
@FindBy(xpath="//textarea[@name='bill_street']") private WebElement BillingAddressBox;
@FindBy(xpath="//input[@onclick='return copyAddressRight(EditView)']") private WebElement copyBillingAddressRadioBtn;
@FindBy(xpath="//textarea[@name='ship_street']") private WebElement ShippingAddressBox;
@FindBy(xpath="//input[@onclick='return copyAddressLeft(EditView)']") private WebElement CopyhippingAddressRadioBtn;
@FindBy(xpath="//img[@id='searchIcon1']") private WebElement productItemIcon1;
@FindBy(xpath="//img[@id='searchIcon2']") private WebElement productItemIcon2;
@FindBy(xpath="//input[@id='productName1']") private WebElement productItemBox1;
@FindBy(xpath="//input[@id='productName2']") private WebElement productItemBox2;
@FindBy(xpath="//input[@value='Add Product']") private WebElement addProductButton;
@FindBy(xpath="//table[@id='proTab']/tbody/tr[contains(@id,'row')]") private List<WebElement> newProductDetailBoxes;
@FindBy(xpath="//input[@value='Add Service']") private WebElement addServiceButton;
@FindBy(xpath="//img[@title='Services']") private WebElement servicesButton;
@FindBy(xpath="//tr[@id='row2']/td[2]/table/tbody/tr[1]/td/input[@id='productName2']") private WebElement productNameField2;
@FindBy(xpath="//input[@id='qty1']") private WebElement quantity;


public WebElement getQuantity() {
	return quantity;
}



public void setQuantity() throws Throwable {
	FileLib fl = new FileLib();
    String quant=	fl.getCelldata(EXCEL_FILE_PATH, "VTigerApplicationInvoiceModule",22 ,3 );
    quantity.sendKeys(quant);
    //Thread.sleep(10000);
    
}



public WebElement getProductNameField2() {
	return productNameField2;
}



public WebElement getServicesButton() {
	return servicesButton;
}



public WebElement getAddServiceButton() {
	return addServiceButton;
}



public List<WebElement> getNewProductDetailBoxes() {
	return  newProductDetailBoxes;
}



public WebElement getAddProductButton() {
	return addProductButton;
}



public WebElement getProductItemBox1() {
	return productItemBox1;
}

public WebElement getProductItemBox2() {
	return productItemBox2;
}




public WebElement getProductItemIcon1() {
	return productItemIcon1;
}
public WebElement getProductItemIcon2() {
	return productItemIcon2;
}



public WebElement getCopyhippingAddressRadioBtn() {
	return CopyhippingAddressRadioBtn;
}



public void setCopyhippingAddressRadioBtn(WebElement copyhippingAddressRadioBtn) {
	CopyhippingAddressRadioBtn = copyhippingAddressRadioBtn;
}



public void setBillingAddressBox(WebElement billingAddressBox) {
	BillingAddressBox = billingAddressBox;
}



public void setCopyBillingAddressRadioBtn(WebElement copyBillingAddressRadioBtn) {
	this.copyBillingAddressRadioBtn = copyBillingAddressRadioBtn;
}



public void setShippingAddressBox(String shippingAddress) {
	ShippingAddressBox.sendKeys(shippingAddress);
	
}



public WebElement getBillingAddressBox() {
	return BillingAddressBox;
}



public void setBillingAddressBox(String s) {
	BillingAddressBox.sendKeys(s);
}



public WebElement getCopyBillingAddressRadioBtn() {
	return copyBillingAddressRadioBtn;
}



public WebElement getShippingAddressBox() {
	return ShippingAddressBox;
}




public WebElement getSalesOrderNameField() {
	return salesOrderNameField;
}



public WebElement getSalesOrderIcon() {
	return salesOrderIcon;
}



public WebElement getOrganizationNameField() {
	return organizationNameField;
}



public WebElement getOrganizationNameIcon() {
	return organizationNameIcon;
}



//input[@name='contact_id']/following-sibling::img
public WebElement getContactNameField() {
	
	
	return contactNameField;
}



public WebElement getContactNameIcon() {
	
	return contactNameIcon;
}



public WebElement getSaveButton() {
	return saveButton;
}



public CreateInvoicePage()
{
	PageFactory.initElements(driver, this);
}	



	public WebElement getSubjectTxtBox() {
		
	    return subjectTxtBox;
}


public void setSubjectTxtBox(String subjectData) {
	
	subjectTxtBox.sendKeys(subjectData);
	
   }

	public void getVerifyTextCreateInvoicePage() throws Throwable {
		WebDriverCommonLib wcom = new WebDriverCommonLib();
		FileLib flib = new FileLib();
		String text =flib.getKeyValue(PROPERTY_FILE_PATH, "createNewInvoicePage");
		wcom.verify(verifyTextCreateInvoicePage.getText(), text, "CreateInvoicePage");
		
		
	}
	
	


	

	
	
}

package com.VTiger.Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.VTiger.genricLibraries.BaseTest;

public class OrganizationWindow extends BaseTest {
	

	@FindBy(xpath="//td[text()='Organizations']") private WebElement verifyText;
	@FindBy(xpath="//a[text()='Hp']")private WebElement SelectOrganization;
		
	public OrganizationWindow()
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getVerifyText() {
		return verifyText;
	}

	public WebElement getSelectOrganization() {
		return SelectOrganization;
	}


}

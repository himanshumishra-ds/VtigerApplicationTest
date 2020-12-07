package com.VTiger.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VTiger.genricLibraries.BaseTest;

public class Logout extends BaseTest {

	@FindBy(xpath="//span[text()=' Administrator']/ancestor::td[1]/following-sibling::td/img[contains(@src,'user.PNG')]") private WebElement administrator;
	@FindBy(xpath="//td/a[text()='Sign Out']") private WebElement signout;
	
	public Logout()
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAdministrator() {
		return administrator;
	}

	public void setAdministrator(WebElement administrator) {
		this.administrator = administrator;
	}

	public WebElement getSignout() {
		return signout;
	}

	public void setSignout(WebElement signout) {
		this.signout = signout;
	}
	
	
	
}

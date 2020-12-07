package com.VTiger.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	@FindBy(xpath="//input[@name='user_name']") private WebElement usrnm ;
	@FindBy(xpath="//input[@name='user_password']") private WebElement pwd ;
	@FindBy(xpath="//input[@id='submitButton']") private WebElement loginButton;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setUsrnm(String un) {
		 usrnm.sendKeys(un);
	}
	
	public void setPwd(String pwds) {
		pwd.sendKeys(pwds);;
	}
	
	
	public WebElement getLoginButton() {
		
		
		return loginButton;
	}
	
	public void loginApp(String unm, String psd ) throws InterruptedException
	{
		usrnm.sendKeys(unm);
		//Thread.sleep(1000);
		pwd.sendKeys(psd);
		//Thread.sleep(1000);
		loginButton.click();
		
		
	}
	
}

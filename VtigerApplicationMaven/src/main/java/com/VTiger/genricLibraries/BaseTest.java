package com.VTiger.genricLibraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.VTiger.Pages.HomePage;
import com.VTiger.Pages.LoginPage;
import com.VTiger.Pages.Logout;

public class BaseTest extends FileLib implements IAutoConst{
public static WebDriver driver;
	
    @BeforeClass
	public void openBrowser() throws Throwable
	{
		FileLib flib = new FileLib();
		String browsername = flib.getKeyValue(PROPERTY_FILE_PATH, "browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver = new ChromeDriver();
			
		}
		else if (browsername.equals("firefox"))
		{
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			driver = new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();
		
		driver.get(flib.getKeyValue(PROPERTY_FILE_PATH, "url"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
				
	}
	
    @AfterClass
	public void close() throws InterruptedException
	{
    	System.out.println("quit() ll execute in 10 seconds");
    	
    	Thread.sleep(10000);
    	
		driver.quit();
	}
	
    public void gotoInvoicePage() throws Throwable
    {
    	LoginPage lp = new LoginPage(driver);
		FileLib flib = new FileLib();
		String usnm = flib.getKeyValue(PROPERTY_FILE_PATH, "username");
		String paswrd = flib.getKeyValue(PROPERTY_FILE_PATH, "password");
		//login to application
		lp.loginApp(usnm, paswrd);
		WebDriverCommonLib wclib = new WebDriverCommonLib();
		String Expectedtitle = flib.getKeyValue(PROPERTY_FILE_PATH, "homeTitle");
		wclib.waitForPage(Expectedtitle);
		String actualTitle=wclib.getPageTitle();	
		//verify homepage 
		wclib.verify(actualTitle, Expectedtitle, "HomePage");		
		HomePage hp = new HomePage();
		wclib.mouseHover(hp.getMoreTab());
		//click on invoice 
		hp.getInvoiceTab().click();
		//verify invoice page 
		wclib.waitForPage(flib.getKeyValue(PROPERTY_FILE_PATH, "invoicePageTitle"));		
		wclib.verify(wclib.getPageTitle(), flib.getKeyValue(PROPERTY_FILE_PATH, "invoicePageTitle"), "InvoicePage");
    }
    
    
    public void logOut() throws Throwable
    {
    	
    	Logout lo = new Logout();
		WebDriverCommonLib wclib = new WebDriverCommonLib();
		wclib.mouseHover(lo.getAdministrator());
		lo.getSignout().click();
		System.out.println("clicked on logout");
		FileLib flib = new FileLib();       	
		wclib.waitForPage(flib.getKeyValue(PROPERTY_FILE_PATH, "logoutTitle"));
		
    }
    
    public void VerifylogOut() throws Throwable
    {
    	FileLib flib = new FileLib();    	
    	WebDriverCommonLib wclib = new WebDriverCommonLib();
		wclib.waitForPage(flib.getKeyValue(PROPERTY_FILE_PATH, "logoutTitle"));
		wclib.verify(wclib.getPageTitle(), flib.getKeyValue(PROPERTY_FILE_PATH, "logoutTitle"), "LogoutPage");		
		
    }
	
}

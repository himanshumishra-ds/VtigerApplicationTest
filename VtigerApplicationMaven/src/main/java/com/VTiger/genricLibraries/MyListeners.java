package com.VTiger.genricLibraries;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;



public class MyListeners extends BaseTest implements ITestListener , IAutoConst {

	//@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log(result.getName()+" method Started", true);
	}

	//@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log(result.getName()+" method success", true);
	}

	//@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log(result.getName()+" method Failed", true);
		Date d = new Date();
		String myDate = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa").format(d);//"yyyyMMddhhmmss"
		
	    TakesScreenshot ts=(TakesScreenshot)driver	;
	    File src =  ts.getScreenshotAs(OutputType.FILE);	    
	    File dest = new File(SCREENSHOT_PATH+result.getName()+myDate+".jpg");	  
	    try {
			Files.copy(src,dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}

//	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log(result.getName()+" method Skipped", true);
	}

//	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log(result.getName()+" method failed", true);
	}

//	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log(result.getName()+" method failed with timeout", true);
	}

//	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log(context.getName()+" method Started", true);
	}

//	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log(context.getName()+" method Ends", true);
	}
	
	

}

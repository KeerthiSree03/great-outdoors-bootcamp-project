package com.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base_class.Library;
import com.pages.GreatOutdoors_LoginAndViewReports;
import com.selenium_reusablefunctions.SeleniumUtilities;

public class GreatOutdoors_Testcases extends Library{
	
	GreatOutdoors_LoginAndViewReports lpage;
	SeleniumUtilities seleniumUtil;
	
	@BeforeTest
	public void launchApp()
	{
		browserSetUp();
		logger.info("browser launched");
	}
	
	@Test
	public void login() {
		lpage=new GreatOutdoors_LoginAndViewReports(driver);
		lpage.getLoginForm();
		lpage.LoginUser(properties.getProperty("username"), properties.getProperty("password"));
		lpage.Submit();
		logger.info("Browser Login Successful");
	}
	
	
	@AfterTest
	public void close() {
		
		seleniumUtil = new SeleniumUtilities(driver);   
		seleniumUtil.getTitle();
		seleniumUtil.to_take_screenshot("loginPage");
		tearDown();
		logger.info("Closing browser");
	}

}

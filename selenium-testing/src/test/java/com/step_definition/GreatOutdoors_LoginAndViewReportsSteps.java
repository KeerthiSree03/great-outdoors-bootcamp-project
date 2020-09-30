package com.step_definition;

import com.base_class.Library;
import com.pages.GreatOutdoors_LoginAndViewReports;
import com.selenium_reusablefunctions.SeleniumUtilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GreatOutdoors_LoginAndViewReportsSteps extends Library {
	
	GreatOutdoors_LoginAndViewReports page;
	SeleniumUtilities seleniumUtil;
	
	
	@Given("To launch the browser and navigate to url")
	public void to_launch_the_browser_and_navigate_to_url() {
	    browserSetUp();
	    logger.info("Browser Launched");
	}
	
	@When("To open login Functionality of GreatOutdoors")
	public void to_open_login_Functionality_of_GreatOutdoors() {
		page = new GreatOutdoors_LoginAndViewReports(driver);
	    page.getLoginForm();
	    logger.info("Fetched Login page");
	}

	@Then("To Enter username and password")
	public void to_Enter_username_and_password() {
	    page.LoginUser(properties.getProperty("username"), properties.getProperty("password"));
	    logger.info("Entered credentials");
	}

	@Then("To click login button")
	public void to_click_login_button() {
	    page.Submit();
	    logger.info("Clicked login button");
	}

	@Then("To take screenshot and the title")
	public void to_take_screenshot_and_the_title() {
	    seleniumUtil=new SeleniumUtilities(driver);
	    seleniumUtil.to_take_screenshot("LoginPage1");
	    seleniumUtil.getTitle();
	    logger.info("Taken Screenshot and Title");
	    
	}
	
	@Then("To go to delivery Time Reports")
	public void to_go_to_delivery_Time_Reports() {
	    page.viewDeliveryTimeReports();
	    logger.info("Entered Delivery Time Reports page");
	}
	
	@Then("To view Item Level Delivery Time Report")
	public void to_view_Item_Level_Delivery_Time_Report() {
	    page.viewItemLevelReports();
	    logger.info("Fetched Item Level Delivery Time Report");
	}

	@Then("To view Category Level Delivery Time Report")
	public void to_view_Category_Level_Delivery_Time_Report() {
		page.viewCategoryLevelReports();
	    logger.info("Fetched Category Level Delivery Time Report");
	}

	@Then("To view Outlier-Category Level Delivery Time Report")
	public void to_view_Outlier_Category_Level_Delivery_Time_Report() {
		page.viewCategoryLevelReports();
	    logger.info("Fetched Outlier-Category Level Delivery Time Report");
	}

	@Then("To view Item Wise Delivery Time Report")
	public void to_view_Item_Wise_Delivery_Time_Report() {
	    page.viewItemWiseReports(properties.getProperty("productId"));
	    logger.info("Fetched Item level Delivery Time Report of product Id = "+properties.getProperty("productId"));
	}


	@Then("To view Category wise Delivery Time Report")
	public void to_view_Category_wise_Delivery_Time_Report() {
		page.viewCategoryLevelReports(properties.getProperty("categoryId"));
		logger.info("Fetched Category level Delivery Time Report of category Id = "+properties.getProperty("categoryId"));
	}

	
	@Then("To Logout from the application")
	public void to_Logout_from_the_application() {
	    page.Logout();
	    logger.info("Logged out successfully");
	}

	@Then("To close the browser")
	public void to_close_the_browser() {
	    tearDown();
	    logger.info(" Closed the Browser");
	}

}

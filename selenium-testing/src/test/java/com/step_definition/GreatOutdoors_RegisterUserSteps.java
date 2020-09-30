package com.step_definition;

import org.openqa.selenium.Alert;

import com.base_class.Library;
import com.pages.GreatOutDoors_RegisterUser;
import com.selenium_reusablefunctions.SeleniumUtilities;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GreatOutdoors_RegisterUserSteps extends Library{
	
	GreatOutDoors_RegisterUser page;
	SeleniumUtilities seleniumUtil;
	
	@When("To open register Functionality of GreatOutdoors")
	public void to_open_register_Functionality_of_GreatOutdoors() {
		page=new GreatOutDoors_RegisterUser(driver);
	    page.getRegisterForm();
	    logger.info("Fetched register user form");
	}

	@Then("To Fill all the credentials")
	public void to_Fill_all_the_credentials() {
	    page.registerUser(properties.getProperty("userType"), properties.getProperty("userId"), properties.getProperty("userPassword"), properties.getProperty("userReEnterPassword"), properties.getProperty("userPhone"), properties.getProperty("userEmail"));
	    logger.info("Entered credentials");
	}

	@Then("To click sign-in button")
	public void to_click_sign_in_button() throws InterruptedException {
	    page.signIn();
	    Thread.sleep(3000);
	    logger.info("signed in");
	    
	}
	
	@Then("To accept alert")
	public void to_accept_alert() {
		seleniumUtil=new SeleniumUtilities(driver);
		seleniumUtil.switchToAlert();
		logger.info("Accepted alert");
	}
	
	@Then("To Enter userId and password")
	public void to_Enter_userId_and_password() {
		page=new GreatOutDoors_RegisterUser(driver);
		page.LoginUser(properties.getProperty("userId"), properties.getProperty("userPassword"));
	    logger.info("Entered registered credentials");
	}
	
	@Then("To click login")
	public void to_click_login() {
		page.Submit();
	    logger.info("Clicked login button");
	}

	@Then("To click Logout")
	public void to_click_Logout() {
		 page.Logout();
		 logger.info("Logged out successfully");
	}

	@Then("To close browser")
	public void to_close_browser() {
		tearDown();
	    logger.info(" Closed the Browser");
	}
	
	


}

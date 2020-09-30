package com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base_class.Library;
import com.selenium_reusablefunctions.SeleniumUtilities;

public class GreatOutDoors_RegisterUser extends Library{

	public GreatOutDoors_RegisterUser(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id ="register_form")
	WebElement register;
	
	@FindBy(xpath = "//*[@id=\'register\']/form/div/div/select")
	WebElement userType;
	
	@FindBy(id = "userId")
	WebElement userId;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "re_enterPassword")
	WebElement re_enterPassword;
	
	@FindBy(id = "phoneNo")
	WebElement phoneNo;
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(xpath = "//*[@id=\'register\']/form/div/button")
	WebElement signIn;
	
	@FindBy(id = "userId")
	WebElement usernameText;
	
	@FindBy(id = "password")
	WebElement passwordText;
	
	@FindBy(id="loginButton")
	WebElement loginButton;
	
	@FindBy(id = "logout")
	WebElement logoutButton;
	
	public void getRegisterForm() {
		register.click();
	}
	
	public void registerUser(String usertype, String userid, String password, String reEnterPassword, String phoneNo, String email) {
		SeleniumUtilities seleniumUtil=new SeleniumUtilities(driver);
		seleniumUtil.dropdown(userType, usertype);
		userId.sendKeys(userid);
		this.password.sendKeys(password);
		re_enterPassword.sendKeys(reEnterPassword);
		this.phoneNo.sendKeys(phoneNo);
		this.email.sendKeys(email);
	}
	
	public void signIn() {
		signIn.click();
	}
	
	public void LoginUser(String username, String password)
	{
		usernameText.sendKeys(username);
		passwordText.sendKeys(password);
	}
	
	public void Submit()
	{
		loginButton.click();
		loginButton.click();
	}
	
	public void Logout() {
		logoutButton.click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
}

package com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base_class.Library;

public class GreatOutdoors_LoginAndViewReports extends Library{
	
	public GreatOutdoors_LoginAndViewReports(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id ="login_form")
	WebElement login;
	
	@FindBy(id = "userId")
	WebElement usernameText;
	
	@FindBy(id = "password")
	WebElement passwordText;
	
	@FindBy(id="loginButton")
	WebElement loginButton;
	
	@FindBy(xpath = "/html/body/app-root/body/app-admin/div/table/tr[4]/td/a/button")
	WebElement viewDeliveryTimeReports;
	
	@FindBy(id="1")
	WebElement viewItemLevelReports;
	
	@FindBy(id="2")
	WebElement viewCategoryLevelReports;
	
	@FindBy(id="3")
	WebElement viewOutlierCategoryLevelReports;
	
	@FindBy(id = "4")
	WebElement viewItemWiseReports;
	
	@FindBy(xpath = "//*[@id=\'searchText\']")
	WebElement item_search;
	
	@FindBy(xpath = "//*[@id=\'search_bar\']/form/button")
	WebElement item_searchButton;
	
	@FindBy(id = "5")
	WebElement viewCategoryWiseReports;
	
	@FindBy(xpath = "//*[@id=\'searchText\']")
	WebElement category_search;
	
	@FindBy(xpath = "//*[@id=\'search_bar\']/form/button")
	WebElement category_searchButton;
	
	@FindBy(id = "logout")
	WebElement logoutButton;
	
	public void getLoginForm() {
		login.click();
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
	
	public void viewDeliveryTimeReports() {
		viewDeliveryTimeReports.click();
	}
	
	public void viewItemLevelReports() {
		viewItemLevelReports.click();
	}
	
	public void viewCategoryLevelReports() {
		viewCategoryLevelReports.click();
	}
	
	public void viewOutlierCategoryLevelReports() {
		viewOutlierCategoryLevelReports.click();
	}
	
	public void viewItemWiseReports(String productId) {
		viewItemWiseReports.click();
		item_search.sendKeys(productId);
		item_searchButton.click();
	}
	
	public void viewCategoryLevelReports(String categoryId) {
		viewCategoryWiseReports.click();
		category_search.sendKeys(categoryId);
		category_searchButton.click();
	}
	
	public void Logout() {
		logoutButton.click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	

}

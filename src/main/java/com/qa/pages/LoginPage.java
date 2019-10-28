package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver,WebDriverWait wait) {
		super(driver,wait);
		// TODO Auto-generated constructor stub
	}
	
	//page locators
	private By username = By.id("username");
	private By password = By.id("password");
	private By loginBtn = By.id("loginBtn");
	/**
	 * @return the username
	 */
	public WebElement getUsername() {
		return getElement(username);
	}
	
	/**
	 * @return the password
	 */
	public WebElement getPassword() {
		return getElement(password);
	}
	
	
	/**
	 * @return the loginBtn
	 */
	public WebElement getLoginBtn() {
		return getElement(loginBtn);
	}
	
	public HomePage doLogin(String uname,String pwd) {
		
		
		getUsername().sendKeys(uname);
		getPassword().sendKeys(pwd);
		getLoginBtn().click();
		
		return getInstance(HomePage.class);
		
	}
	
	
	public String getLoginPageTitle() {
		
		
		wait.until(ExpectedConditions.titleContains("HubSpot Login"));
		return getTitle();
		
		
	}

	

}

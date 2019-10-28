package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

	
	
	
	public HomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}

	public String getHomePageTitle() {
		wait.until(ExpectedConditions.titleContains("Account Setup"));
		return getTitle();
	}

}

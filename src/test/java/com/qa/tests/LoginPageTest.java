package com.qa.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends BaseTest{
	
	HomePage homePage;
	
	
	@Test
	public void VerifyTitle() {
		
				
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println("login page title is : "+title);
		Assert.assertEquals(title, "HubSpot Login");
		
	}
	
	@Test
	public void loginTest() {
		
		homePage = page.getInstance(LoginPage.class).doLogin("rohanwarang28@yahoo.com", "Test@12345");
		Assert.assertEquals(homePage.getHomePageTitle(), "Account Setup | HubSpot");
	}

}

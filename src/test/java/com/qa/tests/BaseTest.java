package com.qa.tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.qa.pages.BasePage;
import com.qa.pages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest{
	
	WebDriver driver;
	Page page;
	WebDriverWait wait ; 

	
	@BeforeMethod
	@Parameters(value = {"browser"})
	public void setup(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		}
		
		if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		wait=new WebDriverWait(driver, 20);
		page=new BasePage(driver,wait);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://app.hubspot.com/login");
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}

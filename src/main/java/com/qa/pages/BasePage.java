/**
 * 
 */
package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author SIT
 *
 */
public class BasePage extends Page{

	public BasePage(WebDriver driver,WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public WebElement getElement(By locator) {
		// TODO Auto-generated method stub
		
		try {
		waitForElement(locator);
		return driver.findElement(locator);
		}
		catch(Exception e){
			
			System.out.println("Some exception occured while creating element");
		}
		return null;
	}

	@Override
	public void waitForElement(By locator) {
		// TODO Auto-generated method stub
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	@Override
	public void doClick(By locator) {
		// TODO Auto-generated method stub
		getElement(locator).click();
	}

	@Override
	public void doSendKeys(By locator, String text) {
		// TODO Auto-generated method stub
		getElement(locator).sendKeys(text);
	}



	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}

	
}

package com.qa.pages;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	public Page(WebDriver driver,WebDriverWait wait) {
		this.driver=driver;
		this.wait=wait;
	}
	
	
	
	public abstract void doClick(By locator);
	
	public abstract void doSendKeys(By locator,String text);
	
	public abstract String getTitle();
	
	public abstract WebElement getElement(By locator);
	
	public abstract void waitForElement(By locator);
	
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class,WebDriverWait.class).newInstance(this.driver,this.wait);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}

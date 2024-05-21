package com.prettylittlething.pages;
import static com.prettylittlething.utils.ConfigReader.getSelector;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.prettylittlething.utils.ActionHelper;


public class LoginPage {
WebDriver driver;
	
    ActionHelper helpers;
	public LoginPage(WebDriver driver) {
		this.driver=driver;	
		this.helpers = new ActionHelper(driver);
	}
	
	public void SignIn() throws InterruptedException, IOException {
		helpers.waitForElementDisplayed(getSelector("emailField"));
		driver.findElement(getSelector("emailField")).sendKeys("PLTusername"); 
		driver.findElement(getSelector("submitButton")).click();
		helpers.waitForElementDisplayed(getSelector("passwordField"));
		driver.findElement(getSelector("passwordField")).sendKeys("PLTPassword"); 
		driver.findElement(getSelector("submitButton")).click();
	}
}
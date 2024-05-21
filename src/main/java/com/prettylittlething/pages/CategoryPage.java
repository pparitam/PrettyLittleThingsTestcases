package com.prettylittlething.pages;

import static com.prettylittlething.utils.ConfigReader.getSelector;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;
import java.util.Random;

import com.prettylittlething.utils.ActionHelper;



public class CategoryPage {
	
	WebDriver driver;
	ActionHelper helpers;
	
	public CategoryPage(WebDriver driver) {
		this.driver=driver;
		this.helpers= new ActionHelper(driver);
	} 
	
	public void SelectProduct() throws IOException {
		WebElement products=helpers.selectRandomItem(driver.findElements(getSelector("PLPproductsList")));
		products.click();

	}	
}
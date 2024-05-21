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


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProductPage {

	WebDriver driver;
	ActionHelper helpers;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		this.helpers = new ActionHelper(driver);
	}

	public void getProductName() throws IOException {
		helpers.ProductName = helpers.waitAndGetText(getSelector("PDPproductName"));
	}

	public void SelectAndValidateSize() throws InterruptedException, IOException {
		helpers.waitForElementDisplayed(getSelector("PDPproductSize"));
		WebElement size = helpers.selectRandomItem(
		driver.findElements(getSelector("PDPproductSize")));
		size.click();

		String SizeAttributeValue = size.getAttribute("class");
		assertTrue(SizeAttributeValue.contains("text-white"));
		helpers.ProductSize=size.getText();
		System.out.println("The Selected size is: " + helpers.ProductSize);
	}
	
	public void getProductPrice() throws IOException {
		helpers.ProductPrice= helpers.waitAndGetText(getSelector("PDPproductPrice"));		
	}

	public void addToBag() throws InterruptedException, IOException {
		helpers.waitAndClick(getSelector("addToBag"));
		helpers.waitAndClick(getSelector("cartIcon"));
	}

}

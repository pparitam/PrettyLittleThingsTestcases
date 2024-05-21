package com.prettylittlething.pages;

import static com.prettylittlething.utils.ConfigReader.getSelector;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.prettylittlething.utils.ActionHelper;

public class CartPage {
	WebDriver driver;
	ActionHelper helpers;
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		this.helpers= new ActionHelper(driver);
	} 
	public void ValidateProductName() throws InterruptedException, IOException {
		Thread.sleep(3000);
//	String ProductNameCart =helpers.waitAndGetText(getSelector("cartproductName"));
	String ProductNameCart =helpers.waitAndGetText(By.cssSelector("[class='font-brand-thin text-sm text-new-brand-black hover:underline lg:text-base lg:tracking-wide']"));
	System.out.println("Actual Product name: "+ProductNameCart);
	System.out.println("Actual Product name: "+helpers.ProductName);
	Assert.assertEquals(ProductNameCart, helpers.ProductName);
	}
	
	public void getProductPrice() throws IOException {
		helpers.productSubTotal=helpers.waitAndGetText(By.cssSelector("[class='flex lg:justify-end'] p:nth-child(2)"));		
	}
	
	public void gotoCheckoutPage() throws IOException {
		helpers.waitAndClick(getSelector("checkoutButton"));
	}
}


package com.prettylittlething.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.prettylittlething.pages.*;


import com.prettylittlething.utils.DriverFactory;

public class PurchaseItemTest {
	

    WebDriver driver;
    public String url="https://www.prettylittlething.com/";

	
	@BeforeTest
	@Parameters({"browser"})
	public void beforeTest(String browserName) {
	    ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	    WebDriver driver = new ChromeDriver(chromeOptions);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    //driver=DriverFactory.getBrowser(browserName);	
	}
	
	@Test
	public void PlaceOrderOnPLT() throws IOException, InterruptedException {
		HomePage homePage= new HomePage(driver);
		CategoryPage categoryPage= new CategoryPage(driver);
		ProductPage pdpPage=new ProductPage(driver);
		CartPage cartPage= new CartPage(driver);
		LoginPage loginPage= new LoginPage(driver);
		BillingPage billingPage= new BillingPage(driver);
		
		homePage.openAndValidateStore(url);
		homePage.selectCategory();
		categoryPage.SelectProduct();
		pdpPage.getProductName();
		pdpPage.SelectAndValidateSize();
		pdpPage.addToBag();
		cartPage.ValidateProductName();
		cartPage.getProductPrice();
		cartPage.gotoCheckoutPage();
		loginPage.SignIn();
		billingPage.assertProductName();
		billingPage.assertSelectedProductSize();
		billingPage.assertProductPrice();
		billingPage.verifyDeliveryTotal();
		billingPage.verifyGrandTotal();
		billingPage.clickOnPaymentMethod();
	}
	
	@AfterTest
	public void AfterTest() {
		driver.quit();
	}

}


package com.prettylittlething.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static com.prettylittlething.utils.ConfigReader.getSelector;

import java.io.IOException;

import com.prettylittlething.utils.ActionHelper;

public class HomePage {

	WebDriver driver;
	ActionHelper helpers;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.helpers = new ActionHelper(driver);
	}

	public void openAndValidateStore(String Url) throws InterruptedException, IOException {
		driver.get(Url);
		helpers.acceptCookiesPopUp(getSelector("CookiePopPp"));
		helpers.waitForElementDisplayed(getSelector("topNav"));
	}

	public void selectCategory() throws InterruptedException, IOException {
		WebElement item = helpers.selectRandomItem(driver.findElements(getSelector("Categories")));
		String val = item.getText();
		System.out.println("Cat is:" + val);
		if (val.equalsIgnoreCase("BEAUTY") || val.equalsIgnoreCase("EDIT")) {
			selectCategory();
		} else {
			item.click();
		}
	}

}

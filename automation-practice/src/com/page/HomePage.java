package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(id="search_query_top")
	WebElement search;
	
	@FindBy(name="submit_search")
	WebElement submitsearchbutton;
	
	public void searchProduct(String product)
	{
		search.sendKeys(product);
		submitsearchbutton.click();
	}

}

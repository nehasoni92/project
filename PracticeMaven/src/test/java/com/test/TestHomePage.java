package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.page.HomePage;
import com.utility.BrowserFactory;

public class TestHomePage {
	
	WebDriver driver;
	
	@Test(groups={"search"})
	public void checkSearchProduct()
	{
		driver=BrowserFactory.launchBrowser("firefox", "http://automationpractice.com/index.php");
		HomePage homepage=PageFactory.initElements(driver, HomePage.class);
		homepage.searchProduct("silk");
	}

}

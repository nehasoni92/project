package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.page.LoginPage;
import com.utility.BrowserFactory;

public class TestLoginPage {
	
	WebDriver driver;
	
	@Test(groups={"loginvalid"})
	public void checkValidCredentials() throws InterruptedException
	{
		driver=BrowserFactory.launchBrowser("firefox", "http://automationpractice.com/index.php");
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		loginpage.login("abc@gmail.com", "12345678");
		Thread.sleep(3000);
		String pagetitle=loginpage.getPageTitle();
		Assert.assertEquals(pagetitle, "My account - My Store");		
		String signouttext=loginpage.getLogOutText();
		Thread.sleep(3000);
	
		Assert.assertEquals(signouttext, "Log Out");
		System.out.println(signouttext);
		Thread.sleep(3000);
		loginpage.LogOut();
			}
	
	@Test(groups={"loginInvalid"})
	public void checkInValidCredentials() throws InterruptedException
	{
		driver=BrowserFactory.launchBrowser("firefox", "http://automationpractice.com/index.php");
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		loginpage.login("hj1@gmail.com", "12345678");
		loginpage.LogOut();
	}

}

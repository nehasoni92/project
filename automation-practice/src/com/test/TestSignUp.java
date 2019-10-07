package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.page.SignUp;
import com.utility.BrowserFactory;

public class TestSignUp {
	
	WebDriver driver;
	
	
	@Test(groups={"signup"})
	public void checkRegister() throws InterruptedException
	{
		driver=BrowserFactory.launchBrowser("firefox", "http://automationpractice.com/index.php");
		SignUp signup=PageFactory.initElements(driver, SignUp.class);
		signup.createAccount("io@gmail.com");
			}
	
	@Test(groups={"register"})
	public void checkvalidCredentialsnUpSig() throws InterruptedException
	{
		SignUp signup=PageFactory.initElements(driver, SignUp.class);
		signup.register("komal", "khanna", "12345678", "murari", "khanna", "rajiv chawak", "kota", "rajasthan", "12345", "United State", "89789889", "alias" );
	}

}

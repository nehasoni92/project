package com.test;

import java.util.Calendar;

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
		signup.createAccount("kjhg"+"@gmail.com");
			}
	
	@Test(groups={"register"})
	public void checkvalidCredentialsSignUp() throws InterruptedException
	{
		SignUp signup=PageFactory.initElements(driver, SignUp.class);
		signup.register("komal", "khanna", "12345678", "murari", "khanna", "rajiv chawak", "kota", "rajasthan", "12345", "United State", "89789889", "alias" );
		Thread.sleep(3000);
		
		Assert.assertTrue(signup.checkCreateaccount(), "Create account is not successfull");
		Thread.sleep(3000);
	}
	
	@Test(groups={"Invalidcountry"})
	public void checkinvalidCredentialsSignUp_Country() throws InterruptedException
	{
		SignUp signup=PageFactory.initElements(driver, SignUp.class);
		boolean check=signup.invalidCountry("komal", "khanna", "12345678", "murari", "khanna", "rajiv chawak", "kota", "rajasthan", "12345", "United State", "89789889", "alias" );
		Thread.sleep(3000);
		
		Assert.assertTrue(check, "Create account is not successfull due to country error");
		Thread.sleep(3000);
	}
	@Test(groups={"Invalidpincode"})
	public void checkinvalidCredentialsnUpSig_postcode() throws InterruptedException
	{
		SignUp signup=PageFactory.initElements(driver, SignUp.class);
		boolean check=signup.invalidpostcode("komal", "khanna", "12345678", "murari", "khanna", "rajiv chawak", "kota", "rajasthan", "12345", "United State", "89789889", "alias" );
		Thread.sleep(3000);
		
		Assert.assertTrue(check, "Create account is not successfull due to pincode error");
		Thread.sleep(3000);
	}

	
}

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
	
	
	/*@Test(groups={"signup"})
	public void checkRegister() throws InterruptedException
	{
		driver=BrowserFactory.launchBrowser("firefox", "http://automationpractice.com/index.php");
		SignUp signup=PageFactory.initElements(driver, SignUp.class);
		signup.createAccount("kjhg987"+"@gmail.com");
		Thread.sleep(3000);
		driver.close();
			}*/
	
	@Test(groups={"register"})
	public void checkvalidCredentialsSignUp() throws InterruptedException
	{
		driver=BrowserFactory.launchBrowser("firefox", "http://automationpractice.com/index.php");
		SignUp signup=PageFactory.initElements(driver, SignUp.class);
		signup.createAccount("ndfgjhgfsssssaasdddsnsssssj"+"@gmail.com");
		signup.register("komal", "khanna", "12345678", "murari", "khanna", "rajiv chawak", "kota", "rajasthan", "12345", "United State", "89789889", "alias" );
		Thread.sleep(5000);
		
		Assert.assertTrue(signup.checkCreateaccount(), "Registration not successful");
		
	}
	
	@Test(groups={"Invalidcountry"})
	public void checkinvalidCredentialsSignUp_Country() throws InterruptedException
	{
		driver=BrowserFactory.launchBrowser("firefox", "http://automationpractice.com/index.php");
		SignUp signup=PageFactory.initElements(driver, SignUp.class);
		signup.createAccount("kznbf0ssss"+"@gmail.com");
		boolean check=signup.invalidCountry("komal", "khanna", "12345678", "murari", "khanna", "rajiv chawak", "kota", "rajasthan", "12345", "United State", "89789889", "alias" );
		Thread.sleep(3000);
		
		Assert.assertTrue(check, "Create account is not successfull due to country error");
		
	}
	@Test(groups={"Invalidpincode"})
	public void checkinvalidCredentialsnUpSig_postcode() throws InterruptedException
	{
		driver=BrowserFactory.launchBrowser("firefox", "http://automationpractice.com/index.php");
		
		SignUp signup=PageFactory.initElements(driver, SignUp.class);
		signup.createAccount("knnbbfnkji8sssssssss"+"@gmail.com");
		boolean check=signup.invalidpostcode("komal", "khanna", "12345678", "murari", "khanna", "rajiv chawak", "kota", "rajasthan", "12345", "United State", "89789889", "alias" );
		Thread.sleep(3000);
		
		Assert.assertTrue(check, "Create account is not successfull due to pincode error");
		
	}

	
}

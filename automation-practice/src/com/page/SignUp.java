package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SignUp {
	
	static WebDriver driver;
	
	public SignUp()
	{
		this.driver=driver;
	}
	
	@FindBy(className="login")
	WebElement signin;
	
	@FindBy(id="email_create")
	WebElement email;
	
	@FindBy(id="SubmitCreate")
	WebElement submitcreate;
	
	@FindBy(id="customer_firstname")
	WebElement firstname1;
	
	@FindBy(id="customer_lastname")
	WebElement lastname2;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="firstname")
	WebElement addressfirstname;
	
	@FindBy(id="lastname")
	WebElement addresslastname;
	
	@FindBy(id="address1")
	WebElement address;
	
	@FindBy(id="city")
	WebElement add_city;
	
	@FindBy(id="postcode")
	WebElement zipcode;
	
	@FindBy(id="phone_mobile")
	WebElement phoneno;
	
	@FindBy(id="alias")
	WebElement addressalias;
	
	@FindBy(id="id_state")
	WebElement state;
	
	@FindBy(id="id_country")
	WebElement country;
	
	@FindBy(id="submitAccount")
	WebElement register;
	
	@FindBy(id="create_account_error")
	WebElement errormessage;
	
	public void createAccount(String username) throws InterruptedException
	{
		signin.click();
		Thread.sleep(3000);
		
		email.sendKeys(username);
		
		submitcreate.click();		
		Thread.sleep(2000);
		
			}
	
	public void register(String fname, String lname, String pwd, String addfirstname, String addlastname, String address1, String city, String statename, String pincode, String countryname, String pnumber, String addalias) throws InterruptedException
	{
		Thread.sleep(2000);
		firstname1.sendKeys(fname);
		lastname2.sendKeys(lname);
		password.sendKeys(pwd);
		addressfirstname.sendKeys(addfirstname);
		addresslastname.sendKeys(addlastname);
		address.sendKeys(address1);
		add_city.sendKeys(city);
		state.sendKeys(statename);
		zipcode.sendKeys(pincode);
		country.sendKeys(countryname);
		phoneno.sendKeys(pnumber);
		addressalias.sendKeys(addalias);
		register.click();
		
	}

}

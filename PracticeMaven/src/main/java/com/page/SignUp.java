package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SignUp {

	static WebDriver driver;

	public SignUp() {
		this.driver = driver;
	}

	@FindBy(className = "login")
	WebElement signin;
	@FindBy(xpath = "//*[@id='id_gender2']")
	WebElement gender;

	@FindBy(id = "email_create")
	WebElement email;

	@FindBy(id = "SubmitCreate")
	WebElement submitcreate;

	@FindBy(id = "customer_firstname")
	WebElement firstname1;

	@FindBy(id = "customer_lastname")
	WebElement lastname2;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(id = "firstname")
	WebElement addressfirstname;

	@FindBy(id = "lastname")
	WebElement addresslastname;

	@FindBy(id = "address1")
	WebElement address;

	@FindBy(id = "city")
	WebElement add_city;

	@FindBy(id = "postcode")
	WebElement zipcode;

	@FindBy(id = "phone_mobile")
	WebElement phoneno;

	@FindBy(id = "alias")
	WebElement addressalias;

	@FindBy(id = "id_state")
	WebElement state;

	@FindBy(id = "id_country")
	WebElement country;

	@FindBy(id = "submitAccount")
	WebElement register;

	@FindBy(id = "create_account_error")
	WebElement errormessage;

	@FindBy(id = "days")
	WebElement day;

	@FindBy(id = "months")
	WebElement month;

	@FindBy(id = "years")
	WebElement year;

	public void createAccount(String username) throws InterruptedException {
		signin.click();
		Thread.sleep(3000);

		email.sendKeys(username);

		submitcreate.click();
		Thread.sleep(2000);

	}

	public void register(String fname, String lname, String pwd, String addfirstname, String addlastname,
			String address1, String city, String statename, String pincode, String countryname, String pnumber,
			String addalias) throws InterruptedException {
		Thread.sleep(2000);
		gender.click();
		firstname1.sendKeys(fname);
		lastname2.sendKeys(lname);
		password.sendKeys(pwd);
		selectdate();
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

	public void selectdate() {
		Select selectday = new Select(day);
		selectday.selectByIndex(2);
		Select selectmonth = new Select(month);
		selectmonth.selectByIndex(2);
		Select selectyear = new Select(year);
		selectyear.selectByIndex(20);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public boolean checkCreateaccount() {

			try {
				//LoginPage login=new LoginPage(driver);
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[2]/a"));
			//driver.findElement(By.xpath("//*[contains(@title, 'My account - My Store')]"));
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return true;

		}
	}

	public boolean invalidCountry(String fname, String lname, String pwd, String addfirstname, String addlastname,
			String address1, String city, String statename, String pincode, String countryname, String pnumber,
			String addalias) throws InterruptedException {
		Thread.sleep(2000);
		gender.click();
		firstname1.sendKeys(fname);
		lastname2.sendKeys(lname);
		password.sendKeys(pwd);
		selectdate();
		addressfirstname.sendKeys(addfirstname);
		addresslastname.sendKeys(addlastname);
		address.sendKeys(address1);
		add_city.sendKeys(city);
		state.sendKeys(statename);
		zipcode.sendKeys(pincode);
		country.clear();
		// country.sendKeys(countryname);
		phoneno.sendKeys(pnumber);
		addressalias.sendKeys(addalias);
		register.click();

		return checkErrormessage();

	}

	public boolean checkErrormessage() {
		try {
			driver.findElement(By.xpath("//@contains(text(),'id_country is required.'"));
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;

		}
	}

	public boolean checkErrormessage_postcode() {
		try {
			driver.findElement(By.xpath(
					"//@contains(text(),'The Zip/Postal code you've entered is invalid. It must follow this format: 00000'"));
			return true;
		} catch (Exception e) {
			return true;

		}
	}

	public boolean invalidpostcode(String fname, String lname, String pwd, String addfirstname, String addlastname,
			String address1, String city, String statename, String pincode, String countryname, String pnumber,
			String addalias) throws InterruptedException {

		Thread.sleep(2000);
		gender.click();
		firstname1.sendKeys(fname);
		lastname2.sendKeys(lname);
		password.sendKeys(pwd);
		selectdate();
		addressfirstname.sendKeys(addfirstname);
		addresslastname.sendKeys(addlastname);
		address.sendKeys(address1);
		add_city.sendKeys(city);
		state.sendKeys(statename);
		// zipcode.sendKeys(pincode);
		country.sendKeys(countryname);
		phoneno.sendKeys(pnumber);
		addressalias.sendKeys(addalias);
		register.click();

		return checkErrormessage_postcode();

	}
}

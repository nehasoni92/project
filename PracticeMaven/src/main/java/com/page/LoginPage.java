package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	

	@FindBy(className="login")
	WebElement signin;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement submit;
	
	@FindBy(className="logout")
	WebElement logout;
	
	@FindBy(linkText="Sign out")
	WebElement signouttext;
	
	public void login(String username, String pass) throws InterruptedException
	{
		signin.click();
		Thread.sleep(3000);
		email.sendKeys(username);
		password.sendKeys(pass);
		submit.click();
		
	}
	
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	
	public boolean invalidlogin(String username, String pass) throws InterruptedException
	{
		signin.click();
		Thread.sleep(3000);
		email.sendKeys(username);
		password.sendKeys(pass);
		submit.click();
		String color=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[1]/ol/li")).getCssValue("color");
		if(color.equalsIgnoreCase("red")){
			return true;
		}
		return false;
	}
	
	
	
	
	public boolean LogOut()
	{
		try{
		logout.click();
		driver.findElement(By.className("login"));
		return true;
		}
		catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return false;
			// TODO: handle exception
		}
		
	}
	
	
}

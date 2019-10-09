package com.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.page.LoginPage;
import com.page.SignUp;
import com.utility.BrowserFactory;

public class TestLoginPage {
	
	WebDriver driver;
	
	@Test(dataProvider="createdata", groups={"loginvalid"})
	public void checkValidCredentials(String userid, String password) throws InterruptedException
	{
		driver=BrowserFactory.launchBrowser("firefox", "http://automationpractice.com/index.php");
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		loginpage.login(userid, password);
		Thread.sleep(3000);
		Assert.assertTrue(loginpage.LogOut());
		driver.close();
			}	
		
	
	@Test(groups={"logininvalidlogin"})	
	public void checkinvalidlogin() throws InterruptedException{
		driver=BrowserFactory.launchBrowser("firefox", "http://automationpractice.com/index.php");
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		loginpage.invalidlogin("assrtt", "eee");
	}


	
	
	@DataProvider
	public Object[][] createdata() throws IOException{
		
		//Identify the testdata file
		//create path for the input file/
		
		
		String path = System.getProperty("user.dir") + "/src/main/java/testdata";
		String filename = "login_data.xlsx";
		String sheetname ="Sheet1";
		
		FileInputStream inputstream = new FileInputStream(path+ "/" + filename);
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		Sheet FBSheet = workbook.getSheet(sheetname);
		int rows = FBSheet.getLastRowNum();
		//System.out.println(rows);
		
		Object[][] data_set = new Object[3][2];
		
		for(int row=1;row<=rows;row++) {
			
			Row rowdata = FBSheet.getRow(row);
			//System.out.println(rowdata.getLastCellNum());
			
			for(int col=0; col<rowdata.getLastCellNum();col ++) {
				Cell  cell_data = rowdata.getCell(col);
				System.out.println(cell_data);	
				data_set[row-1][col]=cell_data.getStringCellValue();
					
			}
			
		}
		
		return data_set;
		
	}
	
	}

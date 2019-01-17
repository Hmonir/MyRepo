package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
//import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	//Super key word - Super Class constructor
		
		
	}
	

	
	@BeforeMethod
	public void setup() throws IOException {
	initialiazation();
	loginPage = new LoginPage();	
		
	}
	
	@Test (priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateloginpagetitel();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");	
	}
	@Test (priority=2)
	public void crmLogoImageTest() throws InterruptedException {
		Thread.sleep(5000);
		boolean flag = loginPage.validateCRMImage();		
		Assert.assertTrue(flag);
	
	}
	
	@Test (priority=3)
	public void loginTest() throws InterruptedException {
		Thread.sleep(5000);
		homePage= loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		//homePage= loginPage.login(username, password);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}


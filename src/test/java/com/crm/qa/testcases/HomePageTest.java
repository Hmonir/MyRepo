package com.crm.qa.testcases;

//import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utility.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactsPage;
	
    
	
	public HomePageTest() {
		super();
	//Super key word - Super Class constructor
			
	}
	
	@BeforeMethod
	public void setup() throws Exception {
	initialiazation();
	testutil = new TestUtil();
	contactsPage = new ContactsPage();
	loginPage = new LoginPage();
	
	Thread.sleep(5000);
	homePage= loginPage.login(prop.getProperty("username"),prop.getProperty("password"));	
	}
	
	@Test (priority=1)
	public void HomepageTitleTest() {
		String homepagetitle= homePage.VerifyHomepagetitle();
		Assert.assertEquals(homepagetitle,"CRMPRO","Home Page Title Not Matched");
	}
	
	
	@Test (priority=2)
	public void VerifyUserNameTest() {
		testutil.switchToFrame();
		Assert.assertTrue(homePage.VerifyCorrectUsername());
	}

	@Test (priority =3)
	public void VerifyContactLinksTest() {
		testutil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}

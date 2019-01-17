package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utility.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactsPage;
	
	public ContactsPageTest() {
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
	testutil.switchToFrame();
	contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test (priority=1)
	public void verifyContactPageLabel() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contact Label is missing on the page");
		
		
	}
	
	@Test(priority=2)
	public void validateCreateNewContact(String title, String firstName, String lastName, String company){
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact("Mr.", "Monir", "Hossain", "Google");
		//contactsPage.createNewContact(title, firstName, lastName, company);
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}

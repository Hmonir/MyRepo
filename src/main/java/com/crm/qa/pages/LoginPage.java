package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;


public class LoginPage extends TestBase {
	
	
	//Page Factory or Object Repository
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name ="password")
	WebElement password;
	
	@FindBy (xpath ="//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy (xpath="//button[contains(text(),'Sign Up')]")
	WebElement SignupBtn;
	@FindBy (xpath="//a[contains(@href,'index')]")
	WebElement crmLogo;
	
	//Initialize page objects
	//Constructor
	// this means current class object
		public LoginPage () {
			PageFactory.initElements(driver, this);
		}
		
		// Actions to get title (Method)- Different features#1
		public String validateloginpagetitel() {
			return driver.getTitle();
			
		}
		
		//Feature#2
		
		public Boolean validateCRMImage() {
			return crmLogo.isDisplayed();
		}
		
		public HomePage login (String un,String pwd) throws InterruptedException {
			username.click();
			username.sendKeys(un);
			Thread.sleep(2000);
			Thread.sleep(2000);
			password.sendKeys(pwd);			
			Thread.sleep(2000);
			loginBtn.click();
			
			return new HomePage();
			
		}

	}

	

	
	
	

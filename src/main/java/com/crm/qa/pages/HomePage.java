package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath="//td[contains(text(),'User: Monir Hossain')]")
	//@CacheLookup
	WebElement UsernameLabel;
	
	@FindBy (xpath="//a[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy (xpath="//a[containc(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy (xpath="//a[contains(text(),'Tasks')]")
	WebElement TasksLink;
	
	//Constructor - Initialize the page object
		// this means current class object
			public HomePage () {
				PageFactory.initElements(driver, this);
			}
			
	//Method #1
			public String VerifyHomepagetitle() {
				return driver.getTitle();
				
			}
	// Method #2
			public ContactsPage clickOnContactsLink() {
				ContactsLink.click();
				
				return new ContactsPage ();
			}
			
	// Method #3
			
			public DealsPage clickOnDealsLink() {
				DealsLink.click();
				
				return new DealsPage ();
			}
	
	// Method #4
			
			public TasksPage clickOnTasksLink() {
				TasksLink.click();
				
				return new TasksPage();
				
			}
			
	//Method #5
			public boolean VerifyCorrectUsername() {
				return UsernameLabel.isDisplayed();
			}
	
	
	// Method #6
			public void clickOnNewContactLink(){
				Actions action = new Actions(driver);
				action.moveToElement(ContactsLink).build().perform();
				newContactLink.click();
				
			}
	
	
	

}

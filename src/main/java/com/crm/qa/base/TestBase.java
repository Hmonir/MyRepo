package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.utility.TestUtil;

//import com.crm.qa.utility.TestUtil;
//import com.crm.qa.utility.WebEventListener;

//import com.sun.javafx.scene.control.Properties;

public class TestBase {
 
	public static WebDriver driver;
	public static Properties prop;
	//public  static EventFiringWebDriver e_driver;
	//public static WebEventListener eventListener;
	
	public static String username;
	public static String password;
	
	
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("app.config");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();	
			
	}		
	}



	public static void initialiazation() throws IOException {
			
		Properties prop = new Properties();
		String fileName = "app.config";
		InputStream is = null;
		try {
		    is = new FileInputStream(fileName);
		} catch (FileNotFoundException ex) {
		  
		}
		try {
		    prop.load(is);
		} catch (IOException ex) {
		  
		}
		
	
		//System.out.println(prop.getProperty("browserName"));
		
		
		
	String	browserName = prop.getProperty("browserName");
	username= prop.getProperty("username");
	password=prop.getProperty("password");
	
	switch (browserName)
	{
	     case "chrome":
	    	 System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
	    	 driver = new ChromeDriver();
	    	
	    	 
	    //case "FF":
	    	// System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Java\\geckodriver.exe");
	    	// driver = new FirefoxDriver();
	   
	}
	
	//if (browserName.equalsIgnoreCase("chrome")) {
	//	System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
	//	driver = new ChromeDriver();
	//} else if (browserName.equals("FF")){
	//	System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Java\\geckodriver.exe");
	//	driver = new FirefoxDriver();
	//}
	
	/*e_driver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver;*/
			
	driver. manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);	
	
	driver.get(prop.getProperty("url"));
	
	}
	
	
}

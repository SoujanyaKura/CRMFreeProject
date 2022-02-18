package com.qa.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestBase {
	
	public Properties prop;
	public FileInputStream ip;
	public WebDriver driver;
	public JavascriptExecutor j = (JavascriptExecutor)driver;
	//public Actions action =new Actions(driver);

	/**
	 * @throws FileNotFoundException 
	 * 
	 */
	public TestBase() throws FileNotFoundException {
		prop = new Properties();
		ip = new FileInputStream("C:\\Users\\INTEL\\eclipse-workspace\\CRMFreeProject\\src\\main\\java\\com\\qa\\crm\\config\\config.properties");
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated constructor stub
	}
	
	public void IntializeBrowser() {
		
		if(prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C://Users//INTEL//eclipse//Downloads//chromedriver_win321//chromedriver.exe/");
		    driver = new ChromeDriver();
		    driver.get(prop.getProperty("Url"));
		
		
		}else if(prop.getProperty("browser").equals("firefox")) {
			System.setProperty("web.gecoke.drive", "C://Program Files (x86)//Mozilla Firefox//firefox.exe/");
		    driver = new FirefoxDriver();
		    driver.get(prop.getProperty("Url"));
		    
		    
		
		}
		
	}
	
	
	
	
	
	

}

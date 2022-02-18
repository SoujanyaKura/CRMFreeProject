package com.qa.crm.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.TestBase;

public class HomePage extends TestBase{
	
	
	LoginPage loginPage;
	
	@FindBy(xpath="//img[@src='https://freecrm.com/images/freecrm_logo.png']")
	WebElement logo;
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement loginLink;

	 public HomePage(WebDriver homePageDriver) throws FileNotFoundException {
			
			// TODO Auto-generated constructor stub
		 this.driver=homePageDriver;
		 
		 PageFactory.initElements(driver, this);
		 
		}

	
	
	
	public String getTitleofpage() {
		//System.out.println("Helloooooooooooooo");
		 String s=driver.getTitle();
		 //System.out.println(s);
		 return s;
		//return title;	
	}
	
	public boolean checkLogo() {
		boolean logocheck= logo.isDisplayed();
		return logocheck;
		
	}
	
	public LoginPage login() {
	    loginLink.click();
		return loginPage;
			
	}

}

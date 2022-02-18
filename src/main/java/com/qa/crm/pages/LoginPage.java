package com.qa.crm.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.TestBase;
import com.qa.crm.util.LibaryUtils;

public class LoginPage extends TestBase {
	
	
	DashboardPage dashboardpage;

	@FindBy(xpath="//input[@name='email']")
	WebElement username;

    @FindBy(xpath="//input[@name='password']")
    WebElement password;
    
    @FindBy(xpath="//div[contains(text(),Login) and @class='ui fluid large blue submit button']")
    WebElement loginBtn;

    @FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
    WebElement forgotpassowrd;

    @FindBy(xpath="//a[contains(text(),'Sign Up')]")
    WebElement signUp;

   public LoginPage(WebDriver loginpageDriver) throws FileNotFoundException {
	this.driver=loginpageDriver;
	PageFactory.initElements(driver, this);
	// TODO Auto-generated constructor stub
	///dashboardpage =new DashboardPage();
   }

   public DashboardPage logintoDashboard(String un,String ps) throws InterruptedException, FileNotFoundException {
	   //LibaryUtils.waitforElementToBeVisible(driver, username,3).sendKeys(un);
	   username.sendKeys(un);
	   Thread.sleep(3000);
	   password.clear();
	  if( password.isDisplayed()) {
		 System.out.println("Password filed is present");
		 password.sendKeys(ps);
	  }
	  else {
		  System.out.println("Password filed is not present");
	  }
	   //LibaryUtils.waitforElementToBeVisible(driver,password,3).sendKeys(ps);
	   
	   Thread.sleep(3000);
	   loginBtn.click();
	   Thread.sleep(3000);
	   return new DashboardPage(driver);
   }
    public DashboardPage logintodashboardwithLogin() throws InterruptedException {
    	
    	username.sendKeys(prop.getProperty("username"));
		Thread.sleep(3000);
		password.clear();
		  if( password.isDisplayed()) {
			 System.out.println("Password filed is present");
			 password.sendKeys(prop.getProperty("password"));
		  }
		  else {
			  System.out.println("Password filed is not present");
		  }
		  Thread.sleep(3000);
		  loginBtn.click();
		  Thread.sleep(3000);
    	return dashboardpage;
    	
    }
    
   public boolean forgetpasswordLink() {
	   return forgotpassowrd.isDisplayed();
	   
  }
 
   public void  signup() {
	    signUp.click();
	   
   }


}
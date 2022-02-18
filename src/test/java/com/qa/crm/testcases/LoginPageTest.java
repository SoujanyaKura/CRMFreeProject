package com.qa.crm.testcases;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.DashboardPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;

public class LoginPageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	DashboardPage dashboardpage;
	
	
	public LoginPageTest() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setup() throws FileNotFoundException, InterruptedException {
		IntializeBrowser();
		homepage = new HomePage(driver);
		loginpage =new LoginPage(driver);
		dashboardpage=new DashboardPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3, 1));
		driver.manage().deleteAllCookies();
		homepage.login();
		Thread.sleep(2000);
		
		
	}
	
	@Test(priority=1)
	public void loginWithValidDetails() throws InterruptedException, FileNotFoundException {
		
		System.out.println(prop.getProperty("username")+","+prop.getProperty("password"));
		
		dashboardpage=loginpage.logintoDashboard(prop.getProperty("username"), prop.getProperty("password"));
	    
		//Assert.assertFalse(loginpage.forgetpasswordLink());
		
	}
	
	@Test(priority=2)
	public void loginWithOutUserName() throws InterruptedException, FileNotFoundException {
		
		dashboardpage=loginpage.logintoDashboard(" ", prop.getProperty("password"));
	    
		Assert.assertTrue(loginpage.forgetpasswordLink());
		
	}
	
	@Test(priority=3)
	public void loginWithOutPassword() throws InterruptedException, FileNotFoundException {
		
		dashboardpage=loginpage.logintoDashboard(prop.getProperty("username")," ");
	    
		Assert.assertTrue(loginpage.forgetpasswordLink());
		
	}
	
	@Test(priority=4)
	public void loginWithBothNull() throws InterruptedException, FileNotFoundException {
		
		dashboardpage=loginpage.logintoDashboard(" "," ");
	    
		Assert.assertTrue(loginpage.forgetpasswordLink());
		
	}
	
	
	@AfterMethod
	public void teardown() {
	
	driver.quit();
	}

}

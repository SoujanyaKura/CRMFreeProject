package com.qa.crm.testcases;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	HomePage homepage;
	LoginPage loginpage;
	/**
	 * @throws FileNotFoundException 
	 * 
	 */
	public HomePageTest() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws FileNotFoundException {
		  
		IntializeBrowser();
		homepage = new HomePage(driver);
		loginpage = new LoginPage(driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	@Test
	public void verifyTitle() throws InterruptedException {
		
		String title= homepage.getTitleofpage();
		//System.out.println(title);
		Assert.assertEquals(title,"Free CRM software for customer relationship management, sales, marketing campaigns and support.");
		
		
	}
	
	@Test
	public void checkLogo() {
		
		Assert.assertTrue(homepage.checkLogo());
	}
	
	
	@Test
	public void login() throws InterruptedException {
		loginpage = homepage.login();
		Thread.sleep(2000);
		Assert.assertEquals(homepage.getTitleofpage(),"Cogmeno CRM");
		
		//Assert.assertFalse(homepage.checkLogo());
	}
	
	
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}

}

package com.qa.crm.testcases;

import java.io.FileNotFoundException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.DashboardPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;

public class DashboardPageTest extends TestBase{
	HomePage homepage;
	LoginPage loginpage;
	DashboardPage dashboardpage;
	
	
	public DashboardPageTest() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	} 

	
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
		Thread.sleep(5000);
		loginpage.logintodashboardwithLogin();
		Thread.sleep(3000);	
		
	}
	
	@Test
	public void verifytitle() {
		String s=dashboardpage.getTitle();
		Assert.assertEquals(s,"Cogmento CRM");
		
	}
	
	@Test
	public void checklogo() {
		Assert.assertTrue(dashboardpage.checklogo());
	}
	
	@Test
	public void clickOnNewDeals() {
		dashboardpage.newdeal();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}

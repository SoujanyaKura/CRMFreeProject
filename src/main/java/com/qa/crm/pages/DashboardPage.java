package com.qa.crm.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.TestBase;

public class DashboardPage extends TestBase {
	
	NewDealsPage newDealpage;
	@FindBy(xpath="//a[@class='item' and @href='/home']")
	WebElement sideBarHome;
	
	@FindBy(xpath="//a[@class='item' and @href='/deals']")
	WebElement deals;
	
	@FindBy(xpath="(//button[@class='ui mini basic icon button']//i[@class='plus inverted icon'])[4]")
	WebElement addNewDeal;
	
	@FindBy(xpath="//div[@class='header item']")
	WebElement logo;
	
//	public DashboardPage(WebDriver dashboardpageDriver) {
//		this.driver=dashboardpageDriver;
//		PageFactory.initElements(driver, this);
//	}

	public DashboardPage(WebDriver dashboardpageDriver) throws FileNotFoundException {
		this.driver=dashboardpageDriver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	
	public String getTitle() {
		return driver.getTitle();
		
	}
	
	public boolean checklogo() {
		return logo.isDisplayed();
		
		
	}
	
	public NewDealsPage newdeal() {
		//action.moveToElement(deals).build().perform();
		addNewDeal.click();
		return new NewDealsPage();
	}
	
	

}

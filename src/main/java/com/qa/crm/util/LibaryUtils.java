package com.qa.crm.util;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LibaryUtils {
	
	//@SuppressWarnings("deprecation")
	public static WebElement waitforElementToBeVisible(WebDriver driver,WebElement webElement, int seconds) {
		//@SuppressWarnings("deprecation")
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(seconds, 1));
		WebElement element =wait.until(ExpectedConditions.visibilityOf(webElement));
		return element;
	}

	
	//@SuppressWarnings("deprecation")
	public static WebElement waitforElementToClickable(WebDriver driver,WebElement webElement, int seconds) {
		//@SuppressWarnings("deprecation")
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(seconds, 1));
		WebElement element =wait.until(ExpectedConditions.elementToBeClickable(webElement));
		return element;
	}

}

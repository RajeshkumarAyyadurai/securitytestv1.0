package com.pages.project.security;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddAccountPage {
	// declarations
		private static WebElement element = null;
		
		// page locators
		public static final String txt_accountName = "//input[@id='name']";
		public static final String txt_accountEmail = "//input[@id='email']";
		public static final String txt_accountAlias = "//input[@id='contactnumber']";
		public static final String btn_save = "//input[@id='ibutton']";
		
		// page functions
		public static WebElement fnEnterAccountName(WebDriver driver){
			element = driver.findElement(By.xpath(txt_accountName));
		return element;
		}
		
		public static WebElement fnEnterAccountAliasName(WebDriver driver){
			element = driver.findElement(By.xpath(txt_accountAlias));
		return element;
		}
		
		public static WebElement fnEnterEmail(WebDriver driver){
			element = driver.findElement(By.xpath(txt_accountEmail));
		return element;
		}
		
		public static WebElement fnClickSave(WebDriver driver){
			element = driver.findElement(By.xpath(btn_save));
		return element;
		}
		
		public static WebElement fnEnterSecondAddress(WebDriver driver){
			element = driver.findElement(By.xpath(""));
		return element;
		}
		
		public static WebElement fnEnterCity(WebDriver driver){
			element = driver.findElement(By.xpath(""));
		return element;
		}
		
		public static WebElement fnEnterState(WebDriver driver){
			element = driver.findElement(By.xpath(""));
		return element;
		}
		
		public static WebElement fnEnterCountry(WebDriver driver){
			element = driver.findElement(By.xpath(""));
		return element;
		}
		
		public static WebElement fnClickCopyBillingAddress(WebDriver driver){
			element = driver.findElement(By.xpath(""));
		return element;
		}
}

package com.pages.project.security;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	// declarations
	private static WebElement element = null;
	
	// page locators
	public static final String txt_username = "//input[@id='inputEmail']";
	public static final String txt_password = "//input[@id='inputPassword']";
	public static final String btn_login = "//button[@id='signIn']";
	public static final String str_pleaseSignIn = "//h2[text()='Please sign in']";
	
	// page functions
	public static WebElement fnEnterUserName(WebDriver driver){
		element = driver.findElement(By.xpath(txt_username));
	return element;
	}
	
	public static WebElement fnEnterPassword(WebDriver driver){
		element = driver.findElement(By.xpath(txt_password));
	return element;
	}
	
	public static WebElement fnClickLogin(WebDriver driver){
		element = driver.findElement(By.xpath(btn_login));
	return element;
	}
	
	public static WebElement fnVerifySignInPageAppears(WebDriver driver){
		element = driver.findElement(By.xpath(str_pleaseSignIn));
	return element;
	}
}

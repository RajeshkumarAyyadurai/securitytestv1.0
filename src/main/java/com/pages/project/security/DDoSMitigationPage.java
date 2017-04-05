package com.pages.project.security;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DDoSMitigationPage {
	// declarations
	private static WebElement element = null;
	
	// page locators
	public static final String txt_search = "//input[@id='Inputsearch']";
	public static final String txt_searchResult = "";
	public static final String btn_configuration = "";
	
	// page functions
	public static WebElement fnSearchAccount(WebDriver driver, String text){
		element = driver.findElement(By.linkText(text));
	return element;
	}
}

package com.pages.project.security;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DDoSConfigurationPage {
	// declarations
	private static WebElement element = null;
	
	// page locators
	public static final String str_DDoSMitigation = "//h3[text()='Domain Configuration']";
	public static final String txt_domainName = "(//input[@id='exampleInputEmail1'])[1]";
	public static final String txt_hostName = "(//input[@id='exampleInputEmail1'])[2]";;
	public static final String txt_destination = "//input[@id='exampleInputPassword1']";
	public static final String btn_submitConfiguration = "//button[@id='submit']";
	
	// page functions
	public static WebElement fnVerifyDDoSMitigationPageAppears(WebDriver driver){
		element = driver.findElement(By.xpath(""));
	return element;
	}
	
	public static WebElement fnEnterDomainName(WebDriver driver){
		element = driver.findElement(By.xpath(txt_domainName));
	return element;
	}
	
	public static WebElement fnEnterHostName(WebDriver driver){
		element = driver.findElement(By.xpath(txt_hostName));
	return element;
	}
	
	public static WebElement fnEnterDestination(WebDriver driver){
		element = driver.findElement(By.xpath(txt_destination));
	return element;
	}
	
	public static WebElement fnSubmitConiguration(WebDriver driver){
		element = driver.findElement(By.xpath(btn_submitConfiguration));
	return element;
	}
}

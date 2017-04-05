package com.pages.project.security;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdministrationPage {
	// declarations
		private static WebElement element = null;
		
		// page locators
		public static final String select_adminService = "//a[@class='dropdown-toggle']";
		public static final String select_ddosService = "//ul[@class='dropdown-menu']/li";
		public static final String lnk_services = "//a[@href='#dnsaction']";
		public static final String select_services = "//select[@id='ddoschange']";
		public static final String lnk_assign = "";
		public static final String str_securityLogo = "//a[@class='navbar-brand']";
		public static final String btn_addAccount = "//div[@class='well']/span/button";
		public static final String txt_search = "//input[@id='Inputsearch']";
		public static final String btn_search = "//button[@id='SearchButton']";
		public static final String lnk_searchResult = "//div[@id='ajaxGetUserServletResponse']/div/ul/li[1]/a";
		public static final String btn_closePopup = "(//button[@id='buttonID'])[1]";
		
		// page functions
		public static WebElement fnSelectService(WebDriver driver){
			element = driver.findElement(By.xpath(select_services));
		return element;
		}
		
		public static WebElement fnVerifyAdminPageAppears(WebDriver driver){
			element = driver.findElement(By.xpath(str_securityLogo));
		return element;
		}
		
		public static WebElement fnClickServices(WebDriver driver){
			element = driver.findElement(By.xpath(lnk_services));
		return element;
		}
		
		public static WebElement fnClickAddAccount(WebDriver driver){
			element = driver.findElement(By.xpath(btn_addAccount));
		return element;
		}
		
		public static WebElement fnSearchAccount(WebDriver driver){
			element = driver.findElement(By.xpath(txt_search));
		return element;
		}
		
		public static WebElement fnClickSearchResult(WebDriver driver, String text){
			element = driver.findElement(By.linkText(text));
		return element;
		}
		
		public static WebElement fnAssignServices(WebDriver driver){
			element = driver.findElement(By.xpath(""));
		return element;
		}
		
		public static WebElement fnSelectAdminService(WebDriver driver){
			element = driver.findElement(By.xpath(select_adminService));
		return element;
		}
		
		public static WebElement fnSelectDDoSService(WebDriver driver){
			element = driver.findElement(By.xpath(select_ddosService));
		return element;
		}
		
		public static WebElement fnClosePopup(WebDriver driver){
			element = driver.findElement(By.xpath(btn_closePopup));
		return element;
		}
}

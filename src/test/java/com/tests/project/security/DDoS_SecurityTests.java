package com.tests.project.security;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.pages.project.security.DDoSMitigationPage;
import com.pages.project.security.LoginPage;
import com.pages.project.security.AdministrationPage;
import com.pages.project.security.AddAccountPage;
import com.pages.project.security.DDoSConfigurationPage;

public class DDoS_SecurityTests {
	private static WebDriver driver = null;
	//private String URL = "http://ec2-54-254-182-212.ap-southeast-1.compute.amazonaws.com:8080/security";
	private String URL = "http://ec2-54-254-182-212.ap-southeast-1.compute.amazonaws.com:8080/bamboo";
	private String userName = "admin";
	private String password = "admin";
	private String alias = "ad";
	public WebDriverWait wait;
	
	public String generateAccName(){
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
		return "Test"+dateFormat.format(new Date());
	}
	
	@Test
	public void testSubmitDDoSConfiguration() throws InterruptedException{
		// variables
		String accountName = generateAccName();
		String email = accountName+"@gmail.com";
		
		String projectBaseDir = System.getProperty("user.dir");
		System.setProperty("phantomjs.binary.path", projectBaseDir+"/lib/drivers/phantomjs");
		driver = new PhantomJSDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		
		// login to application
		LoginPage.fnVerifySignInPageAppears(driver).isDisplayed();
		LoginPage.fnEnterUserName(driver).sendKeys(userName);
		LoginPage.fnEnterPassword(driver).sendKeys(password);
		LoginPage.fnClickLogin(driver).click();
		wait = new WebDriverWait(driver, 30);
		WebElement addacc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='well']/span/button")));//"//div[@class='well']/span/button"
		addacc.click();
		
		// create account
		Thread.sleep(3000);
		AddAccountPage.fnEnterAccountName(driver).sendKeys(accountName);
		AddAccountPage.fnEnterEmail(driver).sendKeys(email);
		AddAccountPage.fnEnterAccountAliasName(driver).sendKeys(alias);
		AddAccountPage.fnClickSave(driver).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='buttonID'])[1]")));
		AdministrationPage.fnClosePopup(driver).click();
		driver.navigate().refresh();
		
		// search account
		Thread.sleep(3000);
		AdministrationPage.fnClickSearchResult(driver, accountName).click();
		
		// assign service
		AdministrationPage.fnClickServices(driver).click();
		Select assignServices = new Select(AdministrationPage.fnSelectService(driver));
		assignServices.selectByVisibleText("Assign");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='buttonID'])[1]")));
		AdministrationPage.fnClosePopup(driver).click();
		
		// search account in ddos mitigation
		Thread.sleep(2000);
		driver.get("http://ec2-54-254-182-212.ap-southeast-1.compute.amazonaws.com:8080/bamboo/accountdetails.jsp?account_name="+accountName+"");
		//driver.findElement(By.linkText("testaccount")).click();
		//System.out.println("ddos page");
		
		
		// submit configuration
		DDoSConfigurationPage.fnEnterDomainName(driver).sendKeys("abcd.com");
		DDoSConfigurationPage.fnEnterHostName(driver).sendKeys("qa.abcd.com");
		DDoSConfigurationPage.fnEnterDestination(driver).sendKeys("12.32.65.45");
		DDoSConfigurationPage.fnSubmitConiguration(driver).click();
	}
	
	@AfterSuite
	public void killBrowser(){
		driver.quit();
	}
}

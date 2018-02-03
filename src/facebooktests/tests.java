package facebooktests;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import facebookmethods.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;

public class tests {
	static WebDriver driver;

	methods method;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver_win32\\chromedriver.exe");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
	}
	@Test
	public void loginTest(){
		
		
		method.login(driver);
		
		assert(driver.getTitle().equals("Facebook"));
		}
	@Test
	public void logoutTest() {
		method.login(driver);
		method.logout(driver);
		assert(driver.getTitle().equals("Facebook - Log In or Sign Up"));
		
	}
	@Test
	public void incorrectEmailTest() {
		driver.get("https://www.facebook.com");
		WebElement email = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("pass"));
		WebElement logIn = driver.findElement(By.id("loginbutton"));
		
		email.sendKeys("wdasdad");
		password.sendKeys("REAL_PASSWORD_HERE");
		
		logIn.click();
		
		assert(driver.getTitle().equals("Log into Facebook | Facebook"));
		
	}
	@Test
	public void blankEmailTest() {
		driver.get("https://www.facebook.com");
		WebElement password = driver.findElement(By.name("pass"));
		WebElement logIn = driver.findElement(By.id("loginbutton"));
		
		password.sendKeys("REAL_PASSWORD_HERE");
		
		logIn.click();
		
		assert(driver.getTitle().equals("Log into Facebook | Facebook"));
	}
	@Test
	public void testNewsFeed() {
		method.login(driver);
		method.clickNewsFeed(driver);
		
		assert(driver.getTitle().equals("Facebook"));
	}
	@After
	public void end(){
		driver.close();
		driver.quit();
	}
	
	

}

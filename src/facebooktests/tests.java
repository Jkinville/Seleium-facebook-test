package facebooktests;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
	public static void login() {
		driver.get("https://www.facebook.com");
		WebElement email = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("pass"));
		
		email.sendKeys("johnathonk.jk@gmail.com");
		password.sendKeys("3ndl355n1ght");
		
		WebElement logIn = driver.findElement(By.id("loginbutton"));
		
		logIn.click();
		
	}
	public static void logout() {
		driver.findElement(By.id("userNavigationLabel")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(@data-gt,'menu_logout')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
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
		
		
		login();
		
		assert(driver.getTitle().equals("Facebook"));
		driver.close();
		}
	@Test
	public void logoutTest() {
		login();
		logout();
		assert(driver.getTitle().equals("Facebook - Log In or Sign Up"));
		driver.close();
		
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

	
	

}

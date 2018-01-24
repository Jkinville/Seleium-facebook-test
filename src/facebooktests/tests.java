package facebooktests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class tests {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com");
		WebElement email = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("pass"));
		
		email.sendKeys("EMAIL_HERE");
		password.sendKeys("PASSWORD_HERE");
		
		WebElement logIn = driver.findElement(By.id("loginbutton"));
		
		logIn.click();
	}

}

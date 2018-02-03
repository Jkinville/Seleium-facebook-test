package facebookmethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class methods {
	public static void login(WebDriver driver) {
		driver.get("https://www.facebook.com");
		WebElement email = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("pass"));
		/*TO FIX: 
		replace with config*/
		email.sendKeys("EMAIL_HERE");
		password.sendKeys("PASS HERE");
		
		WebElement logIn = driver.findElement(By.id("loginbutton"));
		
		logIn.click();
		
	}
	
	public static void logout(WebDriver driver) {
		driver.findElement(By.id("userNavigationLabel")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(@data-gt,'menu_logout')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public static void clickNewsFeed(WebDriver driver) {
		driver.findElement(By.linkText("News Feed")).click();
		
	}

}

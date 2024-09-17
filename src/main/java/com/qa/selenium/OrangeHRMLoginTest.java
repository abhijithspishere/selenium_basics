package com.qa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMLoginTest { 
	
public static void main(String[] args) throws InterruptedException { 
	
	WebDriverManager.chromedriver().setup();

	WebDriver driver = new ChromeDriver();

	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	driver.manage().window().maximize();

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));

	username.sendKeys("Admin");

	WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));

	password.sendKeys("admin123");

	WebElement LoginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));

	LoginButton.click();

	WebElement sucessMessage = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']"));

	if (sucessMessage.isDisplayed()) 
	{
		System.out.println("Login Success");	
	}
	else
	{
		System.out.println("Login Failed");
	}

	driver.quit();	
}
}

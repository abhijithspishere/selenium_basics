package com.qa.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
        userName.sendKeys("student");

        WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
        passWord.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();

        WebElement loginSuccess = driver.findElement(By.xpath("//h1[normalize-space()='Logged In Successfully']"));
        if (loginSuccess.getText().equals("Logged In Successfully")) {
            System.out.println("Login_Success");
            
        } else {
            System.out.println("Login Failed");
        }

        driver.quit();
        System.out.println("Browser Closed");

    }
}

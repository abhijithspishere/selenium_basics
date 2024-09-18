package com.qa.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URL;
import java.net.URI;
import java.net.MalformedURLException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigation {
    public static void main(String[] args) throws MalformedURLException {
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
         
        URI uri = URI.create("https://demo.opencart.com/");
        URL myUrl = uri.toURL();

        driver.navigate().to(myUrl);
        driver.manage().window().maximize();
        System.out.println("Navigated to opencart");

        driver.navigate().to("https://testautomationpractice.blogspot.com/");
        System.out.println("Navigated to testAutomationPractice");

        driver.navigate().back();
        System.out.println("Navigated back to opencart");

        driver.navigate().forward();
        System.out.println("Navigated again to testAutomationPractice");

        driver.navigate().refresh();
        System.out.println("Refreshed to samePage");

        driver.quit();
        System.out.println("Browser Closed");
      
    }
}



 

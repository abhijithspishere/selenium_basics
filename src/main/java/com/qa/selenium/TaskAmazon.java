package com.qa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TaskAmazon {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement menuBar = 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='hm-icon nav-sprite']")));
        menuBar.click();

        WebElement menuComputer = 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='Mobiles, Computers']")));
        menuComputer.click();
        System.out.println("click1");

        WebElement menuLaptop =
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Laptops')]")));
        menuLaptop.click();

        WebElement checkBoxApple = 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='apb-browse-refinements-checkbox_7']//i[@class='a-icon a-icon-checkbox']")));
        checkBoxApple.click();
    }
}

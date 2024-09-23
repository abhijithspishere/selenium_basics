package com.qa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TaskAmazon {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement menuBar = 
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='hm-icon nav-sprite']")));
        menuBar.click();
        // System.out.println("click1");

        // Thread.sleep(10);

        WebElement menuComputer = 
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='Mobiles, Computers']")));
        menuComputer.click();
        // System.out.println("click2");
       
        
        /* WebElement menuLaptop =
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Laptops')]")));
        menuLaptop.click(); */

        WebElement menuLaptop = 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Laptops')]")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", menuLaptop);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", menuLaptop);

        
        WebElement checkBoxApple = 
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='apb-browse-refinements-checkbox_7']//i[@class='a-icon a-icon-checkbox']")));
        checkBoxApple.click();

        List<WebElement> allButton = driver.findElements(By.tagName("button"));

        int addToCartCount = 0;
        
        for (WebElement eachButton : allButton) {
            String buttonLink = eachButton.getText().trim();
            // System.out.println(buttonLink);

            if (buttonLink.equalsIgnoreCase("Add to Cart")) {
                addToCartCount++;
            //    System.out.println(addToCartCount);
            }
            if (addToCartCount==1) {
                ((JavascriptExecutor)driver).executeScript("arguments[0].click();", eachButton);
                break;
            }
        }
    }
}

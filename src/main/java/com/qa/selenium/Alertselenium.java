package com.qa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.Alert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Alertselenium {
    public static void main(String[] args) {
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        WebDriverWait wait = 
        new WebDriverWait(driver, Duration.ofSeconds(10));

        //Alert having only Ok button
        /* WebElement simpleAlert = 
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='Click for JS Alert']")));
        simpleAlert.click();
        // driver.switchTo().alert().accept();

        //Fetching Text from Alert
        Alert myAlert = driver.switchTo().alert();
        // String alertText = myAlert.getText();
        System.out.println(myAlert.getText());
        myAlert.accept(); */

        //Alert having ok and cancel button
        /* WebElement alert2 = 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Click for JS Alert']")));
        alert2.click();

        Alert myAlert2 = driver.switchTo().alert();
        // myAlert2.accept();
        myAlert2.dismiss();
        // System.out.println("accepted");
        System.out.println("rejected"); */

        //Prompt Alert Input Box
        WebElement alert3 = 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Click for JS Prompt']")));
        alert3.click();

        /* Alert myAlert3 = driver.switchTo().alert();
        myAlert3.sendKeys("Welcome");
        myAlert3.accept(); */
        
        //Alert using wait method
        Alert myAlert3 = wait.until(ExpectedConditions.alertIsPresent());
        myAlert3.sendKeys("Welcome");
        myAlert3.accept();



    }
}

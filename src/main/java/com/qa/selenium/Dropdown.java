package com.qa.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement dropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='country']")));
        
        Select dropCountry = new Select(dropDown);

        // dropCountry.selectByVisibleText("France");

        // dropCountry.selectByValue("japan");

        dropCountry.selectByIndex(1);

        // dropCountry.deselectAll();

        //Fetching Dropdown Elements
        List<WebElement> options = dropCountry.getOptions();
        System.out.println("Total options available in Dropdown : "+options.size());

        for (WebElement opt : options) {
          String op =  opt.getText();
          System.out.println(op);

          if (opt.getText().equals("France")) {
            opt.click();
          }
        
        }




    }
}

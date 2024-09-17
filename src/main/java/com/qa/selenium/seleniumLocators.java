package com.qa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class seleniumLocators {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Locator : ID
        WebElement elementByID = driver.findElement(By.id("submit"));
        elementByID.click();

        //Locator : NAME
        WebElement elementByName = driver.findElement(By.name("toggle-navigation"));
        elementByName.click();

        //Locator : CLASSNAME
        WebElement elementByClassName = driver.findElement(By.className("examplename"));
        elementByClassName.click();

        //Locator : TAGNAME
        WebElement elementByTagName = driver.findElement(By.tagName("button"));
        elementByTagName.click();

        //Locator : LINKTEXT
        WebElement elementByLinkText =  driver.findElement(By.linkText("Click Here"));
        elementByLinkText.click();

        //Locator : PARTIAL LINKTEXT
        WebElement elementByParLinkText =  driver.findElement(By.linkText("Click This"));
        elementByParLinkText.click();

        //Locator : CSS Selector
        WebElement elementByCSS =  driver.findElement(By.linkText("#username"));
        elementByCSS.click();

        //Locator : XPATH
        WebElement elementByXpath =  driver.findElement(By.linkText("//input[@id='password']"));
        elementByXpath.click();

        driver.quit();

    }
}

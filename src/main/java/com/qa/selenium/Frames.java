package com.qa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();

        WebDriverWait wait = 
        new WebDriverWait(driver,Duration.ofSeconds(10));

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
        // driver.switchTo().frame(0);

        WebElement textBox = 
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='mytext1']")));
        textBox.sendKeys("This is 1st frame text");

        driver.switchTo().defaultContent();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));

        WebElement textBox2 =
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='mytext2']")));
        textBox2.sendKeys("This is 2nd frame text");

        driver.switchTo().defaultContent();

        //inner frame
        WebElement frame3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//frame[@src='frame_3.html']")));
        driver.switchTo().frame(frame3);
        System.out.println("reached frame3");

      /*   WebElement checkBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='mytext3']")));
        checkBox.sendKeys("hi"); */
 
        driver.switchTo().frame(0);
        System.out.println("reached innerframe");
        WebElement checkBox = driver.findElement(By.xpath("//div[@class='AB7Lab Id5V1']"));
        checkBox.click();
        System.out.println("clicked");
    }
}

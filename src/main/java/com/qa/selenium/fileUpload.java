package com.qa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class fileUpload {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.uitestingplayground.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement fileUploadLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='File Upload']")));
        fileUploadLink.click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
        System.out.println("Switched to frame");

        // Click the 'Browse files' button to open the file dialog
        WebElement browseButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Browse files']")));
        browseButton.click();

        // Wait for the file dialog to open
        try {
            Thread.sleep(1000); // Adjust if necessary
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Use Robot to send the file path
        try {
            Robot rb = new Robot();

            // Copy the file path to the clipboard
            StringSelection str = new StringSelection("D:\\img\\asp.jpg");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

            // Paste the file path
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);
            rb.keyRelease(KeyEvent.VK_V);
            rb.keyRelease(KeyEvent.VK_CONTROL);

            // Press Enter to confirm
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Optional: Wait to observe the result
        try {
            Thread.sleep(3000); // Adjust as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // driver.quit(); // Uncomment to close the browser after execution
    }
}

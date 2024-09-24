package com.qa.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWindows {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        
        WebDriverWait myWait = 
        new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement windLink = 
        myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")));
        windLink.click();

        //APPROACH NO : 1
        //Used only one or two windows are there.
        Set <String> windowIds=driver.getWindowHandles();

        //We cannot fetch individual windowIDs using Set so we use List
        /* List <String> windowList = new ArrayList<>(windowIds);//now it is separated with unique windowIDs.

        String parentID = windowList.get(0);
        String childID = windowList.get(1);
        
        driver.switchTo().window(childID);
        System.out.println(driver.getTitle());

        driver.switchTo().window(parentID);
        System.out.println(driver.getTitle());
 */
        //Approach NO : 02

        for (String wID : windowIds) {
            String title = driver.switchTo().window(wID).getTitle();
            if (title.equals("OrangeHRM")) {
                System.out.println(driver.getTitle());
            } else {
                System.out.println(driver.getTitle());
            }
        }




    }
}

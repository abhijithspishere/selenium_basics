package com.qa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class seleniumAction {

public static void main(String[] args) {
    
    WebDriverManager.chromedriver().setup();

    WebDriver driver  = new ChromeDriver();

//Mouse Hover Click Using Action Class
    /* driver.get("https://demo.opencart.com/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    WebElement desktops = driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle'][normalize-space()='Desktops']"));
    WebElement mac = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
    Actions action = new Actions(driver);
    action.moveToElement(desktops).moveToElement(mac).click().perform(); 
    */


//Mouse Right Click using Action
/* driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

WebElement rightClickButton = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

Actions action = new Actions(driver);
action.contextClick(rightClickButton).perform();

WebElement copyButton = driver.findElement(By.xpath("//span[normalize-space()='Copy']"));
copyButton.click();

driver.switchTo().alert().accept(); */


//Mouse Double Click using Action 
/* driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3"); 
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
driver.manage().window().maximize();

driver.switchTo().frame("iframeResult");

WebElement box1 = driver.findElement(By.xpath("//input[@id='field1']"));
WebElement box2 = driver.findElement(By.xpath("//input[@id='field2']"));

box1.clear();
box1.sendKeys("Athul");


WebElement copyText =  driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));

Actions action = new Actions(driver);
action.doubleClick(copyText).perform();

if (box1.getAttribute("value").equals(box2.getAttribute("value"))) {
    System.out.println("Success");
}
else
{
    System.out.println("Failed");
} */


//Mouse Drag and Drop
driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

Actions action = new Actions(driver);

WebElement Stockholm = driver.findElement(By.xpath("//div[@id='box2']"));

WebElement Sweden = driver.findElement(By.xpath("//div[@id='box102']"));

action.dragAndDrop(Stockholm,Sweden).perform();


driver.quit();


}

}
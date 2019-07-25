package com.cybertek;

import com.cybertek.utilities.SeleniumUtils;
import com.cybertek.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Brite_ERP{

     WebDriver driver;

     String usernameInputLocator = "#login";
     String passwordInputLocator = "#password";
     String LoginButtonLocator = "//button[@type ='submit']";
     String PurchaseModuleLocator = "//a[@href='/web#menu_id=504&action=']";
     String CreateButtonLocator = "//button[@accesskey='c']";
     String VendorInputLocator = "//div[@class='o_input_dropdown']/input[@class='o_input ui-autocomplete-input']";
     String AddAnItemLocator = "//a[starts-with(text(),'Add an item')]";
     String productDropdownLocator = "//*[@class='tab-pane active']/div[1]/div[2]/table/tbody/tr[1]/td[2]/div/div/input";
     String QuantityLocator = "//input[@name='product_qty']";
     String UnitPriceLocator = "//input[@name='price_unit']";
     String SendButtonLocator = "//button[contains(text(),'Send RFQ by Email')]";
     String SendEmailX = "//button[@class='btn btn-sm btn-primary o_mail_send']";


    @BeforeMethod
    public void setup(){
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();

         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


     }


     @Test
     public void RfqPoInPurchaseFunctionality() {

         //step 1 open the URL
         driver.get("http://34.220.250.213/web/login");

         //Enter username and password in enter box
         //then click on login button
         WebDriverWait wait = new WebDriverWait(driver, 10);
         //wait until input box user name is visible
         //it works only for element that you provided
         wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(usernameInputLocator))));
         driver.findElement(By.cssSelector(usernameInputLocator)).sendKeys("posmanager45@info.com");
         driver.findElement(By.cssSelector(passwordInputLocator)).sendKeys("posmanager");
         driver.findElement(By.xpath(LoginButtonLocator)).click();

         // Step 3 Click Purchase on top menu bar

         // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(PurchaseModuleLocator))));
         driver.findElement(By.xpath(PurchaseModuleLocator)).click();
         SeleniumUtils.waitPlease(2);

         // Step 4 click on create button on RFQ feature
         driver.findElement(By.xpath(CreateButtonLocator)).click();

         //Step 5 Click Send RFQ by Email button

         WebElement selectElement = driver.findElement(By.xpath(VendorInputLocator));

         selectElement.click();
         selectElement.sendKeys("ACD (copy)");
         SeleniumUtils.waitPlease(1);
         selectElement.sendKeys(Keys.DOWN);
         SeleniumUtils.waitPlease(1);
         selectElement.sendKeys(Keys.ENTER);


         driver.findElement(By.xpath(AddAnItemLocator)).click();
         WebElement element2 = driver.findElement(By.xpath(productDropdownLocator));
         element2.sendKeys("iphone");
         SeleniumUtils.waitPlease(1);
         element2.sendKeys(Keys.DOWN);
         SeleniumUtils.waitPlease(1);
         element2.sendKeys(Keys.DOWN);
         SeleniumUtils.waitPlease(1);
         element2.sendKeys(Keys.ENTER);


         WebElement element3 = driver.findElement(By.xpath(QuantityLocator));
         element3.clear();
         element3.sendKeys("200.00");
         SeleniumUtils.waitPlease(1);

         WebElement element4 = driver.findElement(By.xpath(UnitPriceLocator));
         element4.clear();
         SeleniumUtils.waitPlease(1);
         element4.sendKeys("200.00");
         SeleniumUtils.waitPlease(1);

         driver.findElement(By.xpath(SendButtonLocator)).click();
         SeleniumUtils.waitPlease(2);
         driver.findElement(By.xpath(SendEmailX)).click();


     }

     @AfterMethod
    public void teardown(){
         driver.quit();

     }

 }

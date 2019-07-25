package com.cybertek.tests.day10;

import com.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MultipleButtonsTestsWithCSSSelector {

    //// **************INDEX OF ELEMENTS:*****************


    String button1Locator = "[onclick='button1()']";
    String button2Locator = ".btn.btn-primary:nth-of-type(2)";
    String button3Locator = "[id^='button_']";
    String button4Locator = "[id$='_button'][onclick='button4()']";
    String button5Locator = "[onclick*='5']";
    String button6Locator = "#disappearing_button";
    String resultLocator = "#result";

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
    }

    @Test (priority = 1, description="verifying button 1", enabled = true)
    public void button1Test(){
        driver.findElement(By.cssSelector(button1Locator)).click();
        String expectedMessage = "Clicked on button one!";
        String actualMessage = driver.findElement(By.cssSelector(resultLocator)).getText();
        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @Test (priority = 2, dependsOnMethods = {"button1Test"})  // will indicates methods that affect current, it that method
                                                              //fail it will ignore method with dependency
    public void button2Test(){
        driver.findElement(By.cssSelector(button2Locator)).click();
        String expectedMessage = "Clicked on button two!";
        String actualMessage = driver.findElement(By.cssSelector(resultLocator)).getText();
        Assert.assertEquals(actualMessage,expectedMessage);
        SeleniumUtils.waitPlease(2);
       // throw new SkipException("I don't want ot run this test"); // will skipp the test

    }

    @Test (priority = 3)
    public void button3Test(){
        driver.findElement(By.cssSelector(button3Locator)).click();
        String expectedMessage = "Clicked on button three!";
        String actualMessage = driver.findElement(By.cssSelector(resultLocator)).getText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Ignore  // will ignore the test
    @Test (priority = 4)
    public void button4Test(){
        driver.findElement(By.cssSelector(button4Locator)).click();
        String expectedMessage = "Clicked on button four!";
        String actualMessage = driver.findElement(By.cssSelector(resultLocator)).getText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }



    @Test (priority = 5)
    public void button5Test(){
        driver.findElement(By.cssSelector(button5Locator)).click();
        String expectedMessage = "Clicked on button five!";
        String actualMessage = driver.findElement(By.cssSelector(resultLocator)).getText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
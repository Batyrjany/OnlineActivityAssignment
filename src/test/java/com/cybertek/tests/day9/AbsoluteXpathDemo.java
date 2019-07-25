package com.cybertek.tests.day9;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AbsoluteXpathDemo {


    private WebDriver driver ;

    String fullNameLocator = "html/body/div/div[2]/div/div/form/div/div[1]/input[@name='full_name']";
    String emailLocator = "html/body/div/div[2]/div/div/form/div/div[1]/input[@name='email']";
    String signUpButton = "html/body/div/div[2]/div/div/form/button";
    @BeforeMethod
    public void setup(){

        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");
    }

    @Test
    public void test(){
        driver.findElement(By.xpath(fullNameLocator)).sendKeys("Java GURU");
        driver.findElement(By.xpath(emailLocator)).sendKeys("tomsmith@email.com");
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath(signUpButton)).click();
        SeleniumUtils.waitPlease(2);
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        String actualMessage = driver.findElement(By.xpath("html/body/div/div[2]/div/div/h3")).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void negativeEmailTest(){
        String expectedLink = driver.getCurrentUrl();
        driver.findElement(By.xpath(fullNameLocator)).sendKeys("Tom Smith");
        driver.findElement(By.xpath(emailLocator)).sendKeys("email");
        driver.findElement(By.xpath(signUpButton)).click();
        SeleniumUtils.waitPlease(2);
        String actualLink =  driver.getCurrentUrl();
        Assert.assertEquals(actualLink,expectedLink);


    }

    @AfterMethod
    public void teardown(){
        driver.quit();

    }
}

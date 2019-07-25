package com.cybertek.tests.day11_vytrack;

import com.cybertek.utilities.SeleniumUtils;
import com.cybertek.utilities.VYTrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CreateButtonTests {

    WebDriver driver;
    String createButtonLocator = "a[title='Log call']";
    String createCalenderEventButtonLocator = "a[title='Create Calendar event']";

    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

  @Test (priority = 1)
    public void storeManagerTest(){
      VYTrackUtils.login(driver,"storemanager85","UserUser123");
      SeleniumUtils.waitPlease(2);
      VYTrackUtils.navigateToModule(driver, "Activities","Calls");
      SeleniumUtils.waitPlease(6);
      Assert.assertTrue(driver.findElement(By.cssSelector(createButtonLocator)).isDisplayed());
      SeleniumUtils.waitPlease(2);

      VYTrackUtils.navigateToModule(driver,"Activities","Calendar Events");
      SeleniumUtils.waitPlease(6);
      Assert.assertTrue(driver.findElement(By.cssSelector(createCalenderEventButtonLocator)).isDisplayed());
      SeleniumUtils.waitPlease(2);


  }
  @Test (priority = 2)
    public void salesManagerTest(){
        VYTrackUtils.login(driver,"salesmanager253","UserUser123");
        SeleniumUtils.waitPlease(2);
        VYTrackUtils.navigateToModule(driver, "Activities","Calls");
        SeleniumUtils.waitPlease(6);
        Assert.assertTrue(driver.findElement(By.cssSelector(createButtonLocator)).isDisplayed());
        SeleniumUtils.waitPlease(2);

        VYTrackUtils.navigateToModule(driver,"Activities","Calendar Events");
        SeleniumUtils.waitPlease(6);
        Assert.assertTrue(driver.findElement(By.cssSelector(createCalenderEventButtonLocator)).isDisplayed());
        SeleniumUtils.waitPlease(2);


    }




}

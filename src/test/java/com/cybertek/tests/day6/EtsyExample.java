package com.cybertek.tests.day6;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class EtsyExample {
    static WebDriver driver  = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        test();
    }


    public static void test(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://etsy.com");

        WebElement element = driver.findElement(By.id("global-enhancements-search-query"));

        //*[@id="content"]/ul/li[1]/a
    }
}

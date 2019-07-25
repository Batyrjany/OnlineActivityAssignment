package com.cybertek.tests.day13_actions_jsexecutor;

import com.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorTests {

    WebDriver driver;

    @BeforeMethod

    public void setup(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void jsExecutorTest1(){
        driver.get("http://practice.cybertekschool.com/");
        //we want to run some javascript code
        //for this, we have to use Javascript interface
        //Since it;s an interface, we cannot create an object
        //we just have to cast webdriver
        JavascriptExecutor js=(JavascriptExecutor)driver;
        //and then to execute script itself
        //we call executeScript()method
        //executeScript returns an object
        String title=(String) js.executeScript("return document.title");
        //or you can execute some script without any return
        js.executeScript("alert('Hello Spartans!!!')");
        SeleniumUtils.waitPlease(2);
        //Alert interface hadles alerts
        //what is alert?
        //It looks like pop up window
        Alert alert =driver.switchTo().alert();
        //we can use accept 9) method to select Ok in the pop up
        alert.accept();
        SeleniumUtils.waitPlease(3);
        System.out.println(title);
    }
    @Test
    public void scrollTest1(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for(int i=0; i< 11; i++) {
            js.executeScript("window.scrollBy(0, 250)");
            SeleniumUtils.waitPlease(1);
        }
    }
    @Test
    public void scrollTest2(){
        driver.get("http://practice.cybertekschool.com/");
        WebElement footerlink = driver.findElement(By.linkText("Cybertek School"));

        JavascriptExecutor js =(JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true)",footerlink);
        SeleniumUtils.waitPlease(2);

        js.executeScript("arguments[0].click",footerlink);

        SeleniumUtils.waitPlease(5);



    }

    @AfterMethod
    public void teardown(){

       // driver.quit();
    }
}

package com.cybertek.tests.day5;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocatorsPracticeClassName {



    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception{
        test5();
    }


    public static void test5() throws Exception{

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com");
        List<WebElement> listOfExamples = driver.findElements(By.className("list-group-item"));
        System.out.println("Element size : "+ listOfExamples.size());

        for (WebElement each:listOfExamples) {
            System.out.println(each.getText());
            Thread.sleep(3000);
        }
        driver.close();
    }

}

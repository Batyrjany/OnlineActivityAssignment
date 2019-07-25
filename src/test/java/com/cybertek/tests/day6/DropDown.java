package com.cybertek.tests.day6;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown {

    static WebDriver driver = BrowserFactory.getDriver("chrome");


    public static void main(String[] args) {

       test1();
      // driver.close();


    }

    public static void test1(){


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http:/the-internet.herokuapp.com/dropdown");
        SeleniumUtils.waitPlease(2);
        WebElement selectElement= driver.findElement(By.id("dropdown"));
        Select list  = new Select(selectElement);
        String selectedOption = list.getFirstSelectedOption().getText();
        System.out.println(selectedOption);
        List<WebElement> options = list.getOptions();
        System.out.println("option.size() = "+ options.size());

        for (WebElement option:options) {
            System.out.println(option.getText());
            
        }

// select diffrent options
        // 1. by visible text
        list.selectByVisibleText("Option 1");
        System.out.println("Selected option by text  : " + list.getFirstSelectedOption().getText());

        // 2. by Index
        list.selectByIndex(2);
        System.out.println("Selected option by index : " + list.getFirstSelectedOption().getText());

        // 2. by value attribute
        list.selectByValue("1");
        System.out.println("Selected option by value attribute : " + list.getFirstSelectedOption().getText());


    }


}

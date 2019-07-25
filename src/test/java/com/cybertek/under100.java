package com.cybertek;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;
public class under100 {

  static WebDriver driver = BrowserFactory.getDriver("chrome");


    public static void main(String[] args) {
test();
    }


    public static void test(){


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://amazon.com");

        WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
        element.sendKeys("iPhone"+Keys.ENTER);

        SeleniumUtils.waitPlease(2);


        List<WebElement> items =  driver.findElements(By.xpath("span[@class='a-price-whole']"));





    }

}

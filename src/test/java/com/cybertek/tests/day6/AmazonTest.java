package com.cybertek.tests.day6;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AmazonTest {

   static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void test1(){
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SeleniumUtils.waitPlease(2);
driver.get("http://amazon.com");
   String searchterm = "Charger";
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchterm+ Keys.ENTER);
String actual = driver.findElement(By.id("twotabsearchtextbox")).getAttribute("value");
if(searchterm.equals(actual)){
    System.out.println("Passed");
}else{
    System.out.println("Failed");

    System.out.println("actual : "+ actual);
}
        System.out.println("searchterm : "+ searchterm);


    }

    public static void main(String[] args) {
test1();
SeleniumUtils.waitPlease(2);
driver.close();
    }


}

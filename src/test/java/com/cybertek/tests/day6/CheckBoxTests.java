package com.cybertek.tests.day6;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CheckBoxTests {

    static WebDriver driver = BrowserFactory.getDriver("chrome");



    public static void main(String[] args) {


//test1();
        test2();
driver.close();


    }


    public static void openCheckBoxPage(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/checkboxes");
        //let's make sure that Checkboxes header is visible, not only in the code
        WebElement checkboxesLogo = driver.findElement(By.tagName("h3"));
        if(checkboxesLogo.isDisplayed()){
            System.out.println("Checkboxes logo is visible");
        }else{
            System.out.println("Checkboxes logo not found!");
        }
    }

    //verify  that checkbox 1 is not selected and checkbox 2 is selected
    public static void test1(){
        openCheckBoxPage();

        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        //to verify if checkbox 1 is not selected
       SeleniumUtils.waitPlease(2);
        if(!checkbox1.isSelected()){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }
        //to verify if checkbox 2 is selected

        if(checkbox2.isSelected()){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }

    }

    public static void test2(){
        openCheckBoxPage();

        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        //to verify if checkbox 2 is not selected

        SeleniumUtils.waitPlease(2);


        checkbox1.click();
        SeleniumUtils.waitPlease(2);

        checkbox2.click();
        SeleniumUtils.waitPlease(2);

        if(!checkbox2.isSelected()){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }
        //to verify if checkbox 2 is selected

        if(checkbox1.isSelected()){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }

    }
    }

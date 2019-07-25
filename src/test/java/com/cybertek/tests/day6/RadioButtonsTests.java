package com.cybertek.tests.day6;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class RadioButtonsTests {

    static WebDriver driver = BrowserFactory.getDriver("chrome");


    public static void main(String[] args) {

        openRadioButtonPage();

        //Test1();
        // test2();
          // test3();
        test4();
        driver.close();


    }

    public static void openRadioButtonPage(){

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/radio_buttons");
    }

    //let's check if blue radio button is selected
    public static void Test1(){
        WebElement blueBtn = driver.findElement(By.id("blue"));
        if(blueBtn.isSelected()){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }
        SeleniumUtils.waitPlease(2);
    }

    //let's check that green button is disabled, that means not clickable
    // and black button is clickable
    public static void test2(){
        WebElement blackBtn  = driver.findElement(By.id("black"));
        WebElement greenBTN = driver.findElement(By.id("green"));
        if(blackBtn.isEnabled() && (!greenBTN.isEnabled())){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }
        SeleniumUtils.waitPlease(2);

    }
    public static void test3(){

        WebElement blackBtn  = driver.findElement(By.id("black"));
        WebElement blueBTN = driver.findElement(By.id("blue"));

        if((blueBTN.isSelected())){

            System.out.println("PASSED");
            System.out.println("blue is selected");
        }else{
            System.out.println("FAILED");
            System.out.println("blue is not selected");

        }
        SeleniumUtils.waitPlease(2);

        blackBtn.click();
   if(blackBtn.isSelected()){
       System.out.println("PASSED");
       System.out.println("black is selected");

   }else{
       System.out.println("FAILED");
       System.out.println("black is not selected");

   }
        SeleniumUtils.waitPlease(2);

        if(!(blueBTN.isSelected())){

            System.out.println("PASSED");
            System.out.println("blue is not selected");
        }else{
            System.out.println("FAILED");
            System.out.println("blue is selected");

        }
        SeleniumUtils.waitPlease(2);

    }


    public static void test4(){
        List<WebElement> listOfRadioButtons = driver.findElements(By.xpath("//input[@type='radio']"));


    //let's create counter, to count
    //how many selected radio buttons
    int counter = 0;
    //we will go through list of web elements
    //and check one by one
    //which radio button is selected
    //if radio button is selected
    //increase counter
        for (WebElement radioButton: listOfRadioButtons){
        if(radioButton.isSelected()){
            //get id of selected radio button
            System.out.println(radioButton.getAttribute("id"));
            counter++;
        }
    }
        SeleniumUtils.waitPlease(2);

        System.out.println(counter);

}
}


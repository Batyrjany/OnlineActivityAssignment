package com.cybertek;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class OnlineActivityAssignment {

    private static final String actualUserName = "tomsmith";
    private static final String actualPassword = "SuperSecretPassword";

    public static String getActualUserName() {
        return actualUserName;
    }

    public static String getActualPassword() {
        return actualPassword;
    }

    static WebDriver driver = BrowserFactory.getDriver("chrome");


    public static void main(String[] args) {


        //  VyTrackLoginLogout();
        //validcybertekschoolLogin();
        invalidcybertekschoolLogin();
       // driver.close();
    }

    public static void VyTrackLoginLogout() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");

        SeleniumUtils.waitPlease(2);

        driver.findElement(By.xpath("//input[@id='prependedInput']")).sendKeys("user153");
        driver.findElement(By.xpath("//input[@id='prependedInput2']")).sendKeys("UserUser123");
        driver.findElement(By.xpath("//button[@id='_submit']")).click();
        SeleniumUtils.waitPlease(2);

        driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
        SeleniumUtils.waitPlease(2);

        driver.findElement(By.xpath("//a[@class='no-hash']")).click();
        SeleniumUtils.waitPlease(2);


    }

    public static void validcybertekschoolLogin() {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/login");

        WebElement element = driver.findElement(By.tagName("h2"));
        if (element.isDisplayed()) {
            System.out.println("Login page is displayed successfully");
            driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");
            SeleniumUtils.waitPlease(2);

            driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword");
            SeleniumUtils.waitPlease(2);

            driver.findElement(By.xpath("//button[@id='wooden_spoon']")).click();
            SeleniumUtils.waitPlease(2);

        } else {
            System.out.println("oops, sorry, try again");
        }

        WebElement element1 = driver.findElement(By.xpath("//h4[@class='subheader']"));

        if (element1.getText().contains("Welcome to the Secure Area. When you are done click logout below.")) {

            System.out.println("Logged into the page successfully");
            SeleniumUtils.waitPlease(2);
            driver.findElement(By.xpath("//a[@class='button secondary radius']")).click();

            SeleniumUtils.waitPlease(2);

            WebElement element2 = driver.findElement(By.xpath("//div[@class='flash success']"));

            if (element2.getText().contains("You logged out of the secure area!")) {
                System.out.println("Logged out successfully");

            } else {
                System.out.println("Unsecured Area");
            }

            SeleniumUtils.waitPlease(2);


        }

    }

    public static void invalidcybertekschoolLogin() {


        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter invalid user name: ");
        String randomName = scanner.nextLine();
        System.out.print("Please enter invalid password : ");
        String randomPassword = scanner.nextLine();



            if (!(randomName.equals(OnlineActivityAssignment.getActualUserName()))
                    || !(randomPassword.equals(OnlineActivityAssignment.getActualPassword()))) {
                System.out.println("Well, Random Credentials don't match actual ones, that's what we need for negative test");

                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.get("http://practice.cybertekschool.com/login");

                SeleniumUtils.waitPlease(2);

                WebElement element = driver.findElement(By.tagName("h2"));
                WebElement element1 = driver.findElement(By.xpath("//input[@name='username']"));
                WebElement element2 = driver.findElement(By.xpath("//input[@name='password']"));

                if (element.isDisplayed()) {
                    System.out.println("Login page is displayed successfully");

                    element1.sendKeys(randomName);
                    SeleniumUtils.waitPlease(2);
                    element2.sendKeys(randomPassword);
                    SeleniumUtils.waitPlease(2);
                    driver.findElement(By.xpath("//button[@id='wooden_spoon']")).click();

                    if (driver.findElement(By.xpath("//div[@id='flash']")).getText().contains("invalid")) {
                        System.out.println("You are still on the same page, that means you were unable to login " +
                                "that is what was expected");
                    } else {
                        System.out.println("You should not be able to login with invalid credentials, " +
                                "a bug should be reported...");
                    }


                } else {
                    System.out.println("oops, sorry, try again...");
                }


            } else if (randomName.equals(OnlineActivityAssignment.getActualUserName())
                    && randomPassword.equals(OnlineActivityAssignment.getActualPassword())) {
                System.out.println("At least one Invalid Credential should be used for this negative case " +
                        "please try again...");
            }

        }
    }


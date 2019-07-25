package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class VYTrackUtils {

    public static String usernamelocator="prependedInput";
    public static String passwordlocator ="prependedInput2";
    public static String loginButtonLocator = "_submit";
    private static String loaderMaskLocator = "div[class='loader-mask shown']";



    public static void login(WebDriver driver, String username, String password){

        Driver.getDriver().findElement(By.id(usernamelocator)).sendKeys(username);
        Driver.getDriver().findElement(By.id(passwordlocator)).sendKeys(password);
        Driver.getDriver().findElement(By.id(loginButtonLocator)).click();
        SeleniumUtils.waitPlease(3);

    }

    public static void navigateToModule(WebDriver driver, String tab, String module){

        String tabLocator = "//span[contains(text(),'"+tab+"') and contains(@class, 'title title-level-1')]";
        String moduleLocator = "//span[contains(text(),'"+module+"') and contains(@class, 'title title-level-2')]";

        //driver.findElement(By.xpath(tabLocator)).click();

       SeleniumUtils.clickWithWait(driver,By.xpath(tabLocator),5);
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.xpath(moduleLocator)).click();
       // SeleniumUtils.clickWithWait(driver,By.xpath(moduleLocator),5);

        SeleniumUtils.waitPlease(2);

    }
    public static void waitUntilLoaderScreenDisappear(WebDriver driver){
       try {
           WebDriverWait wait = new WebDriverWait(driver, Long.valueOf(ConfigurationReader.getProperty("explicitwait")));
           wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(loaderMaskLocator))));
       }catch (Exception e){
           System.out.println(e+ " :: Loader mask doesn't present");
       }
    }




}

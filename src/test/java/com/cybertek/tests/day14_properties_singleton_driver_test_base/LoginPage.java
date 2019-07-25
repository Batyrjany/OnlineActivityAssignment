package com.cybertek.tests.day14_properties_singleton_driver_test_base;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
public class LoginPage {
    String userNameLocator = "prependedInput";
    String passwordLocator = "prependedInput2";
    String loginButtonLocator = "_submit";
    public void login(String username, String password){
        Driver.getDriver().findElement(By.id(userNameLocator)).sendKeys(username);
        Driver.getDriver().findElement(By.id(passwordLocator)).sendKeys(password);
        Driver.getDriver().findElement(By.id(loginButtonLocator)).click();
    }
}
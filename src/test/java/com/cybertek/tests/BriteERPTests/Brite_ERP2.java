package com.cybertek.tests.BriteERPTests;


import com.cybertek.utilities.*;
import com.cybertek.utilities.BriteUtils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Brite_ERP2 extends TestBase{

   public WebDriver driver = Driver.getDriver();

    public static String usernamelocator="login";
    public static String passwordlocator ="password";
    public static String loginButtonLocator = "//button[@type='submit']";



    String username = ConfigurationReader.getProperty("manufacturerusername");

    String password = ConfigurationReader.getProperty("manufacturerpassword");

    String ManufacturingX = "//span[contains(text(),'Manufacturing')]";
    String CreateButtonX = "//button[contains(text(),'Create')]";
    String ProductInputCss = "body > div.o_main > div.o_main_content > div.o_content > div > div > div > div.o_form_sheet_bg > div.o_form_sheet > div.o_group > table:nth-child(1) > tbody > tr:nth-child(4) > td:nth-child(2) > div > div > span";
    String QuantityX= "//input[@class='o_field_float o_field_number o_field_widget o_input o_required_modifier']";
    String BOMCss = "body > div.o_main > div.o_main_content > div.o_content > div > div > div > div.o_form_sheet_bg > div.o_form_sheet > div.o_group > table:nth-child(1) > tbody > tr:nth-child(7) > td:nth-child(2) > div > div > span";
    String DeadlineButtonCss ="body > div.o_main > div.o_main_content > div.o_content > div > div > div > div.o_form_sheet_bg > div.o_form_sheet > div.o_group > table:nth-child(2) > tbody > tr:nth-child(1) > td:nth-child(2) > div > span";



    public static void login(WebDriver driver, String username, String password){

        Driver.getDriver().findElement(By.id(usernamelocator)).sendKeys(username);
        Driver.getDriver().findElement(By.id(passwordlocator)).sendKeys(password);
        Driver.getDriver().findElement(By.xpath(loginButtonLocator)).click();
        SeleniumUtils.waitPlease(3);
    }


  @Test
   public  void Test(){
        login(driver,username,password);




   }



}

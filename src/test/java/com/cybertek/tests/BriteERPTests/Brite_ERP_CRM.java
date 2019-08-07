package com.cybertek.tests.BriteERPTests;


import com.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Brite_ERP_CRM {

    WebDriver driver;

    String usernameInputLocator = "#login";
    String passwordInputLocator = "#password";
    String LoginButtonLocator = "//button[@type ='submit']";
    String CRMModuleLocator = "//span[@class=contains(text(),'CRM')]";
    String CreateButtonLocator = "//button[@class='btn btn-primary btn-sm o-kanban-button-new']";
    String OpportunityTitleInputLocator = "//input[@class='o_field_char o_field_widget o_input o_required_modifier']";
    String CustomerLocator = "//input[@class='o_input ui-autocomplete-input']";
    String RevenueLocator = "//input[@class='o_field_float o_field_number o_field_widget o_input']";
    String PriorityLocator ="//a[@class='o_priority_star fa fa-star'][3]";
    String CreateOpportunityLocator = "//button[@class='btn btn-sm btn-primary']";
    String ListLocator = "//button[@class='btn btn-icon fa fa-lg fa-list-ul o_cp_switch_list']";
    String CheckboxLocator = "body > div.o_main > div.o_main_content > div.o_content > div > div > div > table > tbody > tr:nth-child(1) > td.o_list_record_selector > div > input[type=checkbox]";
    String ActionDropdownLocator = "//button[contains(text(),'Action')]";
    String OkCss = "//span[.='Ok']";
    String  ConfirmCss="span[class='o_pager_limit']";




    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }


    @Test
    public void RfqPoInPurchaseFunctionality(){

        //step 1 open the URL
        driver.get("http://34.220.250.213/web/login");

        //Step 2 Enter username and password in enter box
        //then click on login button
        WebDriverWait wait = new WebDriverWait(driver, 10);


        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(usernameInputLocator))));
        driver.findElement(By.cssSelector(usernameInputLocator)).sendKeys("eventscrmmanager46@info.com");
        driver.findElement(By.cssSelector(passwordInputLocator)).sendKeys("eventscrmmanager");
        driver.findElement(By.xpath(LoginButtonLocator)).click();

        // Step 3 Click CRM on top menu bar
        driver.findElement(By.xpath(CRMModuleLocator)).click();
        driver.findElement(By.xpath(CreateButtonLocator)).click();
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath(OpportunityTitleInputLocator)).sendKeys("Laptop");
        WebElement element = driver.findElement(By.xpath(CustomerLocator));
        element.sendKeys("Customer");
        element.sendKeys(Keys.ENTER);
        WebElement element1 = driver.findElement(By.xpath(RevenueLocator));
        element1.clear();
        element1.sendKeys("50000");
       // driver.findElement(By.xpath(PriorityLocator)).click();
        driver.findElement(By.xpath(CreateOpportunityLocator)).click();

        SeleniumUtils.waitPlease(3);

        driver.findElement(By.xpath(ListLocator)).click();
        SeleniumUtils.waitPlease(2);

        String prestatement = driver.findElement(By.cssSelector(ConfirmCss)).getText();
        driver.findElement(By.cssSelector(CheckboxLocator)).click();

        driver.findElement(By.xpath(ActionDropdownLocator)).click();
        SeleniumUtils.waitPlease(2);

        driver.findElement(By.linkText("Delete")).click();
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath(OkCss)).click();
        SeleniumUtils.waitPlease(2);

        String after = driver.findElement(By.cssSelector(ConfirmCss)).getText();

        int init = Integer.parseInt(prestatement);
        int eventually = Integer.parseInt(after);
        Assert.assertTrue(init>eventually);


    }

    @AfterMethod
    public void teardown(){
        //driver.quit();

    }

}

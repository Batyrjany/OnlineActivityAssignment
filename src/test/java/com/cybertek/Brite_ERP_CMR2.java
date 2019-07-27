package com.cybertek;


import com.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Brite_ERP_CMR2 {

    WebDriver driver;

    String usernameInputLocator = "#login";
    String passwordInputLocator = "#password";
    String LoginButtonLocator = "//button[@type ='submit']";
    String CRMModuleLocator = "//span[@class=contains(text(),'CRM')]";
    String PivotLocator = "//button[@class='btn btn-icon fa fa-lg fa-table o_cp_switch_pivot']";
    String NewExpandLocator = "//td[contains(text(),'New')]";
    String OpportunityLocator = "//a[@href=contains(text(),'Opportunity')]";
    String SecondItemLocator = "//table[@class='table-hover table-condensed table-bordered']/tbody/tr[4]/td[1]";
    String SecondItemValueLocator = "//table[@class='table-hover table-condensed table-bordered']/tbody/tr[4]/td[2]";
    String ViewListButtonLocator = "//button[@class='btn btn-icon fa fa-lg fa-list-ul o_cp_switch_list']";
    String TableLocator = "//button[@class='btn btn-icon fa fa-lg fa-list-ul o_cp_switch_list']";







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
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath(PivotLocator)).click();
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath(NewExpandLocator)).click();
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath(OpportunityLocator)).click();
        SeleniumUtils.waitPlease(2);

        WebElement element =  driver.findElement(By.xpath(SecondItemLocator));
        String item = element.getText();
        WebElement element1 =  driver.findElement(By.xpath(SecondItemValueLocator));
        String value = element1.getText();
        driver.findElement(By.xpath(ViewListButtonLocator)).click();

        //System.out.println(  getColumnData("Opportunity"));
        String Op = "Opportunity";

       List <String> columnData = getColumnData(Op);
         int length = columnData.size();
         int count = 0;

        for (int i=0; i<length; i++) {
           // System.out.println(str);

            if(columnData.get(i).equals(item)){
                count=i;
               // System.out.println(columnData.get(i));
            }
        }
        System.out.println(count);

        String expRev = "Expected Revenue";
        List<String> columnData1 = getColumnData(expRev);
        //int length1 = columnData1.size();
        String expected = value;
        String actual = columnData1.get(count);

        Assert.assertEquals(actual,expected);

        System.out.println(actual);
        System.out.println(value);




//        driver.findElement(By.xpath(CreateButtonLocator)).click();
//        SeleniumUtils.waitPlease(2);
//        driver.findElement(By.xpath(OpportunityTitleInputLocator)).sendKeys("Laptop");
//        WebElement element = driver.findElement(By.xpath(CustomerLocator));
//        element.sendKeys("Customer");
//        element.sendKeys(Keys.ENTER);
//        WebElement element1 = driver.findElement(By.xpath(RevenueLocator));
//        element1.clear();
//        element1.sendKeys("50000");
//       // driver.findElement(By.xpath(PriorityLocator)).click();
//        driver.findElement(By.xpath(CreateOpportunityLocator)).click();
//
//        SeleniumUtils.waitPlease(3);
//
//        driver.findElement(By.xpath(ListLocator)).click();
//        SeleniumUtils.waitPlease(2);
//
//        String prestatement = driver.findElement(By.cssSelector(ConfirmCss)).getText();
//        driver.findElement(By.cssSelector(CheckboxLocator)).click();
//
//        driver.findElement(By.xpath(ActionDropdownLocator)).click();
//        SeleniumUtils.waitPlease(2);
//
//        driver.findElement(By.linkText("Delete")).click();
//        SeleniumUtils.waitPlease(2);
//        driver.findElement(By.xpath(OkCss)).click();
//        SeleniumUtils.waitPlease(2);
//
//        String after = driver.findElement(By.cssSelector(ConfirmCss)).getText();
//
//        int init = Integer.parseInt(prestatement);
//        int eventually = Integer.parseInt(after);
//        Assert.assertTrue(init>eventually);


    }
    public List<WebElement> getHeaders() {

        return driver.findElements(By.xpath("//table[@class='o_list_view table table-condensed table-striped o_list_view_ungrouped']//th"));
    }


    public List<String> getHeadersText() {

        List<String> headers = new ArrayList<>();

        for (WebElement tableHeaders : getHeaders()) {

            headers.add(tableHeaders.getText());
        }

        return headers;

    }


    public int getCountOfColumns() {

        return driver.findElements(By.xpath("//table[@class='o_list_view table table-condensed table-striped o_list_view_ungrouped']//th")).size();
    }


    public List<String> getColumnData(String columnName) {

        int columnNumber = 0;

        for (int i = 0; i < getCountOfColumns(); i++) {

            if (columnName.equals(getHeadersText().get(i))) {
                columnNumber = i + 1;

            }
        }

        String locatorForColumn = "//table[@class='o_list_view table table-condensed table-striped o_list_view_ungrouped']//tbody//tr/td["+columnNumber+"]";

        List<WebElement> columnCollectionOfWebElements = driver.findElements(By.xpath(locatorForColumn));

        List<String> columnCollectionOfText = new ArrayList<>();
        for (WebElement element :
                columnCollectionOfWebElements) {
            columnCollectionOfText.add(element.getText());
        }
        return columnCollectionOfText;

    }
    @AfterMethod
    public void teardown(){
        //driver.quit();

    }

}

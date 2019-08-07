package com.cybertek.pages.BriteERP;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.SeleniumUtils;
import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class VerifyPriceAndTotalPage {

    @FindBy(id="#login")
    public static WebElement usernameInputLocator ;

    @FindBy(id="#password")
    public static WebElement passwordInputLocator;

    @FindBy(xpath="//button[@type ='submit']")
    public static WebElement LoginButtonLocator ;

    @FindBy(xpath="//span[@class = 'oe_menu_text' and contains(text(),'CRM')]")
    public static WebElement CRMModuleLocator ;

    @FindBy(xpath="//button[@type='button' and @aria-label='pivot']")
    public static WebElement PivotLocator ;

    @FindBy(xpath="//td[contains(text(),'New')]")
    public static WebElement NewExpandLocator;

    @FindBy(xpath="//a[@href=contains(text(),'Opportunity')]")
    public static WebElement OpportunityLocator;

    @FindBy(xpath="//table[@class='table-hover table-condensed table-bordered']/tbody/tr[4]/td[1]")
    public static WebElement SecondItemLocator ;

    @FindBy(xpath="//table[@class='table-hover table-condensed table-bordered']/tbody/tr[4]/td[2]")
    public static WebElement SecondItemValueLocator ;

    @FindBy(xpath="//button[@class='btn btn-icon fa fa-lg fa-list-ul o_cp_switch_list']")
    public static WebElement ViewListButtonLocator ;

    @FindBy(xpath="//h4[contains(text(),'Create an Opportunity')]")
    public static WebElement CreateOppPopupTitleX ;

    @FindBy(xpath="//button[@class='btn btn-primary btn-sm o-kanban-button-new']")
    public static WebElement CreateOpportunityLocator ;

    @FindBy(xpath="//input[@class='o_field_char o_field_widget o_input o_required_modifier']")
    public static WebElement OpportunityTitleInputLocator ;

    @FindBy(xpath="//input[@class='o_input ui-autocomplete-input']")
    public static WebElement CustomerLocator ;

    @FindBy(xpath="//input[@class='o_field_float o_field_number o_field_widget o_input']")
    public static WebElement RevenueLocator ;

    @FindBy(xpath="//button[@name='close_dialog']/span[contains(text(),'Create')]")
    public static WebElement CreateButtonLocator ;

    @FindBy(xpath="//table[@class='o_list_view table table-condensed table-striped o_list_view_ungrouped']//th")
    public static WebElement  TableHeaderLocator ;

    @FindBy(xpath="//table[@class='o_list_view table table-condensed table-striped o_list_view_ungrouped']")
    public static WebElement  TableLocator ;

    @FindBy(xpath="//button[@class='btn btn-icon fa fa-lg fa-list-ul o_cp_switch_list']")
    public static WebElement ListLocator ;

    @FindBy(css="body > div.o_main > div.o_main_content > div.o_content > div > div > div > table > tbody > tr:nth-child(1) > td.o_list_record_selector > div > input[type=checkbox]")
    public static WebElement CheckboxLocator ;

    @FindBy(xpath="//button[contains(text(),'Action')]")
    public static WebElement ActionDropdownLocator;

    @FindBy(xpath="//span[.='Ok']")
    public static WebElement OkCss;

    @FindBy(xpath="//span[class='o_pager_limit']")
    public static WebElement  ConfirmCss;

    public static WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Long.valueOf(ConfigurationReader.getProperty("explicitwait")));

    public static void PivotOpportunityClick(){
        wait.until(ExpectedConditions.elementToBeClickable(PivotLocator));
    PivotLocator.sendKeys(Keys.ENTER);
    SeleniumUtils.waitPlease(2);
    NewExpandLocator.click();
    SeleniumUtils.waitPlease(2);
    OpportunityLocator.click();
    SeleniumUtils.waitPlease(2);

    }

    public static void verifyRevenue(){

       String item = SecondItemLocator.getText();
       String value =  SecondItemValueLocator.getText();
        ViewListButtonLocator.click();

        String Op = "Opportunity";

        List<String> columnData = getColumnData(Op);
        int length = columnData.size();
        int count = 0;

        for (int i=0; i<length; i++) {


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


    }


    public static List<String> getHeadersText() {

        List<String> headers = new ArrayList<>();
        List<WebElement> getHeader = (List<WebElement>) TableHeaderLocator;

        for (WebElement tableHeaders : getHeader) {

            headers.add(tableHeaders.getText());
        }

        return headers;

    }


    public static List<String> getColumnData(String columnName) {

        int columnNumber = 0;
        List<WebElement> getHeader = (List<WebElement>) TableHeaderLocator;
        int countOfColumns = getHeader.size();

        for (int i = 0; i < countOfColumns; i++) {

            if (columnName.equals(getHeadersText().get(i))) {
                columnNumber = i + 1;

            }
        }

        String locatorForColumn = "//table[@class='o_list_view table table-condensed table-striped o_list_view_ungrouped']//tbody//tr/td["+columnNumber+"]";


        List<WebElement> columnCollectionOfWebElements = Driver.getDriver().findElements(By.xpath(locatorForColumn));

        List<String> columnCollectionOfText = new ArrayList<>();
        for (WebElement element :
                columnCollectionOfWebElements) {
            columnCollectionOfText.add(element.getText());
        }
        return columnCollectionOfText;

    }
    }




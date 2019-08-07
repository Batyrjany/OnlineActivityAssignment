package com.cybertek.tests.BriteERPTests;


import com.cybertek.pages.BriteERP.VerifyPriceAndTotalPage;
import com.cybertek.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.*;

public class Brite_ERP_CRM2 extends TestBase {
    public static WebDriver driver = Driver.getDriver();

    public static WebDriverWait wait = new WebDriverWait(driver, Long.valueOf(ConfigurationReader.getProperty("explicitwait")));

    String usernameInputLocator = "#login";
    String passwordInputLocator = "#password";
    String LoginButtonLocator = "//button[@type ='submit']";
    String CRMModuleLocator = "//span[@class = 'oe_menu_text' and contains(text(),'CRM')]";
    String PivotLocator = "//button[@class='btn btn-icon fa fa-lg fa-table o_cp_switch_pivot']";
    String NewExpandLocator = "//td[contains(text(),'New')]";
    String OpportunityLocator = "//a[@href=contains(text(),'Opportunity')]";
    String SecondItemLocator = "//table[@class='table-hover table-condensed table-bordered']/tbody/tr[4]/td[1]";
    String SecondItemValueLocator = "//table[@class='table-hover table-condensed table-bordered']/tbody/tr[4]/td[2]";
    String ViewListButtonLocator = "//button[@class='btn btn-icon fa fa-lg fa-list-ul o_cp_switch_list']";
    String CreateOppPopupTitleX = "//h4[contains(text(),'Create an Opportunity')]";

    String CreateOpportunityLocator = "//button[@class='btn btn-primary btn-sm o-kanban-button-new']";


    String OpportunityTitleInputLocator = "//input[@class='o_field_char o_field_widget o_input o_required_modifier']";
    String CustomerLocator = "//input[@class='o_input ui-autocomplete-input']";
    String RevenueLocator = "//input[@class='o_field_float o_field_number o_field_widget o_input']";
    String CreateButtonLocator = "//button[@name='close_dialog']/span[contains(text(),'Create')]";

    String TableHeaderLocator = "//table[@class='o_list_view table table-condensed table-striped o_list_view_ungrouped']//th";
    String TableLocator = "//table[@class='o_list_view table table-condensed table-striped o_list_view_ungrouped']";


    String ListLocator = "//button[@class='btn btn-icon fa fa-lg fa-list-ul o_cp_switch_list']";
    String CheckboxLocator = "body > div.o_main > div.o_main_content > div.o_content > div > div > div > table > tbody > tr:nth-child(1) > td.o_list_record_selector > div > input[type=checkbox]";
    String ActionDropdownLocator = "//button[contains(text(),'Action')]";
    String OkCss = "//span[.='Ok']";
    String ConfirmCss = "span[class='o_pager_limit']";


    // @Test
    public void ComparisonTest1() {

/*

User story:
The system should display the correct information for each opportunity on the view list page and the pivot table.


Acceptance Criteria:

1.Verify that second opportunity’ Expected Revenue value on the Pivot board should be
     the same as the Expected revenue column value on the list board.



 */


        BriteUtils.loginToPage();
        BriteUtils.navigateToModule(Driver.getDriver(), "CRM");


        driver.findElement(By.xpath(PivotLocator)).click();
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath(NewExpandLocator)).click();
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath(OpportunityLocator)).click();
        SeleniumUtils.waitPlease(2);

        WebElement element1 = driver.findElement(By.xpath(SecondItemLocator));
        String item = element1.getText();
        WebElement element2 = driver.findElement(By.xpath(SecondItemValueLocator));
        String value = element2.getText();
        driver.findElement(By.xpath(ViewListButtonLocator)).click();

        //System.out.println(  getColumnData("Opportunity"));
        String Op = "Opportunity";

        List<String> columnData = getColumnData(Op);
        int length = columnData.size();
        int count = 0;

        for (int i = 0; i < length; i++) {


            if (columnData.get(i).equals(item)) {
                count = i;
                // System.out.println(columnData.get(i));
            }
        }
        System.out.println(count);

        String expRev = "Expected Revenue";
        List<String> columnData1 = getColumnData(expRev);
        //int length1 = columnData1.size();
        String expected = value;
        String actual = columnData1.get(count);

        Assert.assertEquals(actual, expected);

        System.out.println(actual);
        System.out.println(value);


    }

    public List<WebElement> getHeaders() {

        return driver.findElements(By.xpath(TableHeaderLocator));
    }


    public List<String> getHeadersText() {

        List<String> headers = new ArrayList<>();

        for (WebElement tableHeaders : getHeaders()) {

            headers.add(tableHeaders.getText());
        }

        return headers;

    }


    public int getCountOfColumns() {

        return driver.findElements(By.xpath(TableHeaderLocator)).size();
    }


    public List<String> getColumnData(String columnName) {

        int columnNumber = 0;

        for (int i = 0; i < getCountOfColumns(); i++) {

            if (columnName.equals(getHeadersText().get(i))) {
                columnNumber = i + 1;

            }
        }

        String locatorForColumn = "//table[@class='o_list_view table table-condensed table-striped o_list_view_ungrouped']//tbody//tr/td[" + columnNumber + "]";


        List<WebElement> columnCollectionOfWebElements = driver.findElements(By.xpath(locatorForColumn));

        List<String> columnCollectionOfText = new ArrayList<>();
        for (WebElement element :
                columnCollectionOfWebElements) {
            columnCollectionOfText.add(element.getText());
        }
        return columnCollectionOfText;

    }


    @Test

    public void ComparisonTest2() {

        /*

User story:
      The system should display the correct information for each opportunity on the view list page and the pivot table.


Acceptance Criteria:

2. Verify that on the pivot table, the total expected revenue
       should be the sum of all opportunities’ expected revenue.



 */


        BriteUtils.loginToPage();
        BriteUtils.navigateToModule(Driver.getDriver(), "CRM");

//        for (int i = 1; i < 4; i++) {
//
//            driver.findElement(By.xpath(CreateOpportunityLocator)).click();
//            SeleniumUtils.waitPlease(1);
//
//            if (driver.findElement(By.xpath(CreateOppPopupTitleX)).isDisplayed()) {
//                Integer randomValue = (int) (Math.random() * 1000000L);
//                String str = randomValue + "";
//                Integer randomValue1 = (int) (Math.random() * 10);
//
//                driver.findElement(By.xpath(OpportunityTitleInputLocator)).sendKeys("Product " + randomValue1);
//
//                WebElement element = driver.findElement(By.xpath(CustomerLocator));
//                element.sendKeys("Customer " + randomValue1);
//                element.sendKeys(Keys.ENTER);
//
//                WebElement element1 = driver.findElement(By.xpath(RevenueLocator));
//                element1.click();
//                element1.clear();
//                element1.sendKeys(str);
//
//                driver.findElement(By.xpath("//table[@class='o_group o_inner_group o_group_col_6']/tbody/tr[4]/td[2]/div/a[" + i + "]")).click();
//                driver.findElement(By.xpath(CreateButtonLocator)).click();
//                SeleniumUtils.waitPlease(1);
//
//
//            }
//
//
//        }


        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath(PivotLocator)).click();
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath(NewExpandLocator)).click();
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath(OpportunityLocator)).click();
        SeleniumUtils.waitPlease(2);


        getRowData();


    }

    String ColumnLocator = "//table//thead//th";
    String expRev = "//th[contains(text(),'Expected Revenue')]";
    String columnExpRev = "Expected Revenue";
    String countHeader = "//th[contains(text(),'Count')]";
    String RowLocator = "//table[1]//tbody[1]//tr";
    String tdLocator = "//table//tbody//td";


    public void getRowData() {

        String count= Driver.getDriver().findElement(By.xpath("//table//tbody//tr[1]//td[3]")).getText();
        int  num=Integer.parseInt(count);
        String eachcell="";
        double eachTotal=0;
        for (int i = 0; i <num ; i++) {
            String cell=Driver.getDriver().findElement(By.xpath("//table[1]//tbody/tr["+(i+2)+"]/td[2]")).getText();
            String [] cellArray=cell.split(",");
            for (String each:cellArray
            ) {
                eachcell+=each;
            }
            double nums=Double.parseDouble(eachcell);
            eachTotal+=nums;
            eachcell="";
        }
        System.out.println(eachTotal);
    }


//
//        List<WebElement> td = driver.findElements(By.xpath(tdLocator));
//        List<String> lst1 = new ArrayList<>();
//        List<String> lst2 = new ArrayList<>();
//
//        int tl = td.size();
//        System.out.println("lst1.size() : " + tl);
//
//
//        for (WebElement eachtd : td) {
//            lst1.add(eachtd.getText());
//
//        }
//        System.out.print("lst1 : " + lst1);
//
//
//        for(int i = 1; i<tl-1 ;i+=3){
//            lst2.add(lst1.get(i));
//
//        }
//        System.out.println();
//        int l2 = lst2.size();
//        System.out.println("lst2.size() : "+l2);
//        System.out.println("lst2 : "+lst2);
//
//
//        String [] arr = new String [l2];
//
//        String each="";
//        double eachtotal=0;
//        for(String str:lst2){
//
//            each+=str;
//
//            arr=each.split(" ");
//
//        }
//        System.out.println("Splitted arr : " + Arrays.toString(arr));
//        double nums = Double.parseDouble(arr.toString());
//        eachtotal+=nums;
//        System.out.println(eachtotal);


//        double nums = Double.parseDouble(each);
//        eachtotal+=nums;


//        int count = driver.findElements(By.xpath(RowLocator)).size();
//
//        String str = "";
//
//        Double total = 0.0;
//
//        for (int j = 0; j < count-1; j++) {
//
//            String cell = driver.findElement(By.xpath("//table[1]//tbody[1]//tr[" + (j + 2) + "]//td[2]")).getText();
//            String[] arr = cell.split(",");
//
//            for (String each : arr) {
//                str += each;
//            }
//            double nums = Double.parseDouble(str);
//            total+=nums;
//
//
//        }
//        System.out.println(total);


//        double nums = Double.parseDouble(str);
//
//        System.out.println("each num : " + nums);
//        double eachTotal = 0;
//        eachTotal += nums;
//        System.out.println("total : " + eachTotal);
//
//
//        System.out.println();
//        System.out.println("String version : " + str);
//
//
//        String[] arr = str.split(" ");
//
//        System.out.println("Splitted arr : " + Arrays.toString(arr));

    }



//        double [] darray = new double[arr.length];
//
//
//        for (int i =0; i<arr.length; i++){
//
//            darray[i] = Double.parseDouble(arr[i]);
//        }
//        System.out.println(Arrays.toString(darray));
//
//        double d = 0;
//
//        float [] darray = new float[arr.length];
//
//
//        for (int i =0; i<arr.length; i++){
//
//            darray[i] = Float.parseFloat(arr[i]);
//        }
//        System.out.println(Arrays.toString(darray));
//
//        float d = 0f;
//
//for(int i = 0; i<darray.length;i++){
//
//    d+=darray[i];
//
//}
//        System.out.println(d);
//
//
//
package com.cybertek.tests.day17_webtables_day2;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class WebTableTests extends TestBase {


    public int getCountOfRows() {

        return driver.findElements(By.cssSelector("#table1 tr")).size();
    }


    public int getCountOfRows(By by) {

        return driver.findElements(by).size();
    }

    @Test

    public void CountOfRowsTest1() {
        Assert.assertEquals(getCountOfRows(), 5, "Number of rows doesn't match");


    }

    @Test

    public void CountOfRowsTest2() {
        Assert.assertEquals(getCountOfRows(By.xpath("//table[1]//tr")), 5, "Number of rows doesn't match");


    }

    public int getCountOfColumns() {

        return driver.findElements(By.cssSelector("#table1 th")).size();
    }


    public int getCountOfColumns(By by) {

        return driver.findElements(by).size();
    }

    @Test

    public void CountOfRColumnsTest1() {
        Assert.assertEquals(getCountOfColumns(), 6, "Number of columns doesn't match");


    }

    @Test

    public void CountOfColumnsTest2() {
        Assert.assertEquals(getCountOfColumns(By.xpath("//table[1]//th")), 6, "Number of columns doesn't match");


    }

    public int[] getTableSize() {

        int[] size = {getCountOfRows(), getCountOfColumns()};
        return size;

    }

    public int[] getTableSize(By rowLocator, By columnLocator) {

        int[] size = {getCountOfRows(rowLocator), getCountOfColumns(columnLocator)};
        return size;

    }


    @Test

    public void getTableSizeTest1() {
        int expectedSize[] = {5, 6};
        int actualSize[] = getTableSize();

        Assert.assertEquals(actualSize, expectedSize, "Table size doesn't match");

    }


    @Test

    public void getTableSizeTest2() {
        int expectedSize[] = {5, 6};
        int actualSize[] = getTableSize(By.xpath("//table[1]//tr"), By.xpath("//table[1]//th"));

        Assert.assertEquals(actualSize, expectedSize, "Table size doesn't match");

    }


    public List<WebElement> getHeaders() {

        return driver.findElements(By.cssSelector("#table1 th"));
    }


    public List<String> getHeadersText() {

        List<String> headers = new ArrayList<>();


        for (WebElement tableHeaders : getHeaders()) {

            headers.add(tableHeaders.getText());
        }

        return headers;

    }

    @Test

    public void getHeadersTest() {


        List<String> expectedColumnNames = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");

        Assert.assertEquals(getHeadersText(), expectedColumnNames);

    }


    @Test
    public void sortColumnTest() {
        String columnName = "First Name";

        driver.findElement(By.xpath("//table[1]//th//span[text()='"+columnName+"']")).click();

       // System.out.println(getColumnData("Due"));


        List<String> sorted = new ArrayList<>();
        sorted.addAll(getColumnData(columnName));
        Collections.sort(sorted);
        Assert.assertEquals(getColumnData(columnName),sorted);

    }

    public List<String> getColumnData(String columnName) {

        int columnNumber = 0;

        for (int i = 0; i < getCountOfColumns(); i++) {

            if (columnName.equals(getHeadersText().get(i))) {
                columnNumber = i + 1;

            }
        }
        String locatorForColumn = "//table[1]//tbody//tr//td[" + columnNumber + "]";
            List<WebElement> columnCollectionOfWebElements = driver.findElements(By.xpath(locatorForColumn));
            List<String> columnCollectionOfText = new ArrayList<>();


            for (WebElement element :
                    columnCollectionOfWebElements) {
                columnCollectionOfText.add(element.getText());
            }
        return columnCollectionOfText;
    }


    }












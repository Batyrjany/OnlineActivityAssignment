package com.cybertek.tests.excel_io_day2;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelDemo {

    //to create on object that will store excel file
    Workbook workbook;
    //to create an object that will store specific sheet
    Sheet sheet;
    //to provide path to the file
    String path = "/Users/batyrjany/IdeaProjects/TestAutomationSpring2019/src/test/resources/Countries.xlsx";
    //to establish connection with excel file
    FileInputStream inputStream;
    FileOutputStream fileOutputStream;
    @BeforeMethod
    public void setUp() throws IOException {
        inputStream = new FileInputStream(path);
        fileOutputStream = new FileOutputStream(path);
        workbook = WorkbookFactory.create(inputStream);
        sheet = workbook.getSheet("Countries");
    }
    @Test
    public void putDataIntoListOfMapsTest2() {

        List<Map<String,String>> table = new ArrayList<>();
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        for (int row = 1; row<=rowCount; row++){
            Map<String,String> map = new HashMap<>();

            for (int column = 0; column<colCount; column++) {
                String columnName = sheet.getRow(0).getCell(column).toString();
                String columnValue= sheet.getRow(row).getCell(column).toString();
                map.put(columnName,columnValue);

            }
            table.add(map);
        }

        for (Map<String,String> value : table){
            System.out.println(value);
        }

    }

    @Test
    public void writeDataTset(){

        Cell columName= sheet.getRow(0).getCell(2);
        if(columName == null){
            columName=sheet.getRow(0).createCell(2);
        }
        columName.setCellValue("Result");
        int rowCount = sheet.getLastRowNum();
        for (int row = 1 ; row<=rowCount ; row++){
            Row rowValue = sheet.getRow(row);
            Cell cell = rowValue.getCell(2);
            if(cell == null){
                cell.setCellValue("PASS");

            }
        }
    }

    @AfterMethod
    public void tearDown() throws IOException {
        workbook.write(fileOutputStream);
        workbook.close();
        inputStream.close();
    }
}


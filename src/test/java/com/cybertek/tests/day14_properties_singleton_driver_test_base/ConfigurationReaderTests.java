package com.cybertek.tests.day14_properties_singleton_driver_test_base;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfigurationReaderTests {


    @Test
    public void test1(){
        String expected = "chrome";
        String actual = ConfigurationReader.getProperty("browser");
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void test2(){
        String expectedUserName = "storemanager85";
        String actual = ConfigurationReader.getProperty("username");
        Assert.assertEquals(actual,expectedUserName);
    }
    @Test
    public void test3(){
        String expectedPassword = "UserUser123";
        String actual = ConfigurationReader.getProperty("password");
        Assert.assertEquals(actual,expectedPassword);
    }
    @Test
    public void test4(){
        String expectedURL = "http://qa2.vytrack.com/user/login";
        String actual = ConfigurationReader.getProperty("url");
        Assert.assertEquals(actual,expectedURL);
    }
    @Test
    public void test5(){
        String expectedURL = "20";
        String actual = ConfigurationReader.getProperty("explicitwait");
        Assert.assertEquals(actual,expectedURL);
    }
}

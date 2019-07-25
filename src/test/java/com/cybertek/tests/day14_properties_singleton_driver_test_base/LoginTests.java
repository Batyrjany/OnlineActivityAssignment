package com.cybertek.tests.day14_properties_singleton_driver_test_base;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TestBase;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
        LoginPage loginPage = new LoginPage();
        @Test
        public void loginTests1(){
            String username = ConfigurationReader.getProperty("username");
            String password = ConfigurationReader.getProperty("password");
            loginPage.login(username, password);
        }
    }

package com.cybertek.tests.day14_properties_singleton_driver_test_base;

import org.testng.annotations.Test;

import java.util.Map;
import java.util.Properties;

public class systemPropertiesTests {

    @Test
    public void systemPropertiestest1(){

        String os = System.getProperty("os.name");
        String username = System.getProperty("user.name");
        String javaVersion = System.getProperty("java.version");
        String homeDirectory = System.getProperty("user.home");

        System.out.println(os);
        System.out.println(username);
        System.out.println(javaVersion);
        System.out.println(homeDirectory);

        Properties properties = System.getProperties();
        for (Map.Entry <Object, Object> property : properties.entrySet()) {
            System.out.println("Key : " + property.getKey() + "  value : "+ property.getValue());
        }
    }
}

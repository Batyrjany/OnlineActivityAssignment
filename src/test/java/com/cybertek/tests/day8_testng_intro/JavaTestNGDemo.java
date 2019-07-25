package com.cybertek.tests.day8_testng_intro;


import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaTestNGDemo {



     @Test
    public void test1(){

        String a= "A";
        String b= "A";

        Assert.assertEquals(a,b);
    }

    @Test
    public void test2(){

        String c= "Apple";
        String d= "Orange";

        Assert.assertEquals(c,d);
        //Assert.assertEquals(d,c);
    }

    @Test
    public void test3(){
        String str1 = "ADAF";
        String str2 = "AAA";
        Assert.assertTrue(str1.contains(str2));
    }

    @Test
    public void test4(){
        Assert.assertFalse(false);
    }
}

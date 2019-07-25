package com.cybertek.tests.day4;

public class MyException extends RuntimeException {



    float f = 100F;
   // float f1 = (float) 1_11.00;
    float f2= 100;
    double y = 203.22;
   // float f3=y;
    int i = 203;
    float f4=(float)i;
}
class Test{


    public static void main(String[] args) {
        try{
            method1();
        }
        catch (MyException ne){
            System.out.println("A");
        }
    }


    public static void method1(){

        try{
            throw Math.random() > 0.5 ? new MyException(): new RuntimeException();
        }
        catch (RuntimeException re){
            System.out.println("B");
        }
    }

}
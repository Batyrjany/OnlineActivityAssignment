package com.cybertek.tests.day4;

public class examples {


  public void updatePrice(product p, double price){
      price=price*2;
      p.price = p.price+price;
  }

    public static void main(String[] args) {
        product prt = new product();
        prt.price=200;
        double newPrice = 100;

        examples e= new examples();
        e.updatePrice(prt,newPrice);
        System.out.println(prt.price+" : "+newPrice);



    }













 /*
    **************************************
    public static void main(String[] args) {
        int x= 5;

        while (isAvailable(x)){

            System.out.println(x);
       x--;

        }
    }

public static boolean isAvailable(int x){

        return x-- > 0 ? true:false;
}
   ***************************************

  */
}


class product{
    double price;
}


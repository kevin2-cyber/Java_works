package com.company;




import java.time.LocalDate;

import java.util.Date;


public class Main {

    public static void main(String[] args) {
        String name = "Kelvin";
        Date date = new Date();
        LocalDate now = LocalDate.now();
        int a = 10;
        int b = a;
        a = 100;

        System.out.println("a ="+ a +" - b ="+b);
        System.out.println("Hello World!");
        System.out.println(date);
        System.out.println(name.toUpperCase());
        System.out.println(now.getMonth());

        Person kelvin = new Person("Kelvin");
        System.out.println(kelvin.name + " is " + kelvin.name);
        kelvin.name = "Kevin";
        System.out.println(kelvin.name + " is " + kelvin.name);
        int numOf = 1;
        while (numOf < 20){
            System.out.println(numOf);
            numOf++;
        }
    }
    static class Person{
        String name;
        Person(String name) {
            this.name = name;
        }
    }
}

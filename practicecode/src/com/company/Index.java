package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Index {
    public static void main(String[] args){
        String name = "Company";
        Date date = new Date();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDateTime);
        System.out.println(localDate);
        System.out.println(date);
        System.out.println(name.toUpperCase());
        System.out.println(name.charAt(3));
        String texts = "Please locate where 'locate' occurs!";
        // Outputs 7
        System.out.println(texts.indexOf("locate"));
        String firstName = "John ";
        String lastName = "Doe";
        System.out.println(firstName.concat(lastName));
        String txt = "We are the so-called \"Vikings\" from the north.";
        System.out.println(txt);
        String tx = "Hello\nWorld!";
        System.out.println(tx);
        String text = "Hello\rWorld!";
        System.out.println(text);
        int randomNum = (int)(Math.random() * 101);  // 0 to 100
        System.out.println(randomNum);
        boolean isJavaFun = true;
        boolean isFishTasty = false;
        System.out.println(isJavaFun);
        System.out.println(isFishTasty);
        int time = 20;
        if (time < 18) {
            System.out.println("Good day.");
        } else {
            System.out.println("Good evening.");
        }
        int timeOfDay = 22;
        if (timeOfDay < 10) {
            System.out.println("Good morning.");
        } else if (timeOfDay < 20) {
            System.out.println("Good Afternoon.");
        }  else {
            System.out.println("Good evening.");
        }
        int timeOf = 20;
        String result;
        result = (timeOf < 18) ? "Good day." : "Good evening.";
        System.out.println(result);
        int day = 4;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
        }
        int weekend = 4;
        switch (weekend) {
            case 6:
                System.out.println("Today is Saturday");
                break;
            case 7:
                System.out.println("Today is Sunday");
                break;
            default:
                System.out.println("Looking forward to the Weekend");
        }
    }
}

// A console application is an application to work with data input and output in a command line
// With access to 3 basic data streams : standard input, standard output and standard error

package com.practice;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// Using the Scanner class
        /*Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        System.out.println(day);

        Parent ama = new Parent();
        System.out.println(ama.name());*/
        int car = 20;
        var hello = "How are you";
        float h = 1.2f;
        long l = 4;
        short s = 2;
        byte b = 1;
        char c = 'c';
        char c1 = 100;
        System.out.println(c1);
        boolean b1 = true;
        double d1 = 1.3;
        System.out.println(hello.toUpperCase(Locale.ROOT));
        System.out.println(car);
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextInt());
        System.out.println(cara());
    }

    public static int cara() {
        return 0;
    }
}

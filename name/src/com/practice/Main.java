// A console application is an application to work with data input and output in a command line
// With access to 3 basic data streams : standard input, standard output and standard error

package com.practice;

import java.util.Scanner;

public class Main {

    public static synchronized void main(String[] args) throws InterruptedException{
	// Using the Scanner class
        /*Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        System.out.println(day);

        Parent ama = new Parent();
        System.out.println(ama.name());*/
        Thread thread = new Thread();
        thread.start();
        System.out.print("A");
        thread.wait(1000);
        System.out.print("B");
    }
}

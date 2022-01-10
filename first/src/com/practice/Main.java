package com.practice;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        String name = scanner.nextLine();
        String funcName = function(name);
        System.out.println(funcName + " is " + day + " years old");
    }

    public static String function(String name) {
        return name;
    }
}

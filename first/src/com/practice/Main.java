package com.practice;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        // int day = scanner.nextInt();
        // String name = scanner.nextLine();
        // String funcName = function(name);
        // System.out.println(funcName + " is " + day + " years old");
        // int car = comeName(20);
        // System.out.println(car);
        Animal animal = new Animal();
        String protist = animal.Protista();
        System.out.println(protist);
    }
    


    public static String function(String name) {
        return name;
    }

    private static int comeName(int come) {
        return come;
    }
}

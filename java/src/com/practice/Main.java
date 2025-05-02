package com.practice;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) { 
        String home = Sub.how();
        System.out.println(home);
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());
        System.out.println(two());
    }
    public static int two(){
        return 3;
    }
}

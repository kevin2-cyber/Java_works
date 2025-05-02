package com.assignment;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Takes in a decimal number and prints out the binary and octal and hexadecimal equivalent
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your decimal number: ");
        int decNum = sc.nextInt();

        System.out.println("The binary for your number is: ");
        System.out.println(Integer.toBinaryString(decNum));

        System.out.println("The octal for your number is: ");
        System.out.println(Integer.toOctalString(decNum));

        System.out.println("The hexadecimal for your number is: ");
        System.out.println(Integer.toHexString(decNum));
    }
}

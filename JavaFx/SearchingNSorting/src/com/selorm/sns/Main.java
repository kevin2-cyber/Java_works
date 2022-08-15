package com.selorm.sns;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int element;
        int digit;
        int searchType;

        Scanner input = new Scanner(System.in);

        System.out.println("number of elements: ");
        element = input.nextInt();

        int[] data = new int[element];
        for (int i = 0; i < data.length; i++) {
            System.out.println("Key in the list of data you would work with: ");
            data[i] = input.nextInt();
        }

        System.out.println("1. Search");
        System.out.println("2. Sort\n");

        do {
            System.out.println("please use numerals only \n");
            System.out.println("Would you want to search or sort: ");

            digit = input.nextInt();

            if (digit == 1) {
                do {
                    System.out.println("1. Linear Search");
                    System.out.println("2. Binary Search");
                    System.out.println("Choose an option: ");

                    searchType = input.nextInt();

                    switch (searchType) {
                        
                    }
                }
            }
        }
    }
}

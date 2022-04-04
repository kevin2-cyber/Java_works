package com.jakarta;



public class Jakarta {
    public static void main(String[] args) {
        System.out.println("Hello, Kelvin!");

        int myFirstNumber = (10 + 5) + (2 * 10);
        int mySecondNumber = 12;
        int myThirdNumber = myFirstNumber * 2;
        int myTotal = myFirstNumber + mySecondNumber + myThirdNumber;
        int myLastOne = 1000 - myTotal;

        System.out.println("myLastOne = " + myLastOne);

        System.out.println("The number is " + myTotal);

//        int sum = 0;
//
//        // create an object of Scanner class
//        Scanner input = new Scanner(System.in);
//
//        // take integer input from the user
//        System.out.println("Enter a number");
//        int number = input.nextInt();
//
//        // while loop continues
//        // until entered number is positive
//        while (number <= 50) {
//            // add only positive numbers
//            sum += number;
//
//            System.out.println("Enter a number");
//            number = input.nextInt();
//        }
//
//        System.out.println("Sum = " + sum);
//        input.close();
    }
}

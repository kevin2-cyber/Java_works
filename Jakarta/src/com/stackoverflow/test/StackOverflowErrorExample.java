package com.stackoverflow.test;

public class StackOverflowErrorExample {
    public static void recursivePrint(long num) {
        System.out.println("Number " + num);
        if (num == 0) {
            return;
        } else {
            recursivePrint(++num);
        }
    }

    public static void main(String[] args) {
        StackOverflowErrorExample.recursivePrint(1);
    }
}

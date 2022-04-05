package com.stackoverflow.demo;

public class StackOverflowDemo {

    public static void unBoundedRecursiveCall() {
        unBoundedRecursiveCall();
    }

    public static void main(String[] args) {
        unBoundedRecursiveCall();
    }
}

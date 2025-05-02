package com.company;

public class New {
    public static void main(String[] args){
        System.out.println("Hello World");
    }
    public int recursiveSum(int n){
        if (n <= 1) {
            return n;
        } else {
            return (n + n-1);
        }
    }
}


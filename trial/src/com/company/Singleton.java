package com.company;

public class Singleton {
    private static Singleton instance;
    private Singleton(String name) {}

    public static Singleton getInstance(String name) {
        if (instance == null) {
            instance = new Singleton(name);
        } else return null;
        return instance;
    }

    public static int num(int num1, int num2) {
        return num1 + num2;
    }

    public static String num(String letter, String xTic) {
        return letter + xTic;
    }
}

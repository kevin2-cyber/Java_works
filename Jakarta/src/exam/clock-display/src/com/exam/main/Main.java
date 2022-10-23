package com.exam.main;

public class Main {
    public static void main(String[] args) {
        NumberDisplay numberDisplay = new NumberDisplay(20);
        String displayValue = numberDisplay.getDisplayValue();
        System.out.println(displayValue);
    }
}
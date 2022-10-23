package com.exam.main;

public class Main {
    public static void main(String[] args) {
        ClockDisplay display = new ClockDisplay();
        display.setTime(1, 20, 20);
        System.out.println(display.getTime());
    }
}
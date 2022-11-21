package com.exam.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClockDisplay display = new ClockDisplay();
        display.setTime(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        System.out.println(display.getTime());
    }
}
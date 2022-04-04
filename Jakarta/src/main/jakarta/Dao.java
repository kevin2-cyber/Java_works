package main.jakarta;


import java.util.Scanner;

public class Dao extends Main {
    @Override
    public void printData() {
        Scanner scanner = new Scanner(System.in);
        int dec = scanner.nextInt();
        System.out.println("dec = " + dec);
    }
}

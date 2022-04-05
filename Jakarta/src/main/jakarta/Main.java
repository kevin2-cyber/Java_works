package main.jakarta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    printData();
    }

    public static void printData() {
        Scanner scanner = new Scanner(System.in);
        var name = scanner.nextLine();
        System.out.println("name = " + name);
    }


}

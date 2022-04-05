package main.jakarta;

import com.jakarta.Script;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    printData();
        Script script = new Script(20,30);
    }

    public static void printData() {
        Scanner scanner = new Scanner(System.in);
        var name = scanner.nextLine();
        System.out.println("name = " + name);
    }


}

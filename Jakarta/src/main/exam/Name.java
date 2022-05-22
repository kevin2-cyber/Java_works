package main.exam;

import java.util.Scanner;

public class Name {
    private String firstName = null;
    private String surName = null;


    public Name(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    Scanner scanner = new Scanner(System.in);
    String names = scanner.nextLine();
}

package com.club.main;

public class Membership {
    private String name;
    private int month;
    private int year;

    public Membership(String name, int month, int year) throws IllegalArgumentException {
        if(month < 1 || month > 12) {
            throw new IllegalArgumentException(
                    "Month " + month + " out of range. Must be in the range 1 ... 12");
        }
        this.name = name;
        this.month = month;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return "Name: " + name +
                " joined in month " +
                month + " of " + year;
    }

}

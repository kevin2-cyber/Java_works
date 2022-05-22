package main.exam;

public class Name {
    private final String firstName;
    private final String surName;

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

    public String addNames() {
        return getFirstName() + " " +getSurName();
    }
}

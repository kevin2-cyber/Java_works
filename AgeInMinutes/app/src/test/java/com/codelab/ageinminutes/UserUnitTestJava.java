package com.codelab.ageinminutes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class UserUnitTestJava {

    private String first = "Alice";
    private String last = "Simmons";
    private JavaUser user = new JavaUser(first,last);
    private JavaUser userSame = new JavaUser(first,last);
    private JavaUser userDifferent = new JavaUser("Alex","Smith");

    @Test
    public void readProperties() {
        assertEquals(first, user.getFirst());
        assertEquals(last, user.getLast());
    }

    @Test
    public void writeProperties() {
        user.getFirst() = "Alex";
        user.getLast() = "Smith";

        assertNotEquals(first, user.getFirst());
        assertNotEquals(last, user.getLast());
    }
}

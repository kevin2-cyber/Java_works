package com.codelab.ageinminutes;

import androidx.annotation.NonNull;

import java.util.Objects;

class JavaUser {

    private String First;
    private String Last;

    public JavaUser(String first, String last) {
        this.First = first;
        this.Last = last;
    }

    public String getFirst() {
        return First;
    }

    public String getLast() {
        return Last;
    }

    public void setFirst(String first) {
        First = first;
    }

    public void setLast(String last) {
        Last = last;
    }

    @NonNull
    @Override
    public String toString() {
        return First + " " + Last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JavaUser)) return false;
        JavaUser javaUser = (JavaUser) o;
        return Objects.equals(getFirst(), javaUser.getFirst()) && Objects.equals(getLast(), javaUser.getLast());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst(), getLast());
    }
}

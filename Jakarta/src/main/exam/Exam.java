package main.exam;

public class Exam {
    public static void main(String[] args) {

        Name name = new Name("", "");

        System.out.println("name = " + name.getFirstName());

        int integer = Integer.MAX_VALUE;

        long longVal = Long.MAX_VALUE;
        System.out.println("integer = " + integer + "\n" + "long = " + longVal);
    }

}

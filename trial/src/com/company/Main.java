package com.company;

import java.util.Arrays;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance(
                Arrays.toString(args)
        );
        assert singleton != null;
        System.out.println(singleton.toString().toLowerCase(Locale.CANADA));
        int num = Singleton.num(2,3);
        System.out.println(num);

        String letters = Singleton.num("Hey", " There");
        System.out.println(letters);

        System.out.println(made(3, 2,3,4,5,6,6,6));
    }

    public static int made(int index, int... args) {
        return args[index];
    }
}
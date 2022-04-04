package main.jakarta;

public class Main {
    public static void main(String[] args) {
        byte myByte = 19;
        short myShort = 20;
        int myInt = 200;
        long longTotal = 50000 + (10 * (myByte + myShort + myInt));
        System.out.println("longTotal = " + longTotal);

        short shortTotal = (short) (10000 + 10 * (myByte + myShort + myInt));
        System.out.println("shortTotal = " + shortTotal);
    }
}

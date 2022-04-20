package main.micro;

public class DataTypes {
    public static void main(String[] args) {
      String myString = "This is a string";
        System.out.println("myString is equal to " + myString);
        myString = myString + ", and this is more.";
        System.out.println("myString is equal to " + myString);
        myString = myString + " \u00A9 2019";
        System.out.println("myString is equal to " + myString);
        String numberString = "250.55";
        numberString = numberString + "49.55";
        System.out.println("numberString = " + numberString);
        String lastString = "10";
        int myInt = 50;
        lastString = lastString + myInt;
      System.out.println("LastString is equal to " + lastString);
    }
}

package kevin.codelab.java.methods.overloading;

import org.jetbrains.annotations.NotNull;

public class Overloading {

    public static void main(String[] args) {
        int newScore = calculateScore("Tim", 500);
        System.out.println("New score is " + newScore);
        calculateScore(75);
        calculateScore();
        double centimeters = calcFeetAndInchesToCentimeters(6, 0);
        if (centimeters < 0.0)
            System.out.println("Invalid parameters");

        calcFeetAndInchesToCentimeters(100);
        System.out.println(getDurationString(65,45));
        System.out.println(getDurationString(3945));

    }

    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " scored " + score + " points");
        return score * 1000;
    }

    public static int calculateScore(int score) {
        System.out.println("Unnamed Player scored " + score + " points");
        return score * 1000;
    }

    public static int calculateScore() {
        System.out.println("No player name, no player score.");
        return 0;
    }

    // Create a method called calcFeetAndInchesToCentimeters
    // It needs to have two parameters.
    // feet is the 1st parameter, inches is the 2nd parameter

    // You should validate that the 1st parameter feet is >=0
    // You should validate that the 2nd parameter inches is >=0 and <=12
    // return -1 from the method if either of the above is not true

    // If the parameters are valid, then calculate how many centimetres
    // comprise the feet and inches passed to this method and return that value.

    // Create a 2nd method of the same name but with only one parameter
    // inches is the parameter
    // validate that it's >=0
    // return -1 if is not true
    // But if it's valid, then calculate how many feet are in the inches
    // and then here is the tricky part
    // call the other overloaded method passing the correct feet and inches
    // calculated so that it can calculate correctly
    // hints: Use double for your number dataTypes is probably a good idea
    // 1 inch = 2.54cm and one foot = 12inches
    // use the link I give you to confirm your code is calculating correctly.
    // Calling another overloaded method just requires you to use the
    // right number of parameters.

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        if ((feet < 0) || (inches < 0) || (inches > 12) ) {
            System.out.println("Invalid feet or inches parameters");
            return -1;
        }

        double centimeters = (feet * 12) * 2.54;
        centimeters += inches * 2.54;
        System.out.println(feet + " feet, " + inches + " inches = " + centimeters + " cm");
        return centimeters;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        if (inches < 0) {
            return -1;
        }

        double feet = (int) (inches / 12);
        double remainingInches = (int) inches % 12;
        System.out.println(inches + " inches  is equal to " + feet + " feet and " + remainingInches + "inches");
        return calcFeetAndInchesToCentimeters(feet, remainingInches);
    }

    // Create a method called getDurationString with two parameters, first parameter
    // minutes and 2nd parameter seconds
    // You should validate that the first parameter minutes is >=0
    // You should validate that the 2nd parameter seconds is >=0 and <=59
    // The method should return "Invalid value" in the method if either of the above are not true
    // If the parameters are valid then calculate how many hours, minutes and seconds
    // equal the minutes and seconds passed to this method and return that value as
    // string format "XXh YYm ZZs" where XX represents a number of hours, YY the minutes
    // and ZZ the seconds.

    // Create a 2nd method of the same name but with only one parameter seconds.
    //
    // Validate that it is >=0, and return "Invalid value" if it is not true.
    //
    // If it is valid, then calculate how many minutes are in the seconds value and then call
    // the other overloaded method passing the correct minutes and seconds calculated so
    // that it can calculate correctly.
    //
    // Call both methods to print  values to the console.

    private static @NotNull String getDurationString(long minutes, long seconds) {
        if ((minutes < 0) || (seconds < 0) || (seconds > 59)) {
            return "Invalid value";
        }

        long hours = minutes / 60;
        long remainingMinutes = minutes % 60;

        String hoursString = hours + "h";
        if (hours < 10)
            hoursString = "0" + hoursString;


        String minutesString = remainingMinutes + "m";
        if (remainingMinutes < 10)
            minutesString = "0" + minutesString;

        String secondsString = seconds + "s";
        if (seconds < 10)
            secondsString = "0" + secondsString;

        return hoursString+ " " + minutesString + " " + secondsString + " ";
    }

    private static String getDurationString(long seconds) {
        if (seconds < 0) {
            return "Invalid value";
        }

        long minutes  = seconds / 60;
        long remainingSeconds = seconds % 60;

        return getDurationString(minutes, remainingSeconds);
    }
}

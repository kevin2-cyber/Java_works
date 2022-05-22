package exam.numberdisplay;

import java.util.Scanner;

public class Number {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int scan = scanner.nextInt();
        NumberDisplay numberDisplay = new NumberDisplay(scan);

        ClockDisplay clockDisplay = new ClockDisplay();

        clockDisplay.timeTick();
        clockDisplay.timeTick();
        clockDisplay.timeTick();

        numberDisplay.increment();
        numberDisplay.increment();
        numberDisplay.increment();

        System.out.println("numberDisplay = " + numberDisplay.getDisplayValue());
    }
}

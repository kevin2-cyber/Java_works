package exam.numberdisplay;

import java.util.Scanner;

public class Number {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int scan = scanner.nextInt();
        NumberDisplay numberDisplay = new NumberDisplay(scan);

        numberDisplay.increment();
        numberDisplay.increment();
        numberDisplay.increment();

        System.out.println("numberDisplay = " + numberDisplay.getDisplayValue());
    }
}

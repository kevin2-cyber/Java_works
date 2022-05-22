package main.aircondition;


import java.util.Scanner;

public class Air {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int scan = scanner.nextInt();
        AirCon airCon = new AirCon(scan);

        airCon.desiredTemp();
    }
}

package main.ticketmachine;

import java.util.Scanner;

public class Ticket {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int scan = scanner.nextInt();
        TicketMachine machine = new TicketMachine(scan);
        machine.printTicket();
        machine.showPrice();
    }
}

package main.ticketmachine;


public class TicketMachine {
    private int price;
    private int balance;
    private int total;
    private int remainder;

    public TicketMachine(int cost) {
        price = cost;
        balance = 0;
        total = 0;
        remainder = 0;
    }

    public int getBalance() {
        return balance;
    }

    public int getTotal() {
        return total;
    }

    public int getRemainder() {
        return remainder;
    }

    public void setPrice(int cost) {
        price = cost;
    }

    public void insertMoney(int amount) {
        balance = balance +  amount;
    }

    public void discount(int amount) {
        System.out.println("Please insert the correct amount of money.");
    }

    public void showPrice() {
        System.out.println("The price of a ticket is " + price + " cents");
    }


    public void printTicket() {
        System.out.println("##################");
        System.out.println("# The BlueJ Line");
        System.out.println("# Ticket");
        System.out.println("# " + price + " cents.");
        System.out.println("##################");
        System.out.println();

        total = total + balance;

        balance = 0;
    }

}

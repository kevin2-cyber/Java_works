package com.club.main;

public class ClubDemo {
    private Club club;
    public ClubDemo() {
        club = new Club();
    }
    public void demo() {
        club = new Club();
        club.join(new Membership("Gordy Broon", 1, 1972));
        club.join(new Membership("Eck Salmon", 9, 1965));
        club.join(new Membership("Davie Caramel", 5, 1960));
        System.out.println("Using for-each ....");
        club.listMembers1();
        System.out.println("Using while loop....");
        club.listMembers2();
        System.out.println("Using iterator...");
        club.listMembers3();
        System.out.println("Using ListIterator.....");
        club.listMembers4();
        System.out.println("Using Iterable.forEach....");
        club.listMembers5();
        System.out.println("Using Stream.forEach....");
        club.listMembers6();
        System.out.println("Using the traditional for loop...");
        club.listMembers7();
        System.out.println("Now doing some searching...");
        club.searchMember("mon");
        System.out.println("And some more searching...");
        club.searchMember("moon");
    }
}

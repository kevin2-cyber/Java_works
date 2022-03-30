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
        System.out.println("Using iteraror...");
        club.listMembers3();
        System.out.println("Now doing some searching...");
        club.searchMember("mon");
        System.out.println("And some more searching...");
        club.searchMember("moon");
    }
}

package com.club.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class Club {
    private final ArrayList<Membership> members;

    public Club() {

        members = new ArrayList<>();
    }
    public void join(Membership member) {

        members.add(member);
    }
    public int numberOfMembers() {

        return members.size();
    }

    public void listMembers1() {
        for (Membership member: members){
            System.out.println(member.toString());
        }
    }

    public void listMembers2() {
        int i = 0;
        while (i < members.size()) {
            System.out.println(members.get(i));
            i++;
        }
    }

    public void listMembers3() {
        Iterator<Membership> member = members.iterator();
        while (member.hasNext()) {
            System.out.println(member.next());
        }
    }

    public void listMembers4() {
        ListIterator<Membership> member = members.listIterator();
        while (member.hasNext()) {
            System.out.println(member.next());
        }
    }

    public void listMembers5() {
        members.forEach((temp) -> {
            System.out.println(temp);
        });
    }

    public void listMembers6() {
        members.stream().forEach((temp) -> System.out.println(temp));
    }

    public void listMembers7() {
        for (int member = 0; member < members.size(); member++) {
            System.out.println(members.get(member));
        }
    }
    public void listMembers8() {
        members.forEach(System.out::println);
    }

    public void searchMember(String names) {
        for (Membership member: members) {
            if (member.getName().contains(names)) {
                System.out.println(member.toString());
            } else {
                System.out.println("Ouch naw .... Member not found");
            }
        }
    }
}

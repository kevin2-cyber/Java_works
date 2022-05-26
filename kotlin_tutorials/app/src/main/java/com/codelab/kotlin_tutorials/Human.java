package com.codelab.kotlin_tutorials;

abstract class Human {
    private final String hands;
    private final String legs;

    public Human(String hands, String legs) {
        this.hands = hands;
        this.legs = legs;
    }

    public String getHands() {
        return hands;
    }

    public String getLegs() {
        return legs;
    }

    public int lengthOfHands() {
        return hands.length();
    }

    public int lengthOfLegs() {
        return legs.length();
    }
}
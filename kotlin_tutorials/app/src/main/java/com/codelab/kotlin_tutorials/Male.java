package com.codelab.kotlin_tutorials;

public class Male extends Human{
    private String hands;
    private String legs;

    public Male(String hands, String legs) {
        super(hands, legs);
    }

    public int lengthOfHands() {
        return hands.length();
    }

    public int lengthOfLegs() {
        return legs.length();
    }
}

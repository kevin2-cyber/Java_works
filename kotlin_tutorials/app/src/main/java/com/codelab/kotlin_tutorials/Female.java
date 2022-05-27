package com.codelab.kotlin_tutorials;

public class Female extends Human{
    private String hands;
    private String legs;

    public Female(String hands, String legs) {
        super(hands = hands ,legs = legs);
//        this.hands = hands;
//        this.legs = legs;
    }

    public int lengthOfHands() {
        return hands.length();
    }

    public int lengthOfLegs() {
        return legs.length();
    }
}

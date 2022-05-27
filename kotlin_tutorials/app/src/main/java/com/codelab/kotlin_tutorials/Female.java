package com.codelab.kotlin_tutorials;

public class Female extends Human{


    public Female(String hands, String legs) {
        super(hands, legs);

    }

    public int lengthOfHands() {
        return super.getHands().length();
    }

    public int lengthOfLegs() {
        return super.getLegs().length();
    }

    public int lengthOfBoth() {
        return super.getHands().length() + super.getLegs().length();
    }
}

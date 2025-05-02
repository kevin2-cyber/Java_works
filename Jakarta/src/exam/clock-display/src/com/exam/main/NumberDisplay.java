package com.exam.main;

public class NumberDisplay {

    private final int limit;
    private int value;

    public NumberDisplay(int rollOverLimit){
        limit = rollOverLimit;
        value = 0;
    }

    public int getValue() {
        return value;
    }

    public String getDisplayValue(){
        if (value < 10) {
            return "0" + value;
        } else {
            return "" + value;
        }
    }

    public void setValue(int replacementValue) {
        if ((replacementValue >= 0) || (replacementValue < limit)) {
            value = replacementValue;
        }
    }

    public void increment() {
        if (value >= limit) {
            value = 0;
        } else {
            value++;
        }
    }
}

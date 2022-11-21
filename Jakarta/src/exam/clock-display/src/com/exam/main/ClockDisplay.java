package com.exam.main;

public class ClockDisplay {

    private final NumberDisplay hours;
    private final NumberDisplay minutes;
    private final NumberDisplay seconds;
    private String displayString;

    public ClockDisplay() {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(59);
        seconds = new NumberDisplay(59);
        updateDisplay();
    }

    public ClockDisplay(int hour, int minute, int second) {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(59);
        seconds = new NumberDisplay(59);
        setTime(hour, minute, second);
    }

    public void timeTick() {
        seconds.increment();
        if (seconds.getValue() == 0) {
            minutes.increment();
        }

        updateDisplay();
    }

    public void setTime(int hour, int minute, int second) {
        hours.setValue(hour);
        minutes.setValue(minute);
        seconds.setValue(second);

        updateDisplay();
    }

    public String getTime() {
        return displayString;
    }

    public void updateDisplay() {
        displayString = hours.getDisplayValue() + ":" +
                        minutes.getDisplayValue() + ":" +
                        seconds.getDisplayValue();
    }
}

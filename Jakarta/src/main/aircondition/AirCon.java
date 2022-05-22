package main.aircondition;

public class AirCon {
    private int temperature;
    private boolean isSwitchedOn;

    public AirCon(int temp) {
        temperature = temp;
        isSwitchedOn = true;
    }

    public int temp() {
        return temperature;
    }

    public void increaseTemperature() {
        temperature += 2;
    }

    public void decreaseTemperature() {
        temperature -= 2;
    }

    public void newTemperature(int amount) {
        temperature += amount;
    }

    public void desiredTemp() {
        System.out.println("Your temperature is " + temperature + " degrees.");
        System.out.println("It is " + isSwitchedOn + " that the airconditioning unit is switched on.");
    }

    public void isTurnedOn() {
        isSwitchedOn = true;
    }

    public void isTurnedOff() {
        isSwitchedOn= false;
    }
}

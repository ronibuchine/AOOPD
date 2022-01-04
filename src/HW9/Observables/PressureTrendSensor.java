package Observables;

import Nimbus1.Nimbus1PressureSensor;
import Observers.Observer;

public class PressureTrendSensor extends Observable implements Observer {
    // saves the last three times the pressure changes and tells us if it is rising
    // falling or stable
    private int mostRecent;
    private int secondMostRecent;
    private int thirdMostRecent;
    private String type = "pressure trend";
    private Trend pressureState;
    private Trend lastState;

    public enum Trend {
        RISING, FALLING, STABLE
    };

    public PressureTrendSensor(Nimbus1PressureSensor pressSensor) {
        pressSensor.addObserver(this);
        System.out.println("PressureTrendSensor observes " + pressSensor.getType());
    }

    public Trend calc() {
        if (mostRecent > secondMostRecent && secondMostRecent > thirdMostRecent)
            return Trend.RISING;
        if (mostRecent < secondMostRecent && secondMostRecent < thirdMostRecent)
            return Trend.FALLING;
        return Trend.STABLE;
    }

    public void check() {
        pressureState = calc();
        if (pressureState != lastState) {
            lastState = pressureState;
            notifyObservers(pressureState.ordinal());
        }
        
    }

    public void update(int data) {
        thirdMostRecent = secondMostRecent;
        secondMostRecent = mostRecent;
        mostRecent = data;
        check();
    }

    public String getType() {
        return type;
    }
}
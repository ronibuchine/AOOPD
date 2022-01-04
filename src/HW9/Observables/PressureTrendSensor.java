package Observables;

import Nimbus1.Nimbus1PressureSensor;
import Observers.Observer;

public class PressureTrendSensor extends Observable implements Observer {
    // saves the last three times the pressure changes and tells us if it is rising
    // falling or stable
    int mostRecent;
    int secondMostRecent;
    int thirdMostRecent;

    Trend pressureState;
    Trend lastState;

    public enum Trend {
        RISING, FALLING, STABLE
    };

    public PressureTrendSensor(Nimbus1PressureSensor pressSensor) {
        pressSensor.addObserver(this);
    }

    public Trend calc() {
        if (mostRecent > secondMostRecent && secondMostRecent > thirdMostRecent)
            return Trend.RISING;
        if (mostRecent < secondMostRecent && secondMostRecent < thirdMostRecent)
            return Trend.FALLING;
        return Trend.STABLE;
    }

    public void check() {
        Trend trend = calc();
        if (trend != lastState)
            notifyObservers(trend.ordinal());
        lastState = trend;
    }

    public void update(int data) {
        check();
    }
}

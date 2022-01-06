//package Observables;

//import Observers.Observer;

public class PressureTrendSensor extends Observable implements Observer {
    // saves the last three times the pressure changes and tells us if it is rising
    // falling or stable
    private int mostRecent = 0;
    private int secondMostRecent = 0;
    private int thirdMostRecent = 0;
    private String type = "pressure trend";
    private Trend pressureState;
    private Trend lastState = Trend.STABLE;

    public enum Trend {
        RISING, FALLING, STABLE
    };

    public PressureTrendSensor(Sensor pressSensor) {
        pressSensor.addObserver(this);
        System.out.println("PressureTrendSensor observes pressure");
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
        if (thirdMostRecent != 0) {
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
}

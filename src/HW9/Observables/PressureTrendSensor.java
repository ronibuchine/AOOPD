package HW9.Observables;

public class PressureTrendSensor {
    // saves the last three times the pressure changes and tells us if it is rising
    // falling or stable
    int mostRecent;
    int secondMostRecent;
    int thirdMostRecent;

    Trend pressureState;
    Trend lastState;

    public enum Trend {
        rising, falling, stable
    };

    public Trend calc() {
        if (mostRecent > secondMostRecent && secondMostRecent > thirdMostRecent)
            return rising;
        if (mostRecent < secondMostRecent && secondMostRecent < thirdMostRecent)
            return falling;
        return stable;
    }

    public void check() {
        read();
    }

    public int update() {
        return 0;
    }
}

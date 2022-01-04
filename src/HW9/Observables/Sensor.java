package Observables;

public abstract class Sensor extends Observable {

    int lastReading = 0;
    int interval;
    String type;

    public Sensor(String type, int interval) {
        this.type = type;
        this.interval = interval;
        (AlarmClock.theInstance()).register(interval, new SensorAlarmListener(this));
    }

    protected abstract int read();

    public void check() {
        int val = read();
        if (lastReading != val) {
            lastReading = val;
            notifyObservers(lastReading);
        }
    }
}

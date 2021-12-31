package Observables;

public abstract class Sensor extends Observable {

    int lastReading;
    int interval;
    String type;

    public Sensor(String type, int interval) {
        this.type = type;
        this.interval = interval;
        (AlarmClock.theInstance()).register(interval, new SensorAlarmListener(this));
    }

    protected abstract int read();

    public void check() {
        int temp = read();
        if (lastReading != temp) {
            lastReading = temp;
            notifyObservers(lastReading);
        }
    }
}

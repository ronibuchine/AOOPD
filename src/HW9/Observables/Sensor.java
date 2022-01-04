package Observables;

import Nimbus1.Nimbus1Clock;

public abstract class Sensor extends Observable {

    private int lastReading = 0;
    private int interval;
    private String type;

    public Sensor(String type, int interval) {
        this.type = type;
        this.interval = interval;
        (Nimbus1Clock.theInstance()).register(interval, new SensorAlarmListener(this));
        System.out.println(type + " registered to clock");
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

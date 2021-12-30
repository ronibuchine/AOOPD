package HW9.Nimbus1;

import HW9.Observables.Sensor;
import WS1.StudentCode.AlarmClock;

public class Nimbus1TemperatureSensor extends Sensor {

    int rnd;

    // between 0 and 40

    public Nimbus1TemperatureSensor(String type, int interval) {
        super(type, interval);
    }

    public int read() {
        return getRnd().nextInt(41);
        AlarmClock.theInstance();
    }

}

package Nimbus1;

import Observables.Sensor;

public class Nimbus1TemperatureSensor extends Sensor {

    int rnd;

    public Nimbus1TemperatureSensor(String type, int interval) {
        super(type, interval);
    }

    // between 0 and 40
    public int read() {
        return RandomSupplier.getRnd().nextInt(41);
    }

}

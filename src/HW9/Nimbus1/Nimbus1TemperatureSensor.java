//package Nimbus1;

import java.util.Random;
//import Observables.Sensor;

public class Nimbus1TemperatureSensor extends Sensor {

    private Random rnd;

    public Nimbus1TemperatureSensor(String type, int interval) {
        super(type, interval);
    }

    // between 0 and 40
    @Override
    public int read() {
        rnd = RandomSupplier.getRnd();
        return rnd.nextInt(41);
    }

}

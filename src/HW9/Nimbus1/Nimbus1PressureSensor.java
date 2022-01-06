//package Nimbus1;

import java.util.Random;
//import Observables.Sensor;

public class Nimbus1PressureSensor extends Sensor {

    private Random rnd;

    public Nimbus1PressureSensor(String type, int interval) {
        super(type, interval);
    }

    // between 950 and 1050
    @Override
    public int read() {
        rnd = RandomSupplier.getRnd();
        return rnd.nextInt(101) + 950;
    }
}

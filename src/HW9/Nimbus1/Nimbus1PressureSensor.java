package HW9.Nimbus1;

public class Nimbus1PressureSensor extends Sensor {

    public int rnd;

    public Nimbus1PressureSensor(String type, int interval) {
        super(type, interval);
    }

    // between 950 and 1050
    public int read() {
        return getRnd().nextInt(101) + 950;
    }
}

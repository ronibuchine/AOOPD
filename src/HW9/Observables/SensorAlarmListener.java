package Observables;

public class SensorAlarmListener implements AlarmListener {

    private Sensor sensor;

    public SensorAlarmListener(Sensor sensor) {
        this.sensor = sensor;
    }

    public void wakeup() {
        sensor.check();
    }

    public Sensor getSensor() {
        return sensor;
    }
}

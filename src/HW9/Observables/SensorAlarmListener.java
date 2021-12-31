package Observables;

public class SensorAlarmListener implements AlarmListener {

    Sensor sensor;

    public SensorAlarmListener(Sensor sensor) {
        this.sensor = sensor;
    }

    public void wakeup() {
        sensor.check();
    }

}

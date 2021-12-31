package Observers;

import Observables.PressureTrendSensor;
import Observables.PressureTrendSensor.Trend;
import Nimbus1.Nimbus1PressureSensor;


public class Log {
    public Log(Nimbus1PressureSensor pressureSensor) {
        pressureSensor.addObserver(new LogPressObserver(this));
    }

    public Log(PressureTrendSensor pressureTrendSensor) {
        pressureTrendSensor.addObserver(new LogPressTrendObserver(this));
    }

    public void logPressure(int data) {
        System.out.println("Log: pressure = " + data + " millibars");
    }

    public void logPressureTrend(int data) {
        System.out.println("Log: pressure trend = " + Trend.values()[data]);
    }
}

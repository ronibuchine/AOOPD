package Observers;

import Observables.WeatherMonitoringSystem;
import Observables.PressureTrendSensor.Trend;


public class Log {

    private WeatherMonitoringSystem ws;

    public Log(WeatherMonitoringSystem ws) {
        System.out.println(getClass().getName() + " was created");
        this.ws = ws;
        ws.addPressObserver(new LogPressObserver(this));
        ws.addPressTrendObserver(new LogPressTrendObserver(this));
    }

    public void logPressure(int data) {
        System.out.println("Log: pressure = " + data + " millibars");
    }

    public void logPressureTrend(int data) {
        System.out.println("Log: pressure trend = " + Trend.values()[data]);
    }
}

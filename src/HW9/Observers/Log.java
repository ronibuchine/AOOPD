//package Observers;

//import Observables.WeatherMonitoringSystem;
//import Observables.PressureTrendSensor.Trend;

public class Log {

    public Log(WeatherMonitoringSystem ws) {
        System.out.println("Log was created");
        ws.addPressObserver(new LogPressObserver(this));
        System.out.println("LogPressObserver observes pressure");
        ws.addPressTrendObserver(new LogPressTrendObserver(this));
        System.out.println("LogPressTrendObserver observes pressure trend");
    }

    public void logPressure(int data) {
        System.out.println("Log: pressure = " + data + " millibars");
    }

    public void logPressureTrend(int data) {
        System.out.println("Log: pressure trend = " + PressureTrendSensor.Trend.values()[data]);
    }
}

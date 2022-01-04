package Observers;

import Observables.WeatherMonitoringSystem;

public class MonitoringScreen {

    private WeatherMonitoringSystem ws;

    public MonitoringScreen(WeatherMonitoringSystem ws) {
        System.out.println("MonitoringScreen was created");
        this.ws = ws;
        ws.addTempObserver(new MSTempObserver(this));
        System.out.println("MSTempObserver observes temperature");
        ws.addPressObserver(new MSPressObserver(this));
        System.out.println("MSPressObserver observes pressure");
    }

    public void displayTemperature(int data) {
        System.out.println("Monitoring Screen: temperature = " + data + " Celsius");
    }

    public void displayPressure(int data) {
        System.out.println("Monitoring Screen: pressure = " + data + " millibars");
    }

}

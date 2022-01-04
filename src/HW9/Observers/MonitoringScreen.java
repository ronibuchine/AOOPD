package Observers;

import Observables.WeatherMonitoringSystem;

public class MonitoringScreen {

    WeatherMonitoringSystem ws;

    public MonitoringScreen(WeatherMonitoringSystem ws) {
        this.ws = ws;
        ws.addTempObserver(new MSTempObserver(this));
        ws.addPressObserver(new MSPressObserver(this));
    }

    public void displayTemperature(int data) {
        System.out.println("Monitoring Screen: temperature = " + data + " Celsius");
    }

    public void displayPressure(int data) {
        System.out.println("Monitoring Screen: pressure = " + data + " millibars");
    }

}

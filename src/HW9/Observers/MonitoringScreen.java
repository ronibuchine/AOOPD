//package Observers;

//import Observables.WeatherMonitoringSystem;

public class MonitoringScreen {

    public MonitoringScreen(WeatherMonitoringSystem ws) {
        System.out.println("MonitoringScreen was created");
        ws.addTempObserver(new MSTempObserver(this));
        System.out.println("MSTempObserver observes temperature");
        ws.addPressObserver(new MSPressObserver(this));
        System.out.println("MSPressObserver observes pressure");
    }

    public void displayTemperature(int data) {
        System.out.println("MonitoringScreen: temperature = " + data + " Celsius");
    }

    public void displayPressure(int data) {
        System.out.println("MonitoringScreen: pressure = " + data + " millibars");
    }

}

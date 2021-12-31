package Observers;

import Nimbus1.Nimbus1PressureSensor;
import Nimbus1.Nimbus1TemperatureSensor;

public class MonitoringScreen {

    public MonitoringScreen(Nimbus1TemperatureSensor tempSensor) {
        tempSensor.addObserver(new MSTempObserver(this));
    }

    public MonitoringScreen(Nimbus1PressureSensor pressureSensor) {
        pressureSensor.addObserver(new MSPressObserver(this));
    }

    public void displayTemperature(int data) {
        System.out.println("Monitoring Screen: temperature = " + data + " Celsius");
    }

    public void displayPressure(int data) {
        System.out.println("Monitoring Screen: pressure = " + data + " millibars");
    }

}

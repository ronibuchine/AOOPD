package Observables;

import Nimbus1.Nimbus1PressureSensor;
import Nimbus1.Nimbus1TemperatureSensor;
import Observers.Observer;

public class WeatherMonitoringSystem {

    private Nimbus1TemperatureSensor tempSensor = new Nimbus1TemperatureSensor("Temperature", 700);
    private Nimbus1PressureSensor pressSensor = new Nimbus1PressureSensor("Pressure", 1100);
    private PressureTrendSensor pressTrendSensor = new PressureTrendSensor(pressSensor);

    protected static WeatherMonitoringSystem instance = null;

    protected WeatherMonitoringSystem() {}
    public static WeatherMonitoringSystem theInstance()
    {
        if (null==instance)
            instance = new WeatherMonitoringSystem();
        return instance;
    }

    public void addTempObserver(Observer observer) {
        tempSensor.addObserver(observer);
    }

    public void addPressObserver(Observer observer) {
        pressSensor.addObserver(observer);
    }

    public void addPressTrendObserver(Observer observer) {
        pressTrendSensor.addObserver(observer);
    }


}

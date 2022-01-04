package Observables;

import Nimbus1.Nimbus1PressureSensor;
import Nimbus1.Nimbus1TemperatureSensor;
import Observers.Observer;

public class WeatherMonitoringSystem {

    private Nimbus1PressureSensor pressSensor = new Nimbus1PressureSensor("pressure", 1100);
    private Nimbus1TemperatureSensor tempSensor = new Nimbus1TemperatureSensor("temperature", 700);
    private PressureTrendSensor pressTrendSensor = new PressureTrendSensor(pressSensor);

    protected static WeatherMonitoringSystem instance = null;

    protected WeatherMonitoringSystem() {
        System.out.println(getClass().getName() + " was created");
    }
    public static WeatherMonitoringSystem theInstance()
    {
        if (null==instance)
            instance = new WeatherMonitoringSystem();
        return instance;
    }

    public void addTempObserver(Observer observer) {
        tempSensor.addObserver(observer);
        System.out.println(getClass().getName() + " observes " + tempSensor.getType());
    }

    public void addPressObserver(Observer observer) {
        pressSensor.addObserver(observer);
        System.out.println(getClass().getName() + " observes " + pressSensor.getType());
    }

    public void addPressTrendObserver(Observer observer) {
        pressTrendSensor.addObserver(observer);
        System.out.println(getClass().getName() + " observes " + pressTrendSensor.getType());
    }


}

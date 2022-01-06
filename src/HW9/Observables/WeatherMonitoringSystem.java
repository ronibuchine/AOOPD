//package Observables;

//import Nimbus1.Nimbus1PressureSensor;
//import Nimbus1.Nimbus1TemperatureSensor;
//import Observers.Observer;

public class WeatherMonitoringSystem {

    private Nimbus1PressureSensor pressSensor;
    private Nimbus1TemperatureSensor tempSensor;
    private PressureTrendSensor pressTrendSensor;

    protected static WeatherMonitoringSystem instance = null;

    protected WeatherMonitoringSystem() {
        System.out.println("WeatherMonitoringSystem was created");
        pressSensor = new Nimbus1PressureSensor("pressure", 1100);
        tempSensor = new Nimbus1TemperatureSensor("temperature", 700);
        pressTrendSensor = new PressureTrendSensor(pressSensor);
    }
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

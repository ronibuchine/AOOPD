package Observables;

import java.util.Observer;

public class WeatherMonitoringSystem {

    protected static WeatherMonitoringSystem instance = null;

    protected WeatherMonitoringSystem() {}
    public static WeatherMonitoringSystem theInstance()
    {
        if (null==instance)
            instance = new WeatherMonitoringSystem();
        return instance;
    }

    public void addTempObserver(Observer observer) {

    }

    public void addPressObserver(Observer observer) {

    }

    public void addPressTrendObserver(Observer observer) {

    }


}

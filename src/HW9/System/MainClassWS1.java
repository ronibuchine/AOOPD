package System;

import Observables.WeatherMonitoringSystem;
import Observers.Log;
import Observers.MonitoringScreen;

public class MainClassWS1
{

    public static void main(String[] args) {
        WeatherMonitoringSystem ws = WeatherMonitoringSystem.theInstance();

        MonitoringScreen p_MonitorScreen = new MonitoringScreen(ws);
        Log p_log = new Log(ws);
        
    }
}

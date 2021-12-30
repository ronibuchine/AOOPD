package HW9.Observers;

public class MonitoringScreen {

    public MonitoringScreen(Nimbus1TemperatureSensor tempSensor) {
        tempSensor.addObserver(new MSTempObserver());
    }

    public MonitoringScreen(Nimbus1PressureSensor pressureSensor) {
        pressureSensor.addObserver(new MSPressObserver());
    }

    public void displayTemperature(int data) {

    }

    public void displayPressure(int data) {

    }

}

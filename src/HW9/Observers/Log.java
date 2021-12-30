package HW9.Observers;

public class Log {
    public Log(Nimbus1PressureSensor pressureSensor) {
        pressureSensor.AddObserver(new LogPressObserver());
    }

    public Log(PrssureTrendSensor pressureTrendSensor) {
        pressureTrendSensor.AddObserver(new LogPressTrendObserver());
    }

    public void logPressureTrend(int data) {

    }

    public void logPressure(int data) {

    }

}

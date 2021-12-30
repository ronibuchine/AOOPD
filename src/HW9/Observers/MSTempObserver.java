package HW9.Observers;

public class MSTempObserver implements Observer {

    MonitoringScreen screen;

    public public MSTempObserver(MonitoringScreen screen) {
        this.screen = screen;
    }

    public void update(int data) {
        screen.displayTemperature(data);
    }

}

package Observers;

public class MSTempObserver implements Observer {

    MonitoringScreen screen;

    public MSTempObserver(MonitoringScreen screen) {
        this.screen = screen;
    }

    public void update(int data) {
        screen.displayTemperature(data);
    }

}

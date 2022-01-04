package Observers;

public class MSTempObserver implements Observer {

    private MonitoringScreen screen;

    public MSTempObserver(MonitoringScreen screen) {
        System.out.println(getClass().getName() + " was created");
        this.screen = screen;
    }

    public void update(int data) {
        screen.displayTemperature(data);
    }

}

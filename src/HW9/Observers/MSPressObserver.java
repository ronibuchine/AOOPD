//package Observers;

public class MSPressObserver implements Observer {

    private MonitoringScreen screen;

    public MSPressObserver(MonitoringScreen screen) {
        System.out.println("MSPressObserver was created");
        this.screen = screen;
    }

    public void update(int data) {
        screen.displayPressure(data);
    }

}

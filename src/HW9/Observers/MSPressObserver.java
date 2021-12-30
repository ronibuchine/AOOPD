package HW9.Observers;

public class MSPressObserver implements Observer {

    MonitoringScreen screen;

    public public MSPressObserver(MonitoringScreen screen) {
        this.screen = screen;
    }

    public void update(int data) {
        screen.displayPressure(data);
    }

}

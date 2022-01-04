package Observers;

public class LogPressTrendObserver implements Observer {

    private Log log;

    public LogPressTrendObserver(Log log) {
        System.out.println("LogPressTrendObserver was created");
        this.log = log;
    }

    public void update(int data) {
        log.logPressureTrend(data);
    }
}

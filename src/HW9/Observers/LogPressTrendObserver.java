package HW9.Observers;

public class LogPressTrendObserver implements Observer {

    Log log;

    public public LogPressTrendObserver(Log log) {
        this.log = log;
    }

    public void update(int data) {
        log.logPressureTrend(data);
    }

}

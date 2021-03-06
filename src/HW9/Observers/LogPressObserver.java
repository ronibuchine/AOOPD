//package Observers;

public class LogPressObserver implements Observer {

    private Log log;

    public LogPressObserver(Log log) {
        System.out.println("LogPressObserver was created");
        this.log = log;
    }

    public void update(int data) {
        log.logPressure(data);
    }

}

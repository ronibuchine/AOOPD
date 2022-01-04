package Observables;

public class AlarmClockRecord {
    private int interval;
    private int remainingTime;
    private AlarmListener alarmListener;

    public AlarmClockRecord(int interval, AlarmListener alarmListener) {  
        remainingTime = this.interval = interval;   
        this.alarmListener = alarmListener;
    }

    public int getInterval() {
        return interval;
    }

    public int remainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int time) {
        remainingTime = time;
    }

    public void decrementRemainingTime(int time) {
        remainingTime -= time;
    }

    public AlarmListener getListener() {
        return alarmListener;
    }
}

package HW9.Observables;

public abstract class Sensor extends Observable {

    int lastReading;
    int interval;
    String type;

    public Sensor(String type, int interval) {
        this.type = type;
        this.interval = interval;
    }

    protected abstract int read();

    public void check() {
        int temp = read();
        if (lastReading != temp) {
            lastReading = tmep;
            notifyObservers(lastReading);
        }
    }
}

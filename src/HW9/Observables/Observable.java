package Observables;

import java.util.List;
import Observers.Observer;

public class Observable {

    List<Observer> observers;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(int data) {
        for (Observer observer : observers) {
            observer.update(data);
        }
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}

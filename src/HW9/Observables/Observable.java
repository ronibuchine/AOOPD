package Observables;

import java.util.ArrayList;
import Observers.Observer;

public class Observable {

    private ArrayList<Observer> observers = new ArrayList<Observer>();

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

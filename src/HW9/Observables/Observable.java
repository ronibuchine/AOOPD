package HW9.Observables;

import HW9.Observers.Observer;

public class Observable {

    List<Observer> observers;

    public void addObserver(Observer observer) {
        observers.Add(observer);
    }

    public void notifyObservers(int data) {
        for (Obsrever observer : observers) {
            observer.update(data);
        }
    }

    public removeObserver(Observer observer) {
        observers.remove(observer);
    }
}

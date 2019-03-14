package designPattern.observer;

import java.util.HashSet;
import java.util.Set;

/**
 * created by ran
 */
public class ConcreteSubject implements Subject {
    private Set<Observer> observers = new HashSet<>();
    private float temp, humidity, pressure;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    void updateData(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temp, humidity, pressure);
        }
    }
}

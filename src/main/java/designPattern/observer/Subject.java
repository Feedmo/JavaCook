package designPattern.observer;

/**
 * created by ran
 */
public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

}

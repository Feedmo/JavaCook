package designPattern.observer;

/**
 * created by ran
 */
public class ConcreteObserver implements Observer {
    private float temp, humidity, pressure;
    private Subject subject;

    ConcreteObserver(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    private void display() {
        System.out.println(temp + " " + humidity + " " + pressure);
    }
}

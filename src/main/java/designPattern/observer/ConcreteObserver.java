package designPattern.observer;

/**
 * created by ran
 */
public class ConcreteObserver implements Observer {
    private float temp, humidity, pressure;

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    void display() {
        System.out.println(temp + " " + humidity + " " + pressure);
    }
}

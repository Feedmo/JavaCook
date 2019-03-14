package designPattern.decorator;

/**
 * created by ran
 */
public abstract class Drink {
    String description;

    public String getDescription() {
        return description;
    }

    abstract double price();
}

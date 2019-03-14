package designPattern.decorator;

/**
 * created by ran
 */
public class SugarDecorator extends Decorator {
    private Drink drink;

    public SugarDecorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    String description() {
        return drink.getDescription() + ", sugar";
    }

    @Override
    double price() {
        return 1.0 + drink.price();
    }
}

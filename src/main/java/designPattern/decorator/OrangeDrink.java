package designPattern.decorator;

/**
 * created by ran
 */
public class OrangeDrink extends Drink {
    public OrangeDrink() {
        description = "orange-drink";
    }

    @Override
    double price() {
        return 4.5;
    }
}

package designPattern.decorator;

/**
 * created by ran
 */
public class Test {
    public static void main(String[] args) {
        SugarDecorator sugarOrangeDrink = new SugarDecorator(new OrangeDrink());
        System.out.println(sugarOrangeDrink.description());
        System.out.println(sugarOrangeDrink.price());
    }
}

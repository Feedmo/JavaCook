package designPattern.factory.factoryMethod;

import designPattern.factory.ConcretePizza;
import designPattern.factory.Pizza;

/**
 * 不同的pizzaStore依据createPizza可以创建不同种类的pizza
 * created by ran
 */
public class ConcretePizzaStore extends PizzaStore {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("...")) {
            pizza = new ConcretePizza();
        }
        return pizza;
    }
}

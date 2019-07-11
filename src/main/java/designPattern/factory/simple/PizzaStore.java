package designPattern.factory.simple;

import designPattern.factory.Pizza;

public class PizzaStore {

    public static Pizza orderPizza(String type) {
        Pizza pizza = SimplePizzaFactory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        return pizza;
    }
}

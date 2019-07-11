package designPattern.factory.simple;

import designPattern.factory.ConcretePizza;
import designPattern.factory.Pizza;

class SimplePizzaFactory {

    static Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equals("...")) {
            pizza = new ConcretePizza();
        } // ...
        return pizza;
    }
}

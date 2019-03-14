package designPattern.factory.factoryMethod;

import designPattern.factory.Pizza;

/**
 * 由子类按照自己的逻辑特点实现有差异的部门，而共通的部分留给父类
 * created by ran
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}

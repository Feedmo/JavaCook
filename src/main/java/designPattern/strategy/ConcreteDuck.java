package designPattern.strategy;

import designPattern.strategy.behavior.GuaGuaQuackImpl;

/**
 * created by ran
 */
public class ConcreteDuck extends Duck {
    public ConcreteDuck() {
        quackBehaviour = new GuaGuaQuackImpl();
    }

    @Override
    void display() {
        System.out.println("duck duck king...");
    }
}

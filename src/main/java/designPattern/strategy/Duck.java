package designPattern.strategy;

import designPattern.strategy.behavior.QuackBehaviour;

/**
 * created by ran
 */
abstract class Duck {
    QuackBehaviour quackBehaviour;

    void performQuack() {
        quackBehaviour.quack();
    }

    abstract void display();
}

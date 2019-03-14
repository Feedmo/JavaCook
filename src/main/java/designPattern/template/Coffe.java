package designPattern.template;

import java.util.Arrays;

/**
 * created by ran
 */
public class Coffe extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Dripping coffee");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}

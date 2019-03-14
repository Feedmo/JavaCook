package designPattern.adapter;

/**
 * created by ran
 * {@link TurkeyAdapter}
 */
public class Test {
    public static void main(String[] args) {
        // 虽然是Duck类，但真正调用的是Turkey的方法
        Duck turkeyAdapter = new TurkeyAdapter(new WildTurkey());
        turkeyAdapter.quack();
        turkeyAdapter.fly();
    }
}

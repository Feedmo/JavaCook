package designPattern.adapter;

/**
 * created by ran
 * <h2>包装另外的接口，并且调用的是对应接口的方法</h2>
 */
public class TurkeyAdapter implements Duck {
    private Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        // fly more times
        turkey.fly();
        turkey.fly();
        turkey.fly();
    }
}

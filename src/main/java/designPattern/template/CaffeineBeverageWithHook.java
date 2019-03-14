package designPattern.template;

/**
 * created by ran
 * 不同的饮料(如茶和咖啡)在产出的过程中存在一些异同
 * boilWater和pourInCup是相同的操作，而brew和addCondiments各自有不同的实现，因此以抽象方法的形式提供给子类实现
 *
 */
public abstract class CaffeineBeverageWithHook {
    // note 这里防止之类覆盖，因为执行顺序是固定的不需要改动
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        // addCondiments();
        // 可以添加钩子使得满足条件才能执行相应方法
        if (customerNeedCondiments()) {
            addCondiments();
        }
    }

    // note 子类可以覆盖该方法来添加自己的逻辑代码
    protected boolean customerNeedCondiments() {
        return true;
    }

    void boilWater() {
        System.out.println("boil water");
    }

    void pourInCup() {
        System.out.println("pour in cup");
    }

    abstract void brew();

    abstract void addCondiments();
}

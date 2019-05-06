package lang.concurrency.reentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * {@link java.util.concurrent.ArrayBlockingQueue}
 */
public class ConditionUsage implements Runnable {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            // await会释放持有的锁，待被signal唤醒之后尝试并重新获得锁之后，再继续执行
            condition.await();
            System.out.println("continue to going on");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ConditionUsage());
        t1.start();
        Thread.sleep(1000);

        lock.lock();
        condition.signal();
        System.out.println("signal...");
        lock.unlock();
    }
}

package lang.concurrency.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock的lockInterruptibly()能够对中断作出响应，从而可以结束死锁状态
 */
public class InterruptUsage implements Runnable {
    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();
    private int v;

    private InterruptUsage(int v) {
        this.v = v;
    }

    @Override
    public void run() {
        try {
            if (v == 1) {
                lock1.lockInterruptibly();
                Thread.sleep(500);
                lock2.lockInterruptibly();
            } else {
                lock2.lockInterruptibly();
                Thread.sleep(500);
                lock1.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getId() + ": 线程退出");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new InterruptUsage(1));
        Thread t2 = new Thread(new InterruptUsage(2));

        t1.start(); t2.start();
        Thread.sleep(1000);

        // 此处对t2执行中断操作使得其放弃对lock1的请求和lock2的持有，这样t1就能获取到lock2，从而顺利结束线程
        t2.interrupt();
    }
}

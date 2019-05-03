package lang.concurrency.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 当前代码非常容易产生死锁，但是利用tryLock()在没能获取到锁就立即返回的特性可以消除死锁的继续发生
 * （这里不断循环去调用tryLock去尝试获取锁
 */
public class NoTimelyTryLock implements Runnable {
    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();
    private int v;

    private NoTimelyTryLock(int v) {
        this.v = v;
    }

    @Override
    public void run() {
        if (v == 1) {
            while (true) {
                if (lock1.tryLock()) {
                    try {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (lock2.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getName() + ": My job done!");
                                return;
                            } finally {
                                lock2.unlock();
                            }
                        }
                    } finally {
                        lock1.unlock();
                    }
                }
            }
        } else {
            while (true) {
                if (lock2.tryLock()) {
                    try {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (lock1.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getName() + ": My job done!");
                                return;
                            } finally {
                                lock1.unlock();
                            }
                        }
                    } finally {
                        lock2.unlock();
                    }
                }
            }
        }
    }

    /**
     * output:
     *      t2: My job done!
     *      t1: My job done!
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(new NoTimelyTryLock(1), "t1");
        Thread t2 = new Thread(new NoTimelyTryLock(2), "t2");
        t1.start(); t2.start();
    }
}

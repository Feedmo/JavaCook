package lang.concurrency.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TimelyTryLock implements Runnable {
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        // t2线程会因为超时等待二返回false
        try {
            if (lock.tryLock(2, TimeUnit.SECONDS)) {
                Thread.sleep(3000);
            } else {
                System.out.println(Thread.currentThread().getName()+" get lock failed...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TimelyTryLock instance = new TimelyTryLock();
        Thread t1 = new Thread(instance, "t1");
        Thread t2 = new Thread(instance, "t2");
        t1.start(); t2.start();
    }
}

package lang.concurrency;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 适用于读操作大于写操作的场景
 */
public class ReadWriteLockUsage {
    private static Lock lock = new ReentrantLock();

    private static ReentrantReadWriteLock rrwl = new ReentrantReadWriteLock();
    private static Lock readLock = rrwl.readLock();
    private static Lock writeLock = rrwl.writeLock();

    private int value;

    private Object handleRead(Lock lock) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(500);
            return value;
        } finally {
            lock.unlock();
        }
    }

    private void handleWrite(Lock lock, int value) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(500);
            this.value = value;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLockUsage instance = new ReadWriteLockUsage();

        Runnable readRunnable = () -> {
            try {
                instance.handleRead(readLock);
                //instance.handleRead(lock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable writeRunnable = () -> {
            try {
                instance.handleWrite(writeLock, new Random().nextInt());
                //instance.handleWrite(lock, new Random().nextInt());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 17; i++) {
            new Thread(readRunnable).start();
        }

        for (int i = 10; i < 12; i++) {
            new Thread(writeRunnable).start();
        }

    }
}

package lang.concurrency.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Usage implements Runnable {
    private static ReentrantLock lock = new ReentrantLock();
    private static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            lock.lock();
            try {
                i++;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Usage instance = new Usage();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);

        t1.start(); t2.start();
        t1.join(); t2.join();
        System.out.println(i);
    }
}

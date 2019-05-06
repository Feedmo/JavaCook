package lang.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreUsage implements Runnable {
    // 表明允许5个线程同时进入临界区
    private Semaphore semaphore = new Semaphore(5);

    @Override
    public void run() {
        try {
            semaphore.acquire();
            Thread.sleep(1000);

            System.out.println(Thread.currentThread().getId() + " done!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(20);
        SemaphoreUsage su = new SemaphoreUsage();

        for (int i = 0; i < 20; i++) {
            es.submit(su);
        }
    }
}

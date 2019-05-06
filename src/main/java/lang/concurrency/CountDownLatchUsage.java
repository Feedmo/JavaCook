package lang.concurrency;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CountDownLatchUsage implements Runnable {
    private static CountDownLatch end = new CountDownLatch(10);
    private static AtomicInteger j = new AtomicInteger(0);

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10) * 100);
            System.out.println(j.incrementAndGet() + " check complete");
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        CountDownLatchUsage instance = new CountDownLatchUsage();

        for (int i = 0; i < 10; i++) {
            es.submit(instance);
        }

        end.await();
        System.out.println("fire!");
        es.shutdown();
    }
}

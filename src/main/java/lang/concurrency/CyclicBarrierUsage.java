package lang.concurrency;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierUsage {
    static class Soldier implements Runnable {
        private String soldier;
        private CyclicBarrier cyclicBarrier;

        Soldier(String soldier, CyclicBarrier cyclicBarrier) {
            this.soldier = soldier;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                cyclicBarrier.await();
                doWork();
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        void doWork() {
            try {
                int sleepTime = new Random().nextInt(10) * 100;
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(soldier + " finished task");
        }
    }

    static class BarrierRun implements Runnable {
        boolean flag;
        int N;

        BarrierRun(int n) {
            N = n;
        }

        @Override
        public void run() {
            if (flag) {
                System.out.println("general: " + N + " soldiers finished work");
            } else {
                System.out.println("general: " + N + " soldiers gathered\n-----------------------");
                flag = true;
            }
        }
    }

    public static void main(String[] args) {
        int N = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new BarrierRun(N));
        System.out.println("get start!");

        for (int i = 1; i <= N; i++) {
            System.out.println("solider " + i + " arrived");
            Thread t = new Thread(new Soldier("solider_" + i, cyclicBarrier));
            t.start();

            // mark 下面的打断会导致1个InterruptedException和9个BrokenBarrierException
            if (i == 5) {
                t.interrupt();
            }
        }
    }
}

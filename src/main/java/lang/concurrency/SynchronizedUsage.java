package lang.concurrency;

/**
 * volatile只能保证一个线程修改数据之后，其他线程能看到这个改动，当有多个线程同时修改一个数据时还是会发生冲突
 */
public class SynchronizedUsage implements Runnable {
    private static final SynchronizedUsage su = new SynchronizedUsage();
    private static int i = 0;

    // 如果没有设定同步代码块，IDEA会提示 Non-atomic operation on volatile field
    /*void increase() {
        i++;
    }*/

    private void increase() {
        synchronized (su) {
            i++;
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedUsage su = new SynchronizedUsage();
        Thread t1 = new Thread(su);
        Thread t2 = new Thread(su);
        t1.start(); t2.start();
        t1.join(); t2.join();

        // 若没有对变量i进行线程并发控制，线程对数据的修改可能会相互覆盖，导致最终i的值会小于2000
        System.out.println(i);
    }
}

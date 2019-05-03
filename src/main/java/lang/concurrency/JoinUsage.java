package lang.concurrency;

public class JoinUsage {
    private static int i = 0;

    static class AddThread extends Thread {
        @Override
        public void run() {
            while (i < 100000) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new AddThread();
        t.start();

        // 让调用线程(main线程)等待t执行完成
        t.join();
        System.out.println(i);
    }
}

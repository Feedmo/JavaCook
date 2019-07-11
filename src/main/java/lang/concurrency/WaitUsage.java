package lang.concurrency;

public class    WaitUsage {
    private final static Object object = new Object();

    static class T1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + " T1 start!");
                try {
                    System.out.println(System.currentTimeMillis()+" T1 wait for object");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis()+" T1 end");
            }
        }
    }

    static class T2 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + " T2 start!");
                object.notify();
                System.out.println(System.currentTimeMillis() + " T2 end!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * console output:
     *  1556790478503 T1 start!
     *  1556790478503 T1 wait for object
     *  1556790478503 T2 start!
     *  1556790478503 T2 end!
     *      // time interval 2 seconds
     *  1556790480519 T1 end
     */
    public static void main(String[] args) {
        new T1().start();
        new T2().start();
    }
}

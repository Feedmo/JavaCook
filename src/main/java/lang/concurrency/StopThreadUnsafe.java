package lang.concurrency;

/**
 * Thread.stop()强制停止当前线程的特性可能会造成的数据不一致
 */
public class StopThreadUnsafe {
    private static final User user = new User();

    static class User {
        private int id;
        private String name;

        User() {
            id = 1;
            name = "1";
        }

        int getId() {
            return id;
        }

        void setId(int id) {
            this.id = id;
        }

        String getName() {
            return name;
        }

        void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return user.getId() + ": " + user.getName();
        }
    }

    static class ChangeObjectThread extends Thread {
        volatile boolean stopMe = false;

        public void stopMe() {
            stopMe = true;
        }

        @Override
        public void run() {
            while (true) {
                // 利用标志变量来决定是否结束线程，从而不会破坏对象数据
                if (stopMe) {
                    System.out.println("exit by stopMe");
                    break;
                }
                synchronized (user) {
                    int v = (int) (System.currentTimeMillis() / 1000);
                    // 如果在user设置两个属性之间被执行stop, 那么会造成name属性没有修改，导致数据不一致
                    user.setId(v);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user.setName(String.valueOf(v));
                }
                // 主动让出持有的对象锁
                Thread.yield();
            }
        }
    }

    static class ReadObjectThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (user) {
                    if (user.getId() != Integer.parseInt(user.getName())) {
                        System.out.println(user.toString());
                    }
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReadObjectThread().start();
        for (int i = 0; i < 10; i++) {
            Thread t = new ChangeObjectThread();
            t.start();
            Thread.sleep(200);
            t.stop();
        }
    }
}

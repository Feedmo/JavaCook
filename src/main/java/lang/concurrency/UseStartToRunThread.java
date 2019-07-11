package lang.concurrency;

/**
 * 当直接调用run时相当于在当前线程调用了普通方法run()，只有调用start才会创建新线程去执行run方法
 */
public class UseStartToRunThread {
    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        //t.run();  // print main
        t.start();
    }
}

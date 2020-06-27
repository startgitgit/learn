package thread;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/6/27 21:41
 */

public class Deadlock {
    public static final String LOCK_1 = "lock1";
    public static final String LOCK_2 = "lock2";

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            try {
                synchronized (Deadlock.LOCK_1) {
                    System.out.println(Thread.currentThread().getName() + "锁住 " + LOCK_1);
                    Thread.sleep(1000);
                    synchronized (Deadlock.LOCK_2) {
                        System.out.println(Thread.currentThread().getName() + "锁住 " + LOCK_2);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "thread-1");

        Thread b = new Thread(() -> {
            try {
                synchronized (Deadlock.LOCK_2) {
                    System.out.println(Thread.currentThread().getName() + "锁住 " + LOCK_2);
                    Thread.sleep(1000);
                    synchronized (Deadlock.LOCK_1) {
                        System.out.println(Thread.currentThread().getName() + "锁住 " + LOCK_1);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "thread-2");

        a.start();
        b.start();
    }
}
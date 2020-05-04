package reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/5/4 13:53
 */
public class ReentrantLockTest2 {
    private static final Lock LOCK = new ReentrantLock(true);
    private static int num = 2;

    public static void main(String[] args) {
        new Thread(ReentrantLockTest2::test, "线程A").start();
        new Thread(ReentrantLockTest2::test, "线程B").start();
        new Thread(ReentrantLockTest2::test, "线程C").start();
        new Thread(ReentrantLockTest2::test, "线程D").start();
    }

    public static void test() {
        String threadName = Thread.currentThread().getName();
        for (int i = 0; i < num; i++) {
            LOCK.lock();
            try {
                System.out.println(threadName + "获取了锁");
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
                System.out.println(threadName + "释放了锁");
            }
        }
    }
}

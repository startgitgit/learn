package reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/5/4 13:53
 */
public class ReentrantLockTest {
    private static final Lock LOCK = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(ReentrantLockTest::test, "线程A").start();
        new Thread(ReentrantLockTest::test, "线程B").start();
    }

    public static void test() {
        String threadName = Thread.currentThread().getName();
        LOCK.lock();
        try {
            System.out.println(threadName + "获取了锁");
            TimeUnit.SECONDS.sleep(50);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
            System.out.println(threadName + "释放了锁");
        }
    }
}

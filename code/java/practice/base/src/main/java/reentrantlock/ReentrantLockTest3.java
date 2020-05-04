package reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/5/4 14:37
 */
public class ReentrantLockTest3 {
    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadDemo(lock1, lock2), "线程A");
        Thread thread2 = new Thread(new ThreadDemo(lock2, lock1), "线程B");
        thread.start();
        thread2.start();
        Thread thread3 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(100);
                thread2.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread3.start();
    }

    static class ThreadDemo implements Runnable {
        Lock firstLock;
        Lock secondLock;

        public ThreadDemo(Lock firstLock, Lock secondLock) {
            this.firstLock = firstLock;
            this.secondLock = secondLock;
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            try {
                firstLock.lockInterruptibly();
                System.out.println(threadName + "获取了锁");
                TimeUnit.SECONDS.sleep(50);
                secondLock.lockInterruptibly();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                firstLock.unlock();
                secondLock.unlock();
                System.out.println(Thread.currentThread().getName() + "获取到了资源，正常结束");
            }
        }
    }
}

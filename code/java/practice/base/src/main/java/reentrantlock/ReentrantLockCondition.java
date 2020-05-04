package reentrantlock;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/5/4 14:37
 */
public class ReentrantLockCondition {
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadDemo(lock,condition), "线程A");
        thread.start();
        CompletableFuture.runAsync(() -> {
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(5);
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });

    }

    static class ThreadDemo implements Runnable {
        Lock lock;
        Condition condition;

        public ThreadDemo(Lock lock,Condition condition) {
            this.lock = lock;
            this.condition = condition;
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();

            try {
                this.lock.lock();
                System.out.println(threadName + "释放锁，进入等待");
                this.condition.await();
                System.out.println(threadName + "被唤醒，等待结束");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + "获取到了资源，正常结束");
            }
        }
    }
}

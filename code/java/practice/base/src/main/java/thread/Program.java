package thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import javax.annotation.PostConstruct;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Program {
    public static void main(String[] args) {
        int count = 15;
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("thread-pool-%d").build();
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                        new ArrayBlockingQueue<Runnable>(5), threadFactory);

        for (int i = 0; i < count; i++) {
            MyTask myTask = new MyTask(i);
            threadPoolExecutor.execute(myTask);
            System.out.println("线程池中线程数目：" + threadPoolExecutor.getPoolSize() + "，队列中等待执行的任务数目：" +
                    threadPoolExecutor.getQueue().size() + "，已执行玩别的任务数目：" + threadPoolExecutor.getCompletedTaskCount());
        }
        threadPoolExecutor.shutdown();
    }
}

class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }


    @Override
    public void run() {
        System.out.println("当前线程名称：" + Thread.currentThread().getName());
        System.out.println("正在执行task " + taskNum);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task " + taskNum + "执行完毕");
    }
}
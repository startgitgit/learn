package thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadService {
    private ThreadPoolExecutor threadPoolExecutor;
    private static final ThreadService INSTANCE = new ThreadService();

    private ThreadService() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("thread-pool-%d").build();
        threadPoolExecutor = new ThreadPoolExecutor(5, 15, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5), threadFactory);
    }

    public void excute(Runnable task) {
        threadPoolExecutor.execute(task);
        System.out.println(
                "线程池中线程数目：" + threadPoolExecutor.getPoolSize()
                        + "，队列中等待执行的任务数目：" + threadPoolExecutor.getQueue().size()
                        + "，已执行玩别的任务数目：" + threadPoolExecutor.getCompletedTaskCount()
        );

    }

    public static ThreadService getInstance() {
        return INSTANCE;
    }

    public void shutdown() {
        threadPoolExecutor.shutdown();
    }

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }

}


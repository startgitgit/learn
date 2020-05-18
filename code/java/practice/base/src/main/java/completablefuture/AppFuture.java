package completablefuture;


import thread.ThreadService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: zhouyq
 * @Date: 2019/2/24 11:08
 * @Version 1.0
 * @Description
 */
public class AppFuture {

    private static ThreadService threadService = ThreadService.getInstance();

    public Double completableFutureTest1() {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        Runnable runnable = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            futurePrice.complete(23.55d);
        };

        threadService.excute(runnable);

        // do anything you want, 当前线程不被阻塞
        System.out.println(111);

        //线程任务完成的话，执行回调函数，不阻塞后续操作
        futurePrice.whenComplete((aDouble, throwable) -> {
            System.out.println(aDouble);
        });

        try {
            return futurePrice.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void completableFutureTest2() {
        CompletableFuture<Integer> future = CompletableFuture.
                supplyAsync(AppFuture::getInteger).thenApplyAsync(i -> i /0).
                whenComplete((i, throwable) -> System.out.println("result:" + i));
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    private static Integer getInteger() {
        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 1;
    }


    void completableFutureTest3() {
        long start = System.currentTimeMillis();
        // 结果集
        List<String> list = new ArrayList<>();
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor threadPoolExecutor = threadService.getThreadPoolExecutor();
        List<Integer> taskList = Arrays.asList(2, 1, 3, 4, 5, 6, 7, 8, 9, 10);
        // 全流式处理转换成CompletableFuture[]+组装成一个无返回值CompletableFuture，join等待执行完毕。返回结果whenComplete获取
        CompletableFuture[] completableFutures = taskList.stream()
                .map(integer -> CompletableFuture.supplyAsync(() -> calc(integer), threadPoolExecutor)
                        .thenApply(h -> Integer.toString(h))
                        .whenComplete((s, e) -> {
                            System.out.println("任务" + s + "完成!result=" + s + "，异常 e=" + e + "," + new Date());
                            list.add(s);
                        })
                ).toArray(CompletableFuture[]::new);
        // 封装后无返回值，必须自己whenComplete()获取
        CompletableFuture.allOf(completableFutures).join();
        System.out.println("list=" + list + ",耗时=" + (System.currentTimeMillis() - start));
    }

    public static Integer calc(Integer i) {
        try {
            if (i == 1) {
                Thread.sleep(3000);
            } else if (i == 5) {
                Thread.sleep(5000);
                return 5/0;
            } else {
                Thread.sleep(1000);
            }
            System.out.println("task线程：" + Thread.currentThread().getName()
                    + "任务i=" + i + ",完成！+" + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i;
    }

}

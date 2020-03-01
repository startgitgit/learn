package completableFuture;
import org.apache.sis.internal.jaxb.metadata.EX_Extent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: zhouyq
 * @Date: 2019/2/24 11:08
 * @Version 1.0
 * @Description
 */
public class Program {


    public static void main(String[] args) {
//        completableFutureTest1();
        System.out.println("start");
        completableFutureTest2();

        System.out.println("end");
    }

    private static void completableFutureTest2() {
        CompletableFuture<Integer> future = CompletableFuture.
                supplyAsync(Program::getInteger).thenApplyAsync(i -> i * 10).
                whenComplete((i, e) -> System.out.println(e.getMessage()));

        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    @NotNull
    private static Integer getInteger() {
        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 1 / 0;
    }

    private static void completableFutureTest1() {
        CompletableFuture<Double> futurePrice = getPriceAsync();

        //do anything you want, 当前线程不被阻塞
        System.out.println(111);

        //线程任务完成的话，执行回调函数，不阻塞后续操作
        futurePrice.whenComplete((aDouble, throwable) -> {
            System.out.println(aDouble);
            //do something else
        });
    }

    static CompletableFuture<Double> getPriceAsync() {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            futurePrice.complete(23.55);
        }).start();
        return futurePrice;
    }

    static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void other() {
        long start = System.currentTimeMillis();
        // 结果集
        List<String> list = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Integer> taskList = Arrays.asList(2, 1, 3, 4, 5, 6, 7, 8, 9, 10);
        // 全流式处理转换成CompletableFuture[]+组装成一个无返回值CompletableFuture，join等待执行完毕。返回结果whenComplete获取
        CompletableFuture[] cfs = taskList.stream()
                .map(integer -> CompletableFuture.supplyAsync(() -> calc(integer), executorService)
                        .thenApply(h -> Integer.toString(h))
                        .whenComplete((s, e) -> {
                            System.out.println("任务" + s + "完成!result=" + s + "，异常 e=" + e + "," + new Date());
                            list.add(s);
                        })
                ).toArray(CompletableFuture[]::new);
        // 封装后无返回值，必须自己whenComplete()获取
        CompletableFuture.allOf(cfs).join();
        System.out.println("list=" + list + ",耗时=" + (System.currentTimeMillis() - start));
    }

    public static Integer calc(Integer i) {
        try {
            if (i == 1) {
                Thread.sleep(3000);//任务1耗时3秒
            } else if (i == 5) {
                Thread.sleep(5000);//任务5耗时5秒
            } else {
                Thread.sleep(1000);//其它任务耗时1秒
            }
            System.out.println("task线程：" + Thread.currentThread().getName()
                    + "任务i=" + i + ",完成！+" + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i;
    }

}

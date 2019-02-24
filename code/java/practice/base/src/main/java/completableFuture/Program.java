package completableFuture;
import org.apache.sis.internal.jaxb.metadata.EX_Extent;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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

    private static void completableFutureTest2(){
        CompletableFuture<Integer> future = CompletableFuture.
                supplyAsync(Program::getInteger).thenApplyAsync(i -> i *10 ).
                whenComplete((i, e) -> System.out.println(e.getMessage()));

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    @NotNull
    private static Integer getInteger()  {
        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 1/0;
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

    static void  sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


package datastruct;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/5/4 11:54
 */
public class Program {
    public static void main(String[] args) throws InterruptedException {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        System.out.println(list.poll());

        ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<>(16);
        CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            abq.add("e");
        });

        System.out.println(abq.take());
    }
}

package thread;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class MultilThreadSyncTest {

    @Test
    public void test() {
        MultilThreadSync<String> multilThreadSync = new MultilThreadSync<>();

        // 消费者
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    String s = multilThreadSync.get();
                    System.out.println(s);
                }

            }, "c" + i);
            thread.start();
        }

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 生产者
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 25; j++) {
                    multilThreadSync.put(Thread.currentThread().getName() + " " + j);
                }
            }, "p" + i);
            thread.start();
        }

        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
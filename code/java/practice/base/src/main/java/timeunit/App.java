package timeunit;

import java.util.concurrent.TimeUnit;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/6/27 18:00
 */
public class App {
    public static void main(String[] args) {
        System.out.println(TimeUnit.DAYS.toHours(1));
        System.out.println(TimeUnit.HOURS.toMillis(1));
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println("sleep end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

    }
}

package thread;

import org.junit.Test;

public class ThreadSerivceTest {

    @Test
    public void excute() {
        for (int i = 0; i < 10; i++) {
            MyTask myTask = new MyTask(i);
            ThreadSerivce.getInstance().excute(myTask);
        }
    }
}
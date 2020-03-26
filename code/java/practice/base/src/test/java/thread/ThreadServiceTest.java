package thread;

import org.junit.Test;

public class ThreadServiceTest {

    @Test
    public void excute() {
        for (int i = 0; i < 10; i++) {
            MyTask myTask = new MyTask(i);
            ThreadService.getInstance().excute(myTask);
        }
    }
}
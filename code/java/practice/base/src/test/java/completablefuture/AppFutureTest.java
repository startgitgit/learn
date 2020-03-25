package completablefuture;

import org.junit.Assert;
import org.junit.Test;

public class AppFutureTest {

    @Test
    public void test() {
        AppFuture appFuture = new AppFuture();
        Assert.assertEquals(appFuture.completableFutureTest1(),23.55d,0);
        appFuture.completableFutureTest2();
    }

}
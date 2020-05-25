package singleton;

import org.junit.Test;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/5/25 19:33
 */
public class SingleTonHungryTest {

    @Test
    public void getInstance() {
        SingleTonHungry singleTonHungry = SingleTonHungry.getInstance();
    }
}
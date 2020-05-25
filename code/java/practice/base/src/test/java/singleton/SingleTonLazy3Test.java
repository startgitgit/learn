package singleton;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/5/25 20:20
 */
public class SingleTonLazy3Test {

    @Test
    public void getInstance() {
        SingleTonLazy3 instance = SingleTonLazy3.getInstance();
        SingleTonLazy3 instance1 = SingleTonLazy3.getInstance();
    }
}
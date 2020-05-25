package singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/5/25 19:29
 */
public class SingleTonHungry {
    private Map<String, String> map = new HashMap<>();
    private static SingleTonHungry singleTon = new SingleTonHungry();

    private SingleTonHungry() {
        map.put("a", "a");
    }

    public static SingleTonHungry getInstance() {
        return singleTon;
    }
}
